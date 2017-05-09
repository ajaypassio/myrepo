
package com.virgin.ecommerce.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jayway.jsonpath.JsonPath;
import com.virgin.ecommerce.model.Price;
import com.virgin.ecommerce.model.Product;

/**
 * <p>
 * Helper class for Product Catalog. This class contains helper functions required for processing product catalog by ProductCatalogService.
 * </p>
 * .
 *
 * @project EcommerceService
 * 
 */
@Component
public class ProductCatalogHelper {

    @Autowired
    NodeHelper            nodeHelper;

    @Autowired
    EcommerceHelper       ecommerceHelper;

    /** The mapper. */
    @Autowired
    ObjectMapper          mapper;

    private static Logger log = LoggerFactory.getLogger(ProductCatalogHelper.class);

    /**
     * @param pElementsListNode
     * @throws Throwable
     */

    public JsonNode processNodetoResponseNode( ArrayNode elementsListNode, String category) throws Throwable {

        JsonNode childNode = mapper.createObjectNode();
        ArrayNode devicesArrayNode = mapper.createArrayNode();

        if (category.contains("devices")) {

            log.info("No of Categories" + elementsListNode.size());
            for ( int i = 0; i < elementsListNode.size(); i++) {

                log.info("Category Name" + elementsListNode.get(i).get("name"));

                LinkedHashMap<String, LinkedHashMap<String, List<Product>>> typesMap = processDevicesNodeToCollection(
                        nodeHelper.getFilteredArrayNode(elementsListNode.get(i), null, null), category);
                devicesArrayNode.add(renderJsonNodeFromCollection(elementsListNode.get(i), typesMap));
                ((ObjectNode) childNode).put(category, devicesArrayNode);

            }

        } else if (category.contains("accessories")) {

            childNode = renderAccessoriesJsonNode(elementsListNode);

            /*
             * to be used when we need color based grouping in accessories page LinkedHashMap<String, ArrayList<JsonNode>> accessoriesMap =
             * processAccessoriesNodeToCollection(elementsListNode, mapper, category); ObjectNode finalNode = renderAccessoriesJsonNodeFromMap(accessoriesMap,
             * mapper, root);
             */

        } else if (category.contains("accordion")) {

            childNode = renderPlansJsonNode(elementsListNode);

        } else if (category.contains("InternationalCalling")) {

            childNode = renderInternationalCallsJsonNode(elementsListNode);

        } else if (category.contains("InternationalRoaming")) {

            childNode = renderInternationalRoamingJsonNode(elementsListNode);

        }

        return childNode;
    }

    /**
     * @param category
     * @param pProductsNode
     * @throws Throwable
     */

    private LinkedHashMap<String, LinkedHashMap<String, List<Product>>> processDevicesNodeToCollection( JsonNode productsListNode, String category)
            throws Exception {
        log.info("No of Variants" + productsListNode.size());

        LinkedHashMap<String, LinkedHashMap<String, List<Product>>> typesMap = new LinkedHashMap<String, LinkedHashMap<String, List<Product>>>();

        LinkedHashMap<String, List<Product>> colorsMap = null;
        List<Product> sortedList = new ArrayList<Product>();
        sortedList = nodeHelper.sortCollection(productsListNode, sortedList, Product.DisplayOrderComparator);
        for ( int productsSize = 0; productsSize < sortedList.size(); productsSize++) {
            List<Product> products = null;
            Product productBean = sortedList.get(productsSize);
            productBean = modifyProductStructure(productBean);

            String color = productBean.getColor();
            String type = productBean.getType();
            log.debug("the types are " + type);
            if (typesMap.containsKey(type)) {

                colorsMap = typesMap.get(type);

                if (!(colorsMap.containsKey(color))) {

                    products = new ArrayList<Product>();
                    products.add(productBean);
                    colorsMap.put(color, products);

                } else {

                    products = colorsMap.get(color);

                    products.add(productBean);

                }

            } else {

                colorsMap = new LinkedHashMap<String, List<Product>>();
                products = new ArrayList<Product>();
                products.add(productBean);
                colorsMap.put(color, products);
                typesMap.put(type, colorsMap);
            }

        }
        return typesMap;

    }

    private Product modifyProductStructure( Product productBean) {
        String shortDescription = productBean.getShortDescription();
        String shortDescSplitted[] = shortDescription.split("\\|");

        String color = shortDescSplitted[0].trim();

        String memory = shortDescSplitted[1];
        boolean isPreLoved = !(shortDescSplitted[2].trim()).equalsIgnoreCase("New");

        productBean.setColor(color);
        productBean.setMemory(memory);
        productBean.setIsPreLoved((isPreLoved));
        productBean.setType(isPreLoved ? "Pre-loved" : "New");
        String longDescription = productBean.getLongDescription();
        String longDescriptionSplitted[] = longDescription.split("\\|");
        String longDescriptionOnly = longDescriptionSplitted[0];
        String Specs = longDescriptionSplitted[2].trim();
        String Features = longDescriptionSplitted[1].trim();
        productBean.setSpecs(Specs);
        productBean.setFeatures(Features);
        productBean.setLongDescription((longDescriptionOnly));

        productBean.setIconUrl("https://openclipart.org/image/120px/svg_to_png/194077/Placeholder.png");

        Price price = new Price();

        price.setCurrency(productBean.getRetailPrice().getCurrency());
        price.setTotalInstallments("XX");
        price.setAmount("XX");
        price.setCycle("XX");

        productBean.setInstallmentPrice(price);

        return productBean;
    }

    private JsonNode renderJsonNodeFromCollection( JsonNode pJsonNode, LinkedHashMap<String, LinkedHashMap<String, List<Product>>> typesMap) {
        ((ObjectNode) pJsonNode).remove("products");
        ((ObjectNode) pJsonNode).remove("subcategories");
        ((ObjectNode) pJsonNode).put("deviceId", pJsonNode.get("id").asText());
        ((ObjectNode) pJsonNode).remove("id");
        Iterator typesMapIterator = typesMap.keySet().iterator();
        ArrayNode typesNode = mapper.createArrayNode();
        while (typesMapIterator.hasNext()) {
            JsonNode colorsNode = mapper.createObjectNode();
            ArrayNode colorsArrayNode = mapper.createArrayNode();
            LinkedHashMap<String, List<Product>> colorsMap = new LinkedHashMap<String, List<Product>>();

            String typesMapkey = (String) typesMapIterator.next();
            colorsMap = typesMap.get(typesMapkey);
            log.debug("colors map size" + colorsMap.size());
            Iterator colorsMapIterator = colorsMap.keySet().iterator();

            while (colorsMapIterator.hasNext()) {
                JsonNode typeNode = mapper.createObjectNode();
                String colorsMapkey = (String) colorsMapIterator.next();
                log.debug("key isss" + colorsMapkey);
                List<Product> products = colorsMap.get(colorsMapkey);

                ArrayNode productsNode = mapper.convertValue(products, ArrayNode.class);

                log.debug("colors Node is" + productsNode);

                ((ObjectNode) typeNode).put("products", productsNode);
                ((ObjectNode) typeNode).put("color", colorsMapkey);
                ((ObjectNode) typeNode).put("warrantyDesc", typesMapkey.equals("New") ? "STUB(Taxes are included at checkout)"
                        : "STUB(1-year AppleCare+ warranty. Taxes are included at checkout)");
                colorsArrayNode.add(typeNode);
            }

            ((ObjectNode) colorsNode).put("type", typesMapkey);
            ((ObjectNode) colorsNode).put("isPreloved", typesMapkey.equals("New") ? false : true);
            ((ObjectNode) colorsNode).put("colors", colorsArrayNode);

            typesNode.add(colorsNode);

        }

        ((ObjectNode) pJsonNode).put("types", typesNode);

        log.debug("types Node is" + pJsonNode);

        return pJsonNode;
    }

    /**
     * to be used in future when we need color based grouping in accessories page
     * 
     * Process accessories node to collection.
     *
     * @param elementsListNode
     *            the elements list node
     * @return the linked hash map< string, array list< json node>>
     * @throws Exception
     *             the exception
     */
    public LinkedHashMap<String, ArrayList<JsonNode>> processAccessoriesNodeToCollection( JsonNode elementsListNode) throws Exception {

        JsonNode prodNodes = null;
        String typeName = null;
        String typeId = null;
        String categoryName = null;

        LinkedHashMap<String, ArrayList<JsonNode>> typeMap = new LinkedHashMap<String, ArrayList<JsonNode>>();
        for ( int j = 0; j < elementsListNode.size(); j++) {

            typeName = elementsListNode.get(j).get("name").asText().trim();
            typeId = elementsListNode.get(j).get("id").asText().trim();

            prodNodes = elementsListNode.get(j).get("products");

            for ( int k = 0; k < prodNodes.size(); k++) {

                String shortDescption = prodNodes.get(k).get("shortDescription").asText();

                if (!(shortDescption.equals("null") || shortDescption == null)) {

                    String[] shortDescSplit = shortDescption.split("\\|");

                    String shortDesc = shortDescSplit[0].toString().trim();

                    String color = shortDescSplit[1].toString().trim();

                    ((ObjectNode) prodNodes.get(k)).put("shortDesc", shortDesc);
                    ((ObjectNode) prodNodes.get(k)).put("color", color);
                    ((ObjectNode) prodNodes.get(k)).put("typeName", typeName);
                    ((ObjectNode) prodNodes.get(k)).put("typeId", typeId);

                } else {

                    ((ObjectNode) prodNodes.get(k)).put("shortDesc", shortDescption);
                    ((ObjectNode) prodNodes.get(k)).put("color", "NA");
                    ((ObjectNode) prodNodes.get(k)).put("typeName", typeName);
                    ((ObjectNode) prodNodes.get(k)).put("typeId", typeId);
                }

                categoryName = prodNodes.get(k).get("name").asText().trim();

                LinkedHashMap<String, ArrayList<JsonNode>> categoryInternalMap = new LinkedHashMap<String, ArrayList<JsonNode>>();

                ArrayList<JsonNode> prodList = new ArrayList<JsonNode>();

                if (!typeMap.containsKey(categoryName)) {
                    prodList.add(prodNodes.get(k));

                    typeMap.put(categoryName, prodList);
                } else {
                    prodList = new ArrayList<JsonNode>();

                    prodList = typeMap.get(categoryName);
                    prodList.add(prodNodes.get(k));

                }

            }

        }

        return typeMap;

    }

    public JsonNode renderJsonNodeFromMap( HashMap<String, ArrayList<JsonNode>> parentMap) throws Throwable {

        JsonNode node = mapper.convertValue(parentMap, JsonNode.class);

        return node;

    }

    //
    /**
     * to be used when we need color based grouping in accessories page
     * 
     * 
     * Render accessories json node from map.
     *
     * @param parentMap
     *            the parent map
     * @return the object node
     */
    public ObjectNode renderAccessoriesJsonNodeFromMap( LinkedHashMap<String, ArrayList<JsonNode>> parentMap) {

        Iterator typeIterator = parentMap.keySet().iterator();

        ObjectNode accessoriesObj = mapper.createObjectNode();
        ArrayNode accessoriesArr = mapper.createArrayNode();
        ObjectNode productNodeObj = null;

        while (typeIterator.hasNext()) {

            ArrayNode productNodeArr = mapper.createArrayNode();
            productNodeObj = mapper.createObjectNode();

            String key = typeIterator.next().toString();

            ArrayList<JsonNode> productsList = parentMap.get(key);

            Product prod = new Product();

            for ( int q = 0; q < productsList.size(); q++) {

                JsonNode productNode = (JsonNode) productsList.get(q);

                productNodeArr.add(productNode);

                prod.setTypeName(productNode.get("typeName").textValue());

                prod.setName(productNode.get("name").textValue());
                prod.setTypeId(productNode.get("typeId").textValue());

            }

            productNodeObj.put("typeId", prod.getTypeId());
            productNodeObj.put("typeName", prod.getTypeName());

            /*
             * String SingleProductNodeVal =
             * JsonPath.parse(root.toString()).read("$..subcategories[?(@.name=='Accessories')].subcategories..products[?(@.name=='"+key+"')]") .toString();
             * JsonNode SingleProductNodeValNode = mapper.readTree(SingleProductNodeVal).get(0); Product product=
             * mapper.readValue(SingleProductNodeValNode.toString(), Product.class);
             */

            productNodeObj.put("productName", prod.getName());
            productNodeObj.put("products", productNodeArr);

            accessoriesArr.add(productNodeObj);

        }

        accessoriesObj.put("accessories", accessoriesArr);

        return accessoriesObj;

    }

    /**
     * Render accessories json node.
     *
     * @param elementsListNode
     *            the elements list node
     * @return the json node
     */
    private JsonNode renderAccessoriesJsonNode( JsonNode elementsListNode) {

        JsonNode prodNodes = null;
        String typeName = null;
        String typeId = null;

        ArrayNode accArr = mapper.createArrayNode();
        JsonNode accObj = mapper.createObjectNode();

        for ( int j = 0; j < elementsListNode.size(); j++) {

            typeName = elementsListNode.get(j).get("name").asText().trim();
            typeId = elementsListNode.get(j).get("id").asText().trim();

            prodNodes = elementsListNode.get(j).get("products");

            for ( int k = 0; k < prodNodes.size(); k++) {

                String shortDescption = prodNodes.get(k).get("shortDescription").asText();

                if (!(shortDescption.equals("null") || shortDescption == null)) {

                    String[] shortDescSplit = shortDescption.split("\\|");

                    String shortDesc = shortDescSplit[0].toString().trim();

                    String color = shortDescSplit[1].toString().trim();

                    ((ObjectNode) prodNodes.get(k)).put("shortDesc", shortDesc);
                    ((ObjectNode) prodNodes.get(k)).put("color", color);
                    ((ObjectNode) prodNodes.get(k)).put("typeName", typeName);
                    ((ObjectNode) prodNodes.get(k)).put("typeId", typeId);

                } else {

                    ((ObjectNode) prodNodes.get(k)).put("shortDesc", shortDescption);
                    ((ObjectNode) prodNodes.get(k)).put("color", "NA");
                    ((ObjectNode) prodNodes.get(k)).put("typeName", typeName);
                    ((ObjectNode) prodNodes.get(k)).put("typeId", typeId);
                }

                accArr.add(prodNodes.get(k));

            }

        }

        ((ObjectNode) accObj).put("accessories", accArr);

        return accObj;

    }

    /**
     * Render accessories json node from map.
     *
     * @param parentMap
     *            the parent map
     * @param root
     *            the root
     * @return the object node
     * @throws JsonProcessingException
     *             the json processing exception
     * @throws IOException
     *             the IO exception
     */
    public ObjectNode renderAccessoriesJsonNodeFromMap( HashMap<String, HashMap<String, ArrayList<JsonNode>>> parentMap, JsonNode root)
            throws JsonProcessingException, IOException {

        Iterator typeMapIterator = parentMap.keySet().iterator();

        ArrayNode accArr = mapper.createArrayNode();
        ObjectNode accObj = mapper.createObjectNode();

        while (typeMapIterator.hasNext()) {

            String typeKey = (String) typeMapIterator.next();

            HashMap productMap = parentMap.get(typeKey);

            Iterator productMapIterator = productMap.keySet().iterator();

            String productKey = null;

            ArrayNode typeNodeArr = mapper.createArrayNode();
            ObjectNode typeNodeObj = mapper.createObjectNode();

            while (productMapIterator.hasNext()) {

                productKey = (String) productMapIterator.next();

                ArrayList<JsonNode> products = (ArrayList<JsonNode>) productMap.get(productKey);

                ArrayNode productNodeArr = mapper.createArrayNode();
                ObjectNode productNodeObj = mapper.createObjectNode();

                for ( int q = 0; q < products.size(); q++) {

                    JsonNode productNode = (JsonNode) products.get(q);

                    productNodeArr.add(productNode);

                }

                productNodeObj.put(productKey, productNodeArr);

                typeNodeArr.add(productNodeObj);

            }

            String typeId = JsonPath.parse(root.toString()).read("$..subcategories[?(@.name=='Accessories')].subcategories[?(@.name=='" + typeKey + "')].id")
                    .toString();

            JsonNode typeid = mapper.readTree(typeId).get(0);
            typeNodeObj.put("typeId", typeid);
            typeNodeObj.put(typeKey, typeNodeArr);
            accArr.add(typeNodeObj);

            log.info("******** accArr" + accArr);

        }

        accObj.put("accessories", accArr);

        return accObj;

    }

    /**
     * Gets the shop plan - accordion list node.
     *
     * @param rootNode
     *            the root node
     * @return the accordion list node
     * @throws Exception
     *             the exception
     */
    public ArrayNode getAccordionListNode( JsonNode rootNode) throws Exception {
        return getAccesoriesArrayNode(rootNode);

    }

    /**
     * Gets the accordion array node.
     *
     * @param root
     *            the root
     * @return the accordion array node
     * @throws Exception
     *             the exception
     */
    public ArrayNode getAccordionArrayNode( JsonNode root) throws Exception {

        ArrayNode categoryNode = (ArrayNode) root.path("subcategories");

        return categoryNode;
    }

    /**
     * Gets the accordion its on.
     *
     * @param authToken
     *            the auth token
     * @return the accordion its on
     * @throws Throwable
     *             the throwable
     */
    public String getAccordionItsOn( String authToken) throws Throwable {

        RestTemplate restTemplate = ecommerceHelper.getRestTemplate();
        String url = "https://api.stg.itsonsaas.net/api/1.0/catalogs/Accordion";

        HttpHeaders headers = new HttpHeaders();
        // headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Content-Type", "application/json");
        headers.add("X-Io-Request-Id", ecommerceHelper.getRandomUUID());
        headers.add("Authorization", authToken);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        HttpEntity resp = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        log.info("response : " + resp.getBody().toString());
        String respJson = resp.getBody().toString();

        return respJson;
    }

    /**
     * Process nodeto response node.
     *
     * @param elementsListNode
     *            the elements list node
     * @param category
     *            the category
     * @param root
     *            the root
     * @return the object node
     * @throws Exception
     *             the exception
     */
    public ObjectNode processNodetoResponseNode( ArrayNode elementsListNode, String category, JsonNode root) throws Exception {

        ObjectNode finalNode = renderAccessoriesJsonNode(elementsListNode, category, root);

        /*
         * to be used when we need color based grouping in accessories page LinkedHashMap<String, ArrayList<JsonNode>> accessoriesMap =
         * processAccessoriesNodeToCollection(elementsListNode, mapper, category); ObjectNode finalNode = renderAccessoriesJsonNodeFromMap(accessoriesMap,
         * mapper, root);
         */

        return finalNode;

    }

    // to be used when we need color based grouping in accessories page
    private LinkedHashMap<String, ArrayList<JsonNode>> processAccessoriesNodeToCollection( JsonNode elementsListNode, String category) throws Exception {

        JsonNode prodNodes = null;
        String typeName = null;
        String typeId = null;
        String categoryName = null;

        LinkedHashMap<String, ArrayList<JsonNode>> typeMap = new LinkedHashMap<String, ArrayList<JsonNode>>();
        for ( int j = 0; j < elementsListNode.size(); j++) {

            typeName = elementsListNode.get(j).get("name").asText().trim();
            typeId = elementsListNode.get(j).get("id").asText().trim();

            prodNodes = elementsListNode.get(j).get("products");

            for ( int k = 0; k < prodNodes.size(); k++) {

                String shortDescption = prodNodes.get(k).get("shortDescription").asText();

                if (!(shortDescption.equals("null") || shortDescption == null)) {

                    String[] shortDescSplit = shortDescption.split("\\|");

                    String shortDesc = shortDescSplit[0].toString().trim();

                    String color = shortDescSplit[1].toString().trim();

                    ((ObjectNode) prodNodes.get(k)).put("shortDesc", shortDesc);
                    ((ObjectNode) prodNodes.get(k)).put("color", color);
                    ((ObjectNode) prodNodes.get(k)).put("typeName", typeName);
                    ((ObjectNode) prodNodes.get(k)).put("typeId", typeId);

                } else {

                    ((ObjectNode) prodNodes.get(k)).put("shortDesc", shortDescption);
                    ((ObjectNode) prodNodes.get(k)).put("color", "NA");
                    ((ObjectNode) prodNodes.get(k)).put("typeName", typeName);
                    ((ObjectNode) prodNodes.get(k)).put("typeId", typeId);
                }

                categoryName = prodNodes.get(k).get("name").asText().trim();

                LinkedHashMap<String, ArrayList<JsonNode>> categoryInternalMap = new LinkedHashMap<String, ArrayList<JsonNode>>();

                ArrayList<JsonNode> prodList = new ArrayList<JsonNode>();

                if (!typeMap.containsKey(categoryName)) {
                    prodList.add(prodNodes.get(k));

                    typeMap.put(categoryName, prodList);
                } else {
                    prodList = new ArrayList<JsonNode>();

                    prodList = typeMap.get(categoryName);
                    prodList.add(prodNodes.get(k));

                }

            }

        }

        return typeMap;

    }

    // to be used when we need color based grouping in accessories page
    private ObjectNode renderAccessoriesJsonNodeFromMap( LinkedHashMap<String, ArrayList<JsonNode>> parentMap, ObjectMapper mapper, JsonNode root) {

        Iterator typeIterator = parentMap.keySet().iterator();

        ObjectNode accessoriesObj = mapper.createObjectNode();
        ArrayNode accessoriesArr = mapper.createArrayNode();
        ObjectNode productNodeObj = null;

        while (typeIterator.hasNext()) {

            ArrayNode productNodeArr = mapper.createArrayNode();
            productNodeObj = mapper.createObjectNode();

            String key = typeIterator.next().toString();

            ArrayList<JsonNode> productsList = parentMap.get(key);

            Product prod = new Product();

            for ( int q = 0; q < productsList.size(); q++) {

                JsonNode productNode = (JsonNode) productsList.get(q);

                productNodeArr.add(productNode);

                prod.setTypeName(productNode.get("typeName").textValue());

                prod.setName(productNode.get("name").textValue());
                prod.setTypeId(productNode.get("typeId").textValue());

            }

            productNodeObj.put("typeId", prod.getTypeId());
            productNodeObj.put("typeName", prod.getTypeName());

            /*
             * String SingleProductNodeVal =
             * JsonPath.parse(root.toString()).read("$..subcategories[?(@.name=='Accessories')].subcategories..products[?(@.name=='"+key+"')]") .toString();
             * JsonNode SingleProductNodeValNode = mapper.readTree(SingleProductNodeVal).get(0); Product product=
             * mapper.readValue(SingleProductNodeValNode.toString(), Product.class);
             */

            productNodeObj.put("productName", prod.getName());
            productNodeObj.put("products", productNodeArr);

            accessoriesArr.add(productNodeObj);

        }

        accessoriesObj.put("accessories", accessoriesArr);
        log.debug(" accessoriesObject " + accessoriesObj);

        return accessoriesObj;

    }

    /**
     * Render accessories json node.
     *
     * @param elementsListNode
     *            the elements list node
     * @param category
     *            the category
     * @param root
     *            the root
     * @return the object node
     */
    private ObjectNode renderAccessoriesJsonNode( JsonNode elementsListNode, String category, JsonNode root) {

        JsonNode prodNodes = null;
        String typeName = null;
        String typeId = null;

        ArrayNode accArr = mapper.createArrayNode();
        ObjectNode accObj = mapper.createObjectNode();

        for ( int j = 0; j < elementsListNode.size(); j++) {

            typeName = elementsListNode.get(j).get("name").asText().trim();
            typeId = elementsListNode.get(j).get("id").asText().trim();

            prodNodes = elementsListNode.get(j).get("products");

            for ( int k = 0; k < prodNodes.size(); k++) {

                String shortDescption = prodNodes.get(k).get("shortDescription").asText();

                if (!(shortDescption.equals("null") || shortDescption == null)) {

                    String[] shortDescSplit = shortDescption.split("\\|");

                    String shortDesc = shortDescSplit[0].toString().trim();

                    String color = shortDescSplit[1].toString().trim();

                    ((ObjectNode) prodNodes.get(k)).put("shortDesc", shortDesc);
                    ((ObjectNode) prodNodes.get(k)).put("color", color);
                    ((ObjectNode) prodNodes.get(k)).put("typeName", typeName);
                    ((ObjectNode) prodNodes.get(k)).put("typeId", typeId);

                } else {

                    ((ObjectNode) prodNodes.get(k)).put("shortDesc", shortDescption);
                    ((ObjectNode) prodNodes.get(k)).put("color", "NA");
                    ((ObjectNode) prodNodes.get(k)).put("typeName", typeName);
                    ((ObjectNode) prodNodes.get(k)).put("typeId", typeId);
                }

                accArr.add(prodNodes.get(k));

            }

        }

        accObj.put("accessories", accArr);

        return accObj;

    }

    /**
     * Gets the accesories list node.
     *
     * @param rootNode
     *            the root node
     * @return the accesories list node
     * @throws Exception
     *             the exception
     */
    public ArrayNode getAccesoriesListNode( JsonNode rootNode) throws Exception {
        return getAccesoriesArrayNode(rootNode);

    }

    /**
     * Gets the accesories array node.
     *
     * @param root
     *            the root
     * @return the accesories array node
     * @throws Exception
     *             the exception
     */
    public ArrayNode getAccesoriesArrayNode( JsonNode root) throws Exception {

        ArrayNode categoryNode = (ArrayNode) root.path("subcategories");

        return categoryNode;
    }

    /**
     * Gets the accordion node.
     *
     * @param rootNode
     *            the root node
     * @return the accordion node
     * @throws Exception
     *             the exception
     */
    public ArrayNode getAccordionNode( JsonNode rootNode) throws Throwable {

        ArrayNode accordionNode = (ArrayNode) rootNode.get("products");

        return accordionNode;
    }

    /**
     * Render plans json node.
     *
     * @param elementsListNode
     *            the elements list node
     * @return the json node
     * @throws JsonParseException
     *             the json parse exception
     * @throws JsonMappingException
     *             the json mapping exception
     * @throws IOException
     *             the IO exception
     */
    private JsonNode renderPlansJsonNode( ArrayNode elementsListNode) throws JsonParseException, JsonMappingException, IOException {

        ObjectNode shopPlanObj = mapper.createObjectNode();
        ObjectNode shopPlanNode = mapper.createObjectNode();

        for ( int q = 0; q < elementsListNode.size(); q++) {
            JsonNode shopPlanList = elementsListNode.get(q);

            log.debug("shopPlanList :" + shopPlanList);

            if (shopPlanList.get("name").toString().contains("Unlimited")) {

                Product shopPlanProd = mapper.readValue(shopPlanList.toString(), Product.class);

                (shopPlanNode).put("productId", shopPlanProd.getProductId().toString());
                (shopPlanNode).put("name", shopPlanProd.getName());
                (shopPlanNode).put("shortDescription", shopPlanProd.getShortDescription());
                (shopPlanNode).put("longDescription", shopPlanProd.getLongDescription());
                (shopPlanNode).put("iconUrl", shopPlanProd.getIconUrl());
                (shopPlanNode).put("retailAmt", shopPlanProd.getRetailPrice().getAmount());
                (shopPlanNode).put("retailCurrency", shopPlanProd.getRetailPrice().getCurrency());
                (shopPlanNode).put("accordion", shopPlanList);

                shopPlanObj.put("shopPlans", shopPlanNode);

                log.debug("shopPlanObj :" + shopPlanObj);
            }
        }

        return shopPlanObj;

    }

    /**
     * Gets the international calls array node.
     *
     * @param root
     *            the root
     * @return the int calls array node
     * @throws Exception
     *             the exception
     */
    public ArrayNode getIntCallsArrayNode( JsonNode root) throws Exception {

        ArrayNode categoryNode = (ArrayNode) root.path("products");

        return categoryNode;
    }

    /**
     * Render international calls json node.
     *
     * @param elementsListNode
     *            the elements list node
     * @return the json node
     * @throws Exception
     *             the exception
     */
    private JsonNode renderInternationalCallsJsonNode( ArrayNode elementsListNode) throws Exception {

        ObjectNode intCallsObj = mapper.createObjectNode();
        ObjectNode intCallsNode = mapper.createObjectNode();
        ArrayNode intCallsArr = mapper.createArrayNode();

        for ( int q = 0; q < elementsListNode.size(); q++) {
            JsonNode intCallSingleNode = elementsListNode.get(q);

            Product intCallSingleProd = mapper.readValue(intCallSingleNode.toString(), Product.class);

            String[] shortDescSplit = intCallSingleProd.getShortDescription().split("\\|");

            if (shortDescSplit[0].toLowerCase().contains("month")) {

                ((ObjectNode) intCallSingleNode).put("planType", "Monthly");

            } else if (shortDescSplit[0].toLowerCase().contains("week")) {

                ((ObjectNode) intCallSingleNode).put("planType", "Weekly");

            } else if (shortDescSplit[0].toLowerCase().contains("year")) {

                ((ObjectNode) intCallSingleNode).put("planType", "Yearly");

            } else if ((shortDescSplit[0].toLowerCase().contains("day")) || (shortDescSplit[0].toLowerCase().contains("daily"))) {

                ((ObjectNode) intCallSingleNode).put("planType", "Daily");

            }

            intCallsArr.add(intCallSingleNode);

        }
        intCallsNode.set("plans", intCallsArr);

        intCallsObj.set("internationalCalls", intCallsNode);

        log.debug("intCallsObj" + intCallsObj);

        return intCallsObj;

    }

    /**
     * Gets the international roam array node.
     *
     * @param root
     *            the root
     * @return the int roam array node
     * @throws Exception
     *             the exception
     */
    public ArrayNode getIntRoamArrayNode( JsonNode root) throws Exception {

        ArrayNode categoryNode = (ArrayNode) root.path("products");

        return categoryNode;
    }

    /**
     * Render international roaming json node.
     *
     * @param elementsListNode
     *            the elements list node
     * @return the json node
     * @throws Exception
     *             the exception
     */
    private JsonNode renderInternationalRoamingJsonNode( ArrayNode elementsListNode) throws Exception {

        ObjectNode intRoamObj = mapper.createObjectNode();
        ObjectNode intRoamNode = mapper.createObjectNode();
        ArrayNode intRoamArr = mapper.createArrayNode();
        JsonNode subPlanTypeNode = mapper.createObjectNode();

        for ( int q = 0; q < elementsListNode.size(); q++) {
            JsonNode intRoamSingleNode = elementsListNode.get(q);
            Product intRoamSingleProd = mapper.readValue(intRoamSingleNode.toString(), Product.class);

            // TODO: REFACTOR BELOW LOGIC
            // Currently the international roaming plan package is hard-coded as Weekly. The logic needs refactoring once the international roaming plan
            // structure get confirmed from ItsOn.

            ((ObjectNode) intRoamSingleNode).remove("retailPrice");
            ((ObjectNode) intRoamSingleNode).remove("shortDescription");
            ((ObjectNode) intRoamSingleNode).remove("longDescription");
            ((ObjectNode) intRoamSingleNode).remove("bundleItems");

            ((ObjectNode) subPlanTypeNode).put("amount", intRoamSingleProd.getRetailPrice().getAmount());
            ((ObjectNode) subPlanTypeNode).put("currency", intRoamSingleProd.getRetailPrice().getCurrency());
            ((ObjectNode) subPlanTypeNode).put("shortDescription", intRoamSingleProd.getShortDescription());
            ((ObjectNode) subPlanTypeNode).put("longDescription", intRoamSingleProd.getLongDescription());
            ((ObjectNode) subPlanTypeNode).put("planType", "Week");
            ((ObjectNode) intRoamSingleNode).put("WeekPlanData", subPlanTypeNode);

            log.debug("subPlanTypeNode" + subPlanTypeNode);

            // REFACTOR ABOVE LOGIC

            intRoamArr.add(intRoamSingleNode);

        }
        intRoamNode.set("plans", intRoamArr);

        intRoamObj.set("internationalRoaming", intRoamNode);

        log.debug("intRoamObj" + intRoamObj);

        return intRoamObj;

    }

}
