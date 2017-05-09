
package com.virgin.ecommerce.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.virgin.ecommerce.helper.EcommerceHelper;
import com.virgin.ecommerce.helper.NodeHelper;
import com.virgin.ecommerce.helper.ProductCatalogHelper;

/**
 * <p>
 * Service class for Product Catalog. This class contains logic for processing product catalog .
 * </p>
 * .
 *
 * @project EcommerceService
 * 
 */
@Service
public class ProductCatalogService {

    @Autowired
    ObjectMapper          mapper;

    @Autowired
    ProductCatalogHelper  productCatalogHelper;

    @Autowired
    EcommerceHelper       ecommerceHelper;

    @Autowired
    @Qualifier( "nodeHelper")
    NodeHelper            nodeProcessor;

    /** The accessories json. */
    @Value( "${ecommerceService.accessories.json.stub}")
    private String        accessoriesJson;

    /** The catalog json. */
    @Value( "${ecommerceService.catalog.json.stub}")
    private String        catalogJson;

    /** The shop plan json. */
    @Value( "${ecommerceService.shopPlans.json.stub}")
    private String        shopPlanStubJson;

    /** The International Calls plan json. */
    @Value( "${ecommerceService.InternationalCallsPlans.json.stub}")
    private String        intCallPlanStubJson;

    /** The International Roam plan json. */
    @Value( "${ecommerceService.InternationalRoamPlans.json.stub}")
    private String        intRoamPlanStubJson;

    /** The log. */
    private static Logger log = LoggerFactory.getLogger(ProductCatalogService.class);

    /**
     * Gets the devices.
     *
     * @param authToken
     *            the auth token
     * @return the devices
     * @throws Throwable
     *             the throwable
     */
    public JsonNode getDevices( String authToken, boolean useStub) throws Throwable {

        JsonNode finalJson;
        if (useStub) {
            log.debug("Using Stub service");
            finalJson = mapper.readTree(catalogJson);
        } else {
            JsonNode rootNode = readItsOnCatalog(authToken);
            finalJson = mapper.createObjectNode();
            String category = "devices";
            JsonNode categoryNode = nodeProcessor.getCategoryNode(rootNode, "name", category);
            ArrayNode elementsListNode = nodeProcessor.getElementListNode(categoryNode, "name", "i-phone");

            ((ObjectNode) finalJson).put("catalog", productCatalogHelper.processNodetoResponseNode(elementsListNode, category));

        }
        log.info("finalJson : " + finalJson);
        return finalJson;

    }

    /**
     * Gets the accessories.
     *
     * @param authToken
     *            the auth token
     * @return the accessories
     * @throws Throwable
     *             the throwable
     */
    public JsonNode getAccessories( String authToken, boolean useStub) throws Throwable {

        JsonNode finalAccessoriesNode = mapper.createObjectNode();

        if (useStub) {
            log.info("Executing Accessories Stub ");

            finalAccessoriesNode = mapper.readTree(accessoriesJson);

        } else {

            log.info("Executing Accessories Actual WS ");
            JsonNode rootNode = readItsOnCatalog(authToken);

            String category = "accessories";
            JsonNode categoryNode = nodeProcessor.getCategoryNode(rootNode, "name", category);

            ArrayNode accessoriesListNode = productCatalogHelper.getAccesoriesListNode(categoryNode);

            JsonNode accNode = productCatalogHelper.processNodetoResponseNode(accessoriesListNode, category);

            log.debug("accNode :" + accNode);

            ((ObjectNode) finalAccessoriesNode).put("catalog", accNode);

        }
        log.debug("finalAccessoriesNode :" + finalAccessoriesNode);
        return finalAccessoriesNode;
    }

    /**
     * Json for shop plan comes as @name='Accordion' Gets the all shop plans.
     *
     * @param authToken
     *            the auth token
     * @return the all shop plans
     * @throws Exception
     * @throws Throwable
     *             the throwable
     */
    public JsonNode getAllShopPlans( String authToken, boolean useStub) throws Throwable {

        JsonNode finalPlanNode = mapper.createObjectNode();
        JsonNode planNode = null;

        if (useStub) {

            log.info("Executing Shop Plan Stub ");
            finalPlanNode = mapper.readTree(shopPlanStubJson);

        } else {

            log.info("Executing Shop Plan Actual WS ");
            String respJson = productCatalogHelper.getAccordionItsOn(authToken);
            JsonNode rootNode = mapper.readTree(respJson);

            log.debug("********** rootNode " + rootNode);

            ArrayNode accordionListNode = productCatalogHelper.getAccordionNode(rootNode);

            log.debug("********** accordionListNode " + accordionListNode);

            planNode = productCatalogHelper.processNodetoResponseNode(accordionListNode, "accordion");

            ((ObjectNode) finalPlanNode).put("catalog", planNode);

            log.debug("************ finalPlanNode :" + finalPlanNode);

        }
        return finalPlanNode;
    }

    /**
     * Gets the product catalog.
     * 
     * @param authToken
     *
     * @return the product catalog
     * @throws Throwable
     */

    public JsonNode readItsOnCatalog( String authToken) throws Throwable {

        JsonNode finalJson = null;

        RestTemplate restTemplate = ecommerceHelper.getRestTemplate();
        String url = "https://api.stg.itsonsaas.net/api/1.0/catalogs/SPECIAL";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("X-Io-Request-Id", ecommerceHelper.getRandomUUID());
        headers.add("Authorization", authToken);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        HttpEntity resp = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        log.info("response : " + resp.getBody().toString());
        finalJson = mapper.readTree(resp.getBody().toString());

        return finalJson;
    }

    /**
     * Gets the product details by product id.
     *
     * @param clientToken
     *            the client token
     * @param productId
     *            the product id
     * @return the product details by product id
     * @throws Throwable
     *             the throwable
     */
    public JsonNode getProductDetailsByProductId( String clientToken, JsonNode productIdList) throws Throwable {
        log.debug("productId : " + productIdList);

        JsonNode catalogResp = readItsOnCatalog(clientToken);
        String productNodeJson = null;

        // productNodeJson = JsonPath.read(catalogResp.toString(), "$.subcategories..products[?(@.productId == '" + productIdList.get(i).asText() +
        // "')]").toString();
        log.debug("productNodeJson : " + productNodeJson);

        ((ObjectNode) catalogResp).removeAll();
        ((ObjectNode) catalogResp).put("productNodeJson", productNodeJson);

        return catalogResp;

    }

    /**
     * Gets the intnl calls plans.
     *
     * @param authToken
     *            the auth token
     * @return the intnl calls plans
     * @throws Throwable
     *             the throwable
     */
    public JsonNode getIntnlCallsPlans( String authToken, boolean useStub) throws Throwable {

        JsonNode finalIntCallNode = mapper.createObjectNode();

        JsonNode IntCallNode = null;

        if (useStub) {
            log.info("Executing International Calling Stub ");
            finalIntCallNode = mapper.readTree(intCallPlanStubJson);

        } else {

            log.info("Executing International Calling Actual WS ");
            JsonNode rootNode = readItsOnCatalog(authToken);

            String category = "International Calls";
            JsonNode categoryNode = nodeProcessor.getCategoryNode(rootNode, "name", category);

            ArrayNode IntCallsListNode = productCatalogHelper.getIntCallsArrayNode(categoryNode);

            log.debug("IntCallsListNode" + IntCallsListNode);

            IntCallNode = productCatalogHelper.processNodetoResponseNode(IntCallsListNode, "InternationalCalling");

            ((ObjectNode) finalIntCallNode).put("catalog", IntCallNode);

        }

        log.debug("finalIntCallPlanNode" + finalIntCallNode);

        return finalIntCallNode;

    }

    /**
     * Gets the intnl roam plans.
     *
     * @param authToken
     *            the auth token
     * @return the intnl roam plans
     * @throws Throwable
     *             the throwable
     */
    public JsonNode getIntnlRoamPlans( String authToken, boolean useStub) throws Throwable {

        JsonNode finalIntRoamNode = mapper.createObjectNode();

        JsonNode IntRoamNode = null;

        if (useStub) {
            log.info("Executing International Roaming Stub ");
            finalIntRoamNode = mapper.readTree(intRoamPlanStubJson);

        } else {

            log.info("Executing International Roaming Actual WS ");
            JsonNode rootNode = readItsOnCatalog(authToken);

            String category = "International Roaming";
            JsonNode categoryNode = nodeProcessor.getCategoryNode(rootNode, "name", category);

            ArrayNode IntRoamListNode = productCatalogHelper.getIntRoamArrayNode(categoryNode);

            log.debug("InternationalRoamListNode" + IntRoamListNode);

            IntRoamNode = productCatalogHelper.processNodetoResponseNode(IntRoamListNode, "InternationalRoaming");

            ((ObjectNode) finalIntRoamNode).put("catalog", IntRoamNode);

        }

        log.debug("finalInternationalRoamPlanNode" + finalIntRoamNode);

        return finalIntRoamNode;

    }

}
