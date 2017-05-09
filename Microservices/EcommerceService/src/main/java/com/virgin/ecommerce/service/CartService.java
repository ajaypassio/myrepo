
package com.virgin.ecommerce.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.virgin.ecommerce.helper.CartHelper;
import com.virgin.ecommerce.helper.EcommerceHelper;
import com.virgin.ecommerce.helper.ProductCatalogHelper;
import com.virgin.ecommerce.utils.Constants;

/**
 * The Class EcommerceCartService.
 */
@Service
public class CartService {

    /** The log. */
    private static Logger      log   = LoggerFactory.getLogger(CartService.class);

    /** The mapper. */
    @Autowired
    ObjectMapper               mapper;

    @Autowired
    EcommerceHelper            ecommerceHelper;

    @Autowired
    ProductCatalogHelper       productCatalogHelper;

    @Autowired
    CartHelper                 cartHelper;

    @Autowired
    ProductCatalogService      productCatalogService;

    /** The base url. */
    @Value( "${ecommerceService.virgin.cloudhub.baseUrl.mapping}")
    private String             baseUrl;

    /** The its on url. */
    @Value( "${ecommerceService.virgin.cloudhub.itsOnUrl.mapping}")
    private String             itsOnUrl;

    /** The proxy url. */
    @Value( "${ecommerceService.virgin.cloudhub.proxyUrl.mapping}")
    private String             proxyUrl;

    /** The icon url. */
    @Value( "${ecommerceService.virgin.cloudhub.iconUrl.mapping}")
    private String             iconUrl;

    /** The proxy port. */
    @Value( "${ecommerceService.virgin.cloudhub.proxyPort.mapping}")
    private Integer            proxyPort;

    /** The json stub. */
    @Value( "${ecommerceService.jsonStub.json.stub}")
    private String             jsonStub;

    /** The Constant CARTS. */
    public static final String CARTS = "carts";

    /**
     * Adds the item to cart.
     *
     * @param clientToken
     *            the client token @param cartId the cart id @param skuId the sku id @param jsonBody the json body @return the string @throws
     *            IOException @throws
     */
    public JsonNode addItemToCart( String clientToken, String cartId, String sku, String jsonBody) throws Throwable {

        if (cartId == null || cartId.isEmpty() || cartId.length() <= 0 || cartId.trim().length() == 0) {
            String resp = createCart(clientToken);
            JsonNode rootNode = mapper.readTree(resp);
            log.debug(" rootNode : " + rootNode);

            cartId = rootNode.get("message").asText();
            log.debug("CartId: " + cartId);

        }
        RestTemplate restTemplate = ecommerceHelper.getRestTemplate();
        String url = "https://api.stg.itsonsaas.net/api/1.0/carts" + Constants.BACK_SLASH + cartId + Constants.BACK_SLASH + "sku" + Constants.BACK_SLASH + sku;
        String uniqueID = getRandomUUID();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("X-Io-Request-Id", uniqueID);
        headers.add("Authorization", clientToken);
        headers.set("Accept", "application/json");
        HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);

        HttpEntity resp = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        String respJson = resp.getBody().toString();
        ObjectNode respJsonNode = (ObjectNode) mapper.readTree(respJson);
        respJsonNode.put("cartId", cartId);

        log.debug("respJsonNode: " + respJsonNode.toString());
        return respJsonNode;
    }

    /**
     * Creates the cart.
     *
     * @param clientToken
     *            the client token
     * @return the string
     */
    public String createCart( String clientToken) {

        RestTemplate restTemplate = ecommerceHelper.getRestTemplate();
        String url = "https://api.stg.itsonsaas.net/api/1.0/developer/cart";

        HttpEntity<String> entity = ecommerceHelper.addHeaderAndToken(clientToken);

        HttpEntity resp = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        String respJson = resp.getBody().toString();
        log.debug("respJson: " + respJson);
        return respJson;
    }

    /**
     * Gets the random uuid.
     *
     * @return the random uuid
     */
    private String getRandomUUID() {

        return UUID.randomUUID().toString();

    }

    /**
     * Removes the cart.
     *
     * @param clientToken
     *            the client token
     * @param cartId
     *            the cart id
     * @return the string
     */
    public String removeCart( String clientToken, String cartId) {

        RestTemplate restTemplate = ecommerceHelper.getRestTemplate();
        String url = "https://api.stg.itsonsaas.net/api/1.0/developer/cart" + Constants.BACK_SLASH + cartId;

        HttpEntity<String> entity = ecommerceHelper.addHeaderAndToken(clientToken);

        HttpEntity resp = restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class);
        String respJson = resp.getBody().toString();
        log.debug("respJson: " + respJson);
        return respJson;
    }

    /**
     * Removes the item from cart.
     *
     * @return the string
     */

    public String removeItemFromCart() {
        // It's returning stub data. This will be replaced with actual API calls
        return jsonStub;
    }

    /**
     * Gets the cart contents.
     *
     * @param clientToken
     *            the client token
     * @param cartId
     *            the cart id
     * @return the cart contents
     * @throws Throwable
     */

    public JsonNode getCartContents( String clientToken, String cartId) throws Throwable {
        JsonNode catalogResp = null;
        RestTemplate restTemplate = ecommerceHelper.getRestTemplate();
        String url = "https://api.stg.itsonsaas.net/api/1.0/carts" + Constants.BACK_SLASH + cartId;

        HttpEntity<String> entity = ecommerceHelper.addHeaderAndToken(clientToken);

        HttpEntity resp = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        log.info("Resp : " + resp.getBody());
        JsonNode respNode = mapper.readTree(resp.getBody().toString());
        // JsonNode plIds = cartHelper.getAllProductIdFromOrder(resp.getBody().toString());
        // for ( int plId = 0; plId < plIds.size(); plId++) {
        // log.debug("for PlId :" + plId);
        // catalogResp = productCatalogService.getProductDetailsByProductId(clientToken, plIds.get(plId).toString());
        // }
        // log.debug("catalogResp: " + catalogResp);
        return respNode;

    }

    /**
     * Check out cart.
     *
     * @return the string
     */
    public JsonNode checkOutCart( String clientToken, String cartId) {

        JsonNode catalogResp = null;
        RestTemplate restTemplate = ecommerceHelper.getRestTemplate();
        String url = "https://api.stg.itsonsaas.net/api/1.0/carts" + Constants.BACK_SLASH + cartId + Constants.BACK_SLASH + "checkout";

        HttpEntity<String> entity = ecommerceHelper.addHeaderAndToken(clientToken);

        HttpEntity resp = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        log.debug("Resp : " + resp.getBody());

        return (JsonNode) resp.getBody();
    }

}
