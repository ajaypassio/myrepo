
package com.virgin.ecommerce.helper;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.virgin.ecommerce.model.Product;

/**
 * <p>
 * Helper class for all Node related common operations.
 * </p>
 * .
 *
 * @project EcommerceService
 * 
 */
@Component
public class NodeHelper {

    /** The log. */
    private static Logger log = LoggerFactory.getLogger(NodeHelper.class);

    @Autowired
    ObjectMapper          mapperObj;

    /**
     * Gets the filtered json node.
     *
     * @param root
     *            the root
     * @param fieldName
     *            the field name
     * @param criteria
     *            the criteria
     * @return the filtered json node
     * @throws Exception
     *             the exception
     */
    public JsonNode getFilteredJSONNode( JsonNode root, String fieldName, String criteria) throws Exception {
        JsonNode categoryNode = root.path("subcategories");
        if (categoryNode.size() != 0) {

        } else {
            categoryNode = root.path("products");

        }
        if (criteria != null) {
            for ( int i = 0; i < categoryNode.size(); i++) {

                String name = categoryNode.get(i).path(fieldName).asText();
                if (name.equalsIgnoreCase(criteria)) {
                    categoryNode = categoryNode.get(i);
                    break;

                }
            }
        }
        log.info("CategoryNode : getFilteredJSONNode - " + categoryNode);
        return categoryNode;

    }

    /**
     * Gets the filtered array node.
     *
     * @param root
     *            the root
     * @param fieldName
     *            the field name
     * @param criteria
     *            the criteria
     * @return the filtered array node
     * @throws Exception
     *             the exception
     */
    public ArrayNode getFilteredArrayNode( JsonNode root, String fieldName, String criteria) throws Exception {

        ArrayNode categoryNode = (ArrayNode) root.path("subcategories");
        if (categoryNode.size() != 0) {

        } else {
            categoryNode = (ArrayNode) root.path("products");

        }

        if (criteria != null) {
            JsonNode categoryNodelocal = categoryNode.deepCopy();
            categoryNode = categoryNode.removeAll();

            for ( int i = 0; i < categoryNodelocal.size(); i++) {
                String name = categoryNodelocal.get(i).path(fieldName).asText();

                if (containsIgnoreCase(name, criteria)) {
                    JsonNode node = categoryNodelocal.get(i);
                    categoryNode.add(node);

                }
            }

        }
        log.info("CategoryNode : getFilteredArrayNode -" + categoryNode);
        return categoryNode;
    }

    public JsonNode getCategoryNode( JsonNode rootNode, String fieldName, String category) throws Exception {

        return getFilteredJSONNode(rootNode, fieldName, category);

    }

    public ArrayNode getElementListNode( JsonNode rootNode, String fieldName, String criteria) throws Exception {
        return getFilteredArrayNode(rootNode, fieldName, criteria);

    }

    public boolean containsIgnoreCase( String sourceString, String part) {
        if (part.equals(""))
            return true;
        if (sourceString == null || part == null || sourceString.equals(""))
            return false;

        Pattern p = Pattern.compile(part, Pattern.CASE_INSENSITIVE + Pattern.LITERAL);
        Matcher m = p.matcher(sourceString);
        return m.find();
    }

    /**
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */

    public List<Product> sortCollection( JsonNode node, List<Product> sortedList, Comparator<Product> comparator)
            throws JsonParseException, JsonMappingException, IOException {

        for ( int productsSize = 0; productsSize < node.size(); productsSize++) {
            Product productBean = mapperObj.readValue(node.get(productsSize).toString(), Product.class);
            sortedList.add(productBean);
        }
        Collections.sort(sortedList, comparator);
        return sortedList;
    }

}
