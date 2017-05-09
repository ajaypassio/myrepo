
package com.virgin.ecommerce.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.virgin.dependency.web.CustomHTTPResponse;
import com.virgin.ecommerce.helper.EcommerceHelper;
import com.virgin.ecommerce.service.EcommerceService;
import com.virgin.ecommerce.service.ProductCatalogService;

/**
 * <p>
 * This class contains rest end points for EcommerceService
 * </p>
 * .
 *
 * @author ND00434775
 * @project EcommerceService
 * @updated DateTime: Sep 14, 2016 5:20:14 PM Author: ND00434775
 */
@RefreshScope
@RestController

public class EcommerceController {
	
	@Value("${message:Hello default}")  
	private String message;
	
    /** The service. */
    @Autowired
    EcommerceService           service;

    @Autowired
    ProductCatalogService      productCatalogService;

    @Autowired
    EcommerceHelper            ecommerceHelper;

    @Autowired
    ObjectMapper               mapper;

    /** The Constant INFO_ITSONTOKEN. */
    public static final String INFO_ITSONTOKEN            = "Inside /getItsOnToken";

    /** The Constant INFO_ADD_ITEM_TO_CART. */
    public static final String INFO_ADD_ITEM_TO_CART      = "Inside /addItemToCart";

    /** The Constant INFO_REMOVE_ITEM_FROM_CART. */
    public static final String INFO_REMOVE_ITEM_FROM_CART = "Inside /removeItemFromCart";

    /** The Constant INFO_CART_CONTENTS. */
    public static final String INFO_CART_CONTENTS         = "Inside /getCartContents";

    /** The Constant INFO_SHIPMENT_STATUS. */
    public static final String INFO_SHIPMENT_STATUS       = "Inside /getShipmentStatus";

    /** The Constant INFO_INVENTORY. */
    public static final String INFO_INVENTORY             = "Inside /getInventory";

    /** The Constant INFO_CHECKOUT_CART. */
    public static final String INFO_CHECKOUT_CART         = "Inside /checkOutCart";

    /** The Constant INFO_ADD_COUPON. */
    public static final String INFO_ADD_COUPON            = "inside /addCoupon";

    /** The Constant INFO_RESERVE_INVENTORY. */
    public static final String INFO_RESERVE_INVENTORY     = "Inside /reserveInventory";

    /** The Constant INFO_PRODUCT_CATALOG. */
    public static final String INFO_RELEASE_INVENTORY     = "Inside /releaseInventory";

    /** The Constant INFO_DEVICE_DETAILS. */
    public static final String INFO_DEVICE_DETAILS        = "Inside /getDeviceDetails";

    /** The Constant INFO_MEASURE_UP_DATA. */
    public static final String INFO_MEASURE_UP_DATA       = "Inside /getMeasureUpData";

    /** The Constant INFO_PLAN_DETAILS. */
    public static final String INFO_PLAN_DETAILS          = "Inside /getPlanDetail";

    /** The Constant INFO_SHIPPING_OPTIONS. */
    public static final String INFO_SHIPPING_OPTIONS      = "Inside /getShippingOptions";

    public static final String INFO_SUSPENDLINE           = "Inside /suspendLine";

    public static final String INFO_REACTIVATE_LINE       = "Inside /reActivateLine";

    public static final String INFO_PRODUCT_CATEGORIES    = "Inside /getProductCategories";

    public static final String INFO_BROWSE_CATALOG        = "Inside /browseCatalog";

    public static final String INFO_ANNUAL_UPGRADE        = "Inside /annualUpgrade";
    /** The Constant SUCCESS. */
    public static final String SUCCESS                    = "OK";

    /** The log. */

    private static Logger      log                        = LoggerFactory.getLogger(EcommerceController.class);

    /**
     * Gets the inventory.
     *
     * @param cartSessionId
     *            the cart session id
     * @param sku
     *            the sku
     * @return the inventory
     * @throws Throwable
     */
    @RequestMapping( value = "${ecommerceService.getInventory.url.mapping}", method = RequestMethod.GET)
    public CustomHTTPResponse getInventory( @RequestParam( value = "cartSessionId") String cartSessionId,
            @RequestParam( value = "sku", required = false) String[] sku, HttpServletRequest request, HttpServletResponse response) throws Throwable {
        log.info(INFO_INVENTORY);
        JsonNode json = service.getInventory(cartSessionId, sku);
        return new CustomHTTPResponse(SUCCESS, response.getStatus(), json, request.getRequestURI());

    }

    @RequestMapping( value = "${ecommerceService.getCategories.url.mapping}", method = RequestMethod.GET)
    public CustomHTTPResponse getCategories( @RequestHeader( value = "Authorization", required = false) String authToken, HttpServletRequest request,
            HttpServletResponse response) throws Throwable {
        JsonNode json = service.getCategories(authToken);
        return new CustomHTTPResponse(SUCCESS, response.getStatus(), json, request.getRequestURI());
    }

    /**
     * Gets the reserve inventory.
     *
     * @param json
     *            the json
     * @return the reserve inventory
     */
    @RequestMapping( value = "${ecommerceService.reserveInventory.url.mapping}", method = RequestMethod.POST)
    public CustomHTTPResponse reserveInventory( @RequestBody( required = false) String jsonBody, HttpServletRequest request, HttpServletResponse response)
            throws Throwable {
        log.info(INFO_RESERVE_INVENTORY + jsonBody);
        JsonNode json = service.reserveInventory(jsonBody);

        return new CustomHTTPResponse(SUCCESS, response.getStatus(), json, request.getRequestURI());
    }

    /**
     * Gets the release inventory.
     *
     * @param json
     *            the json
     * @return the release inventory
     */
    @RequestMapping( value = "${ecommerceService.releaseInventory.url.mapping}", method = RequestMethod.POST)
    public CustomHTTPResponse releaseInventory( @RequestBody( required = true) String json, HttpServletRequest request, HttpServletResponse response)
            throws Throwable {
        log.info(INFO_RELEASE_INVENTORY + json);
        JsonNode retJson = service.releaseInventory(json);

        return new CustomHTTPResponse(SUCCESS, response.getStatus(), retJson, request.getRequestURI());
    }

    /**
     * Adds the coupon.
     * 
     * @param request
     * @param response
     *
     * @return the string
     */
    @RequestMapping( value = "${ecommerceService.addCoupon.url.mapping}", method = RequestMethod.GET)
    public String addCoupon( HttpServletRequest request, HttpServletResponse response) {
        log.info(INFO_ADD_COUPON);
        return service.addCoupon();
    }

    /* Stub For Shop Device Details call */
    /**
     * Gets the device details.
     *
     * @param pId
     *            the p id
     * @return the device details
     */

    @RequestMapping( value = "${ecommerceService.getDeviceDetails.url.mapping}", method = RequestMethod.GET)
    public String getDeviceDetails( @RequestParam( value = "pId", defaultValue = "1") int pId) {
        log.info(INFO_DEVICE_DETAILS);
        String json = service.getDeviceDetails(pId);
        return json;
    }

    /**
     * Gets the measure up data.
     * 
     * @param request
     * @param response
     *
     * @return the measure up data
     */
    @RequestMapping( value = "${ecommerceService.getMeasureUpData.url.mapping}", method = RequestMethod.GET)
    public String getMeasureUpData( HttpServletRequest request, HttpServletResponse response) {
        log.info(INFO_MEASURE_UP_DATA);
        return service.getMeasureUpData();
    }

    /**
     * Gets the plan detail.
     * 
     * @param request
     * @param response
     *
     * @return the plan detail
     */
    @RequestMapping( value = "${ecommerceService.getPlanDetail.url.mapping}", method = RequestMethod.GET)
    public String getPlanDetail( HttpServletRequest request, HttpServletResponse response) {
        log.info(INFO_PLAN_DETAILS);
        return service.getPlanDetail();
    }

    /**
     * Gets the shipping options.
     ** 
     * @param request
     * @param response
     * @return the shipping options
     */
    @RequestMapping( value = "${ecommerceService.getShippingOptions.url.mapping}", method = RequestMethod.GET)
    public String getShippingOptions( HttpServletRequest request, HttpServletResponse response) {
        log.info(INFO_SHIPPING_OPTIONS);
        return service.getShippingOptions();
    }

    /**
     * @param request
     * @param response
     */
    @RequestMapping( value = "${ecommerceService.suspendLine.url.mapping}", method = RequestMethod.GET)
    public String suspendLine( HttpServletRequest request, HttpServletResponse response) {
        log.info(INFO_SUSPENDLINE);
        return service.suspendLine();

    }

    /**
     * @param request
     * @param response
     */
    @RequestMapping( value = "${ecommerceService.reActivateLine.url.mapping}", method = RequestMethod.GET)
    public String reActivateLine( HttpServletRequest request, HttpServletResponse response) {
        log.info(INFO_REACTIVATE_LINE);
        return service.reActivateLine();
    }

    /**
     * @param request
     * @param response
     */
    @RequestMapping( value = "${ecommerceService.productCategories.url.mapping}", method = RequestMethod.GET)
    public String getProductCategories( HttpServletRequest request, HttpServletResponse response) {
        log.info(INFO_PRODUCT_CATEGORIES);
        return service.getProductCategories();
    }

    /**
     * @param request
     * @param response
     */

    @RequestMapping( value = "${ecommerceService.browseCatalog.url.mapping}", method = RequestMethod.GET)
    public String browseCatalog( HttpServletRequest request, HttpServletResponse response) {
        log.info(INFO_BROWSE_CATALOG);
        return service.browseCatalog();
    }

    /**
     * @param request
     * @param response
     */

    @RequestMapping( value = "${ecommerceService.annualUpgrade.url.mapping}", method = RequestMethod.GET)
    public String annualUpgrade( HttpServletRequest request, HttpServletResponse response) {
        log.info(INFO_ANNUAL_UPGRADE);
        return service.annualUpgrade();
    }

    // ------------------------------------------------------------------------------------

    /**
     * Gets the its on token.
     *
     * @param grant_type
     *            the grant_type
     * @param client_id
     *            the client_id
     * @param username
     *            the username
     * @param password
     *            the password
     * @param client_secret
     *            the client_secret
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the its on token
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${ecommerceService.getItsOnToken.url.mapping}", method = RequestMethod.POST)
    public CustomHTTPResponse getItsOnToken( @RequestBody( required = true) JsonNode paramMap, HttpServletRequest request, HttpServletResponse response)
            throws Throwable {
        log.info(INFO_ITSONTOKEN);
        log.info("Controller-----------paramMap: " + paramMap);
        String json = ecommerceHelper.getItsOnToken(paramMap);
        JsonNode obj = mapper.readValue(json, JsonNode.class);
        return new CustomHTTPResponse(SUCCESS, response.getStatus(), obj, request.getRequestURI());

    }
    
    @RequestMapping( value = "/central")
    public String getMsg()
            throws Throwable {
        
        return this.message;

    }
}
