
package com.virgin.ecommerce.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.virgin.dependency.web.CustomHTTPResponse;
import com.virgin.ecommerce.service.ProductCatalogService;
import com.virgin.ecommerce.utils.Constants;

/**
 * <p>
 * Controlller class for Product Catalog. Caters all the request of type '/catalog'.
 * </p>
 * .
 *
 * @project EcommerceService
 * 
 */
//@RefreshScope
@RestController

@RequestMapping( "/catalog")
public class ProductCatalogController {

    /** The product catalog service. */
    @Autowired
    ProductCatalogService      productCatalogService;

    /** The Constant SUCCESS. */
    public static final String SUCCESS             = "OK";

    /** The Constant ERROR. */
    public static final String ERROR               = "error";

    /** The Constant STATUS_CODE_SUCCESS. */
    public static final int    STATUS_CODE_SUCCESS = 200;

    /** The use stub. */
    @Value( "${usestub}")
    private boolean            useStub;

    /** The log. */

    private static Logger      log                 = LoggerFactory.getLogger(ProductCatalogController.class);

    /**
     * Gets the accessories details.
     *
     * @param authToken
     *            the auth token
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the accessories details
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${ecommerceService.catalog.getAllAccessories.url.mapping}", method = RequestMethod.GET)
    public CustomHTTPResponse getAllAccessories( @RequestHeader( value = "Authorization", required = false) String authToken, HttpServletRequest request,
            HttpServletResponse response) throws Throwable {

        log.info(Constants.INFO_ALL_ACCESSORIES);

        JsonNode respJson = productCatalogService.getAccessories(authToken, useStub);

        log.debug("*************** AccessoriesJson" + respJson);

        return new CustomHTTPResponse(SUCCESS, STATUS_CODE_SUCCESS, respJson, request.getRequestURI());

    }

    /**
     * Gets the devices.
     *
     * @param authToken
     *            the auth token
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the devices
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${ecommerceService.catalog.getDevices.url.mapping}", method = RequestMethod.GET)
    public CustomHTTPResponse getDevices( @RequestHeader( value = "Authorization", required = false) String authToken, HttpServletRequest request,
            HttpServletResponse response) throws Throwable {

        log.info(Constants.INFO_GET_DEVICES);

        JsonNode devicesJson = productCatalogService.getDevices(authToken, useStub);

        log.debug("devicesJson :" + devicesJson);
        CustomHTTPResponse customReponse = new CustomHTTPResponse(SUCCESS, STATUS_CODE_SUCCESS, devicesJson, request.getRequestURI());

        return customReponse;

    }

    /**
     * Gets the shop plans.
     * 
     * @param response
     *
     * @return the shop plans
     * @throws Exception
     * @throws Throwable
     */

    @RequestMapping( value = "${ecommerceService.catalog.getShopPlans.url.mapping}", method = RequestMethod.GET)
    public CustomHTTPResponse getShopPlans( @RequestHeader( value = "Authorization", required = false) String authToken, HttpServletRequest request,

            HttpServletResponse response) throws Throwable {
        log.info(Constants.INFO_SHOPS_PLANS);

        JsonNode shopPlanJson = productCatalogService.getAllShopPlans(authToken, useStub);

        log.debug("shopPlanJson:" + shopPlanJson);

        return new CustomHTTPResponse(SUCCESS, STATUS_CODE_SUCCESS, shopPlanJson, request.getRequestURI());

    }

    /**
     * Gets the international calls plans.
     *
     * @param authToken
     *            the auth token
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the international calls plans
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${ecommerceService.catalog.getInternationalCallsPlans.url.mapping}", method = RequestMethod.GET)
    public CustomHTTPResponse getInternationalCallsPlans( @RequestHeader( value = "Authorization", required = false) String authToken,
            HttpServletRequest request, HttpServletResponse response) throws Throwable {
        log.info(Constants.INFO_INTERNATIONAL_CALLS);

        JsonNode IntnlCallPlanJson = productCatalogService.getIntnlCallsPlans(authToken, useStub);

        log.debug("IntnlCallPlanJson :" + IntnlCallPlanJson);

        return new CustomHTTPResponse(SUCCESS, STATUS_CODE_SUCCESS, IntnlCallPlanJson, request.getRequestURI());

    }

    /**
     * Gets the international roam plans.
     *
     * @param authToken
     *            the auth token
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the international roam plans
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${ecommerceService.catalog.getInternationalRoamPlans.url.mapping}", method = RequestMethod.GET)
    public CustomHTTPResponse getInternationalRoamPlans( @RequestHeader( value = "Authorization", required = false) String authToken,
            HttpServletRequest request, HttpServletResponse response) throws Throwable {
        log.info(Constants.INFO_INTERNATIONAL_ROAM);

        JsonNode IntnlRoamPlanJson = productCatalogService.getIntnlRoamPlans(authToken, useStub);

        log.debug("IntnlRoamPlanJson :" + IntnlRoamPlanJson);

        return new CustomHTTPResponse(SUCCESS, STATUS_CODE_SUCCESS, IntnlRoamPlanJson, request.getRequestURI());

    }

}
