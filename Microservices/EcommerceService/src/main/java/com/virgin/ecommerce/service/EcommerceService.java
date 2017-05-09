
package com.virgin.ecommerce.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.virgin.ecommerce.helper.EcommerceHelper;
import com.virgin.ecommerce.utils.Constants;

/**
 * <p>
 * This class is contains business logic for Ecommerce Service
 * </p>
 * .
 *
 * @author ND00434775
 * @project EcommerceService
 * @updated DateTime: Sep 15, 2016 9:19:28 PM Author: ND00434775
 */
@Service
public class EcommerceService {

    /** The log. */
    private static Logger      log                   = LoggerFactory.getLogger(EcommerceService.class);

    @Autowired
    ObjectMapper               mapper;
    @Autowired
    EcommerceHelper            ecommerceHelper;

    /** The base url. */
    @Value( "${ecommerceService.virgin.cloudhub.baseUrl.mapping}")
    private String             baseUrl;

    @Value( "${ecommerceService.virgin.cloudhub.iconUrl.mapping}")
    private String             iconUrl;

    /** The json stub. */
    @Value( "${ecommerceService.jsonStub.json.stub}")
    private String             jsonStub;

    /** The accessories detail json. */
    @Value( "${ecommerceService.accessoriesDetail.json.stub}")
    private String             accessoriesDetailJson;

    /** The shop plans json. */
    @Value( "${ecommerceService.shopPlans.json.stub}")
    private String             shopPlansJson;

    /** The measure up data json. */
    @Value( "${ecommerceService.measureUpData.json.stub}")
    private String             measureUpDataJson;

    /** The plan detail json. */
    @Value( "${ecommerceService.planDetail.json.stub}")
    private String             planDetailJson;

    /** The shipping options json. */
    @Value( "${ecommerceService.shippingOptions.json.stub}")
    private String             shippingOptionsJson;

    /** The device details1. */
    @Value( "${ecommerceService.deviceDetails1.json.stub}")
    private String             deviceDetails1;

    /** The device details2. */
    @Value( "${ecommerceService.deviceDetails2.json.stub}")
    private String             deviceDetails2;

    /** The device details3. */
    @Value( "${ecommerceService.deviceDetails3.json.stub}")
    private String             deviceDetails3;

    /** The device details4. */
    @Value( "${ecommerceService.deviceDetails4.json.stub}")
    private String             deviceDetails4;

    /** The device details5. */
    @Value( "${ecommerceService.deviceDetails5.json.stub}")
    private String             deviceDetails5;

    /** The device details6. */
    @Value( "${ecommerceService.deviceDetails6.json.stub}")
    private String             deviceDetails6;

    @Value( "${ecommerceService.jsonStub.reActivateLine.json.stub}")
    private String             reActivateLineJson;

    @Value( "${ecommerceService.jsonStub.suspendLine.json.stub}")
    private String             suspendLineJson;

    /** The Constant GET_INVENTORY. */
    public static final String GET_INVENTORY         = "getInventory";

    /** The Constant COUNT. */
    public static final String COUNT                 = "count";

    /** The Constant INVENTORY. */
    public static final String INVENTORY             = "inventory";

    /** The Constant GET_RESERVE_INVENTORY. */
    public static final String GET_RESERVE_INVENTORY = "getReserveInventory";

    /** The Constant GET_RELEASE_INVENTORY. */
    public static final String GET_RELEASE_INVENTORY = "getReleaseInventory";

    /** The Constant ACTION. */
    public static final String ACTION                = "action";

    /**
     * Gets the inventory.
     *
     * @param cartSessionId
     *            the cart session id
     * @param sku
     *            the sku
     * @return the inventory
     * @throws Exception
     *             the exception
     */

    public JsonNode getInventory( String cartSessionId, String[] sku) throws Exception {

        RestTemplate restTemplate = ecommerceHelper.getRestTemplate();

        String requestJson = "{\"cartsessionid\":\"" + cartSessionId + "\",\"INVN_ProductInventory\":[";
        String preFix = "{\"sku\":\"";
        String postFix = "\"},";
        String newJson = "";

        for ( String tempSku : sku)
            newJson = preFix + tempSku + postFix;
        requestJson = requestJson + newJson.substring(0, newJson.lastIndexOf(',')) + "]}";
        log.info("RequestJson is : $$$ " + requestJson);

        String url = baseUrl + Constants.BACK_SLASH + INVENTORY + Constants.BACK_SLASH + COUNT;
        log.info(GET_INVENTORY + Constants.BLANK_SPACE + Constants.URL_STRING + Constants.BLANK_SPACE + Constants.COLON + url);
        String resp = restTemplate.postForObject(url, new String(requestJson), String.class);
        return mapper.readTree(resp);

    }

    /**
     * Gets the reserve inventory.
     *
     * @param requestJson
     *            the request json @return the reserve inventory @throws Throwable @throws
     */
    public JsonNode reserveInventory( String requestJson) throws Throwable {

        RestTemplate restTemplate = ecommerceHelper.getRestTemplate();
        String url = baseUrl + Constants.BACK_SLASH + INVENTORY + Constants.BACK_SLASH + ACTION;
        log.info(GET_RESERVE_INVENTORY + Constants.BLANK_SPACE + Constants.URL_STRING + Constants.BLANK_SPACE + Constants.COLON + url);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Basic");
        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);

        String resp = restTemplate.postForObject(url, entity, String.class);
        return mapper.readTree(resp);

    }

    /**
     * Gets the release inventory.
     *
     * @param json
     *            the json @return the release inventory @throws Throwable @throws
     */

    public JsonNode releaseInventory( String json) throws Throwable {

        RestTemplate restTemplate = ecommerceHelper.getRestTemplate();
        String url = baseUrl + Constants.BACK_SLASH + INVENTORY + Constants.BACK_SLASH + ACTION;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Basic");
        HttpEntity<String> entity = new HttpEntity<String>(json, headers);
        log.info(GET_RELEASE_INVENTORY + Constants.BLANK_SPACE + Constants.URL_STRING + Constants.BLANK_SPACE + Constants.COLON + url);
        String resp = restTemplate.postForObject(url, entity, String.class);
        return mapper.readTree(resp);

    }

    /**
     * Adds the coupon.
     *
     * @return the string @throws IOException @throws
     */
    public String addCoupon() {
        // It's returning stub data. This will be replaced with actual API calls
        return jsonStub;
    }

    public String getDeviceDetails( int pId) {

        String json = "PLID not specified...";
        if (pId == 1) {
            return deviceDetails1;
        }
        if (pId == 2) {
            return deviceDetails2;
        }
        if (pId == 3) {
            return deviceDetails3;
        }
        if (pId == 4) {
            return deviceDetails4;
        }

        if (pId == 5) {
            return deviceDetails5;
        }

        if (pId == 6) {
            return deviceDetails6;
        }
        return json;
    }

    public JsonNode getCategories( String authToken) throws Throwable {
        RestTemplate restTemplate = ecommerceHelper.getRestTemplate();
        String url = "https://api.stg.itsonsaas.net/api/1.0/catalog/categories";

        HttpHeaders headers = new HttpHeaders();
        // headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Content-Type", "application/json");
        headers.add("X-Io-Request-Id", ecommerceHelper.getRandomUUID());
        headers.add("Authorization", authToken);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        HttpEntity resp = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        log.info("response : " + resp.getBody().toString());
        return mapper.readTree(resp.getBody().toString());

    }

    /**
     * Gets the shop plans.
     *
     * @return the shop plans
     */

    public String getShopPlans() {
        // It's returning stub data. This will be replaced with actual API calls
        return shopPlansJson;

    }

    /**
     * Gets the measure up data.
     *
     * @return the measure up data
     */

    public String getMeasureUpData() {
        // It's returning stub data. This will be replaced with actual API calls
        return measureUpDataJson;

    }

    /**
     * Gets the plan detail.
     *
     * @return the plan detail
     */

    public String getPlanDetail() {
        // It's returning stub data. This will be replaced with actual API calls
        return planDetailJson;
    }

    /**
     * Gets the shipping options.
     *
     * @return the shipping options
     */

    public String getShippingOptions() {
        // It's returning stub data. This will be replaced with actual API calls
        return shippingOptionsJson;

    }

    public String suspendLine() {

        return suspendLineJson;

    }

    public String reActivateLine() {
        return reActivateLineJson;

    }

    public String getProductCategories() {

        return jsonStub;

    }

    public String browseCatalog() {

        return jsonStub;

    }

    /*
     * public String internationalCalling() { return jsonStub; }
     */

    public String annualUpgrade() {

        return jsonStub;

    }

}
