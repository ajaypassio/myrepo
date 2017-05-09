
package com.virgin.ecommerce.web;

import java.io.File;
import java.net.ConnectException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.virgin.ecommerce.service.CartService;

/**
 * Controlller class for Cart. Caters all the request of type '/cart'.
 */
@RefreshScope
@RestController
@RequestMapping( "/cart")
public class CartController {

    /** The cart service. */
    @Autowired
    CartService                cartService;

    /** The mapper. */
    @Autowired
    ObjectMapper               mapper;

    @Autowired
    EcommerceHelper            ecommerceHelper;

    /** The Constant INFO_ITSONTOKEN. */
    public static final String INFO_ITSONTOKEN            = "Inside /getItsOnToken";

    /** The Constant INFO_CREATE_CART. */
    public static final String INFO_CREATE_CART           = "Inside /createCart";

    /** The Constant INFO_ADD_ITEM_TO_CART. */
    public static final String INFO_ADD_ITEM_TO_CART      = "Inside /addItemToCart";

    public static final String INFO_REMOVE_CART           = "Inside /removeCart";

    /** The Constant INFO_REMOVE_ITEM_FROM_CART. */
    public static final String INFO_REMOVE_ITEM_FROM_CART = "Inside /removeItemFromCart";

    /** The Constant INFO_CART_CONTENTS. */
    public static final String INFO_CART_CONTENTS         = "Inside /getCartContents";

    /** The Constant INFO_CHECKOUT_CART. */
    public static final String INFO_CHECKOUT_CART         = "Inside /checkOutCart";

    /** The Constant SUCCESS. */
    public static final String SUCCESS                    = "OK";

    /** The Constant ERROR. */
    public static final String ERROR                      = "error";

    /** The log. */

    private static Logger      log                        = LoggerFactory.getLogger(CartController.class);

    /**
     * Adds the item to cart.
     *
     * @param authToken
     *            the auth token
     * @param cartId
     *            the cart id
     * @param skuId
     *            the sku id
     * @param jsonBody
     *            the json body
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the string
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${ecommerceCartService.addItemToCart.url.mapping}", method = RequestMethod.POST)
    public CustomHTTPResponse addItemToCart( @RequestHeader( value = "Authorization", required = false) String authToken,
            @RequestParam( value = "cartId", required = false) String cartId, @RequestParam( value = "sku") String sku,
            @RequestBody( required = false) String jsonBody, HttpServletRequest request, HttpServletResponse response) throws Throwable {
        log.info(INFO_ADD_ITEM_TO_CART);
        log.info(" CartId: " + cartId);
        // JsonNode json = cartService.addItemToCart(authToken, cartId, sku, jsonBody);
        JsonNode json = mapper.readTree(new File("D:\\VirginConnect07102016\\VirginConnectWeb\\addItemToCart.txt"));

        return new CustomHTTPResponse(SUCCESS, response.getStatus(), json, request.getRequestURI());
    }

    /**
     * Creates the cart.
     *
     * @param authToken
     *            the auth token
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the custom http response
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${ecommerceCartService.createCart.url.mapping}", method = RequestMethod.POST)
    public CustomHTTPResponse createCart( @RequestHeader( value = "Authorization", required = false) String authToken, HttpServletRequest request,
            HttpServletResponse response) throws Throwable {
        log.info(INFO_CREATE_CART);

        String json = cartService.createCart(authToken);
        JsonNode obj = mapper.readValue(json, JsonNode.class);
        CustomHTTPResponse customReponse = new CustomHTTPResponse(SUCCESS, response.getStatus(), obj, request.getRequestURI());
        return customReponse;
    }

    /**
     * Removes the cart.
     *
     * @param authToken
     *            the auth token
     * @param cartId
     *            the cart id
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the custom http response
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${ecommerceCartService.removeCart.url.mapping}", method = RequestMethod.DELETE)
    public CustomHTTPResponse removeCart( @RequestHeader( value = "Authorization", required = false) String authToken,
            @RequestParam( value = "cartId") String cartId, HttpServletRequest request, HttpServletResponse response) throws Throwable {
        log.info(INFO_REMOVE_CART);
        String json = cartService.removeCart(authToken, cartId);
        JsonNode obj = mapper.readValue(json, JsonNode.class);
        return new CustomHTTPResponse(SUCCESS, response.getStatus(), obj, request.getRequestURI());
    }

    /**
     * Removes the item from cart.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the string
     * @throws ConnectException
     *             the connect exception
     */
    @RequestMapping( value = "${ecommerceService.removeItemFromCart.url.mapping}", method = RequestMethod.GET)
    public String removeItemFromCart( HttpServletRequest request, HttpServletResponse response) throws ConnectException {
        log.info(INFO_REMOVE_ITEM_FROM_CART);
        return cartService.removeItemFromCart();

    }

    /**
     * Gets the cart contents.
     *
     * @param authToken
     *            the auth token
     * @param cartId
     *            the cart id
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the cart contents
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${ecommerceCartService.getCartContents.url.mapping}", method = RequestMethod.GET)
    public CustomHTTPResponse getCartContents( @RequestHeader( value = "Authorization", required = false) String authToken,
            @RequestParam( value = "cartId", required = false) String cartId, HttpServletRequest request, HttpServletResponse response) throws Throwable {
        log.info(INFO_CART_CONTENTS);
        JsonNode json = cartService.getCartContents(authToken, cartId);
        return new CustomHTTPResponse(SUCCESS, response.getStatus(), json, request.getRequestURI());

    }

    /**
     * Check out cart.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the string
     */
    @RequestMapping( value = "${ecommerceService.checkOutCart.url.mapping}", method = RequestMethod.GET)
    public CustomHTTPResponse checkOutCart( @RequestHeader( value = "Authorization", required = false) String authToken,
            @RequestParam( value = "cartId", required = false) String cartId, HttpServletRequest request, HttpServletResponse response) {
        log.info(INFO_CHECKOUT_CART);
        JsonNode json = cartService.checkOutCart(authToken, cartId);

        return new CustomHTTPResponse(SUCCESS, response.getStatus(), json, request.getRequestURI());

    }

}
