
package com.virgin.payment.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virgin.payment.service.PaymentService;

/**
 * <p>
 * This is the Controller class for the Payment Microservice
 * </p>
 * .
 *
 * @author ND00434775
 * @project PaymentService
 * @updated DateTime: Sep 14, 2016 6:09:36 PM Author: ND00434775
 */
@RestController
public class PaymentController {

    /** The log. */
    private static Logger      log                        = LoggerFactory.getLogger(PaymentController.class);

    /** The m payment service. */
    @Autowired
    private PaymentService     mPaymentService;

    /** The Constant LOG_GET_PAYMENT_METHODS. */
    public static final String LOG_GET_PAYMENT_METHODS    = "Inside /getPaymentDetails";

    /** The Constant LOG_ADD_PAYMENT_METHODS. */
    public static final String LOG_ADD_PAYMENT_METHODS    = "Inside /addPaymentDetails";

    /** The Constant LOG_DELETE_PAYMENT_METHODS. */
    public static final String LOG_DELETE_PAYMENT_METHODS = "Inside /deletePaymentDetails";

    /**
     * Gets the payment methods.
     *
     * @return the payment methods
     */
    @RequestMapping( value = "${paymentService.getPaymentMethods.url.mapping}", method = RequestMethod.GET)

    public ResponseEntity<String> getPaymentMethods() {
        log.info(LOG_GET_PAYMENT_METHODS);
        String json = mPaymentService.getPaymentDetails();
        return new ResponseEntity<String>(json, HttpStatus.OK);
    }

    /**
     * Adds the payment method.
     *
     * @return the string
     */
    @RequestMapping( value = "${paymentService.addPaymentMethod.url.mapping}", method = RequestMethod.GET)

    public String addPaymentMethod() {
        log.info(LOG_ADD_PAYMENT_METHODS);
        String json = mPaymentService.addPaymentDetails();
        return json;
    }

    /**
     * Delete payment method.
     *
     * @return the string
     */
    @RequestMapping( value = "${paymentService.deletePaymentMethod.url.mapping}", method = RequestMethod.GET)

    public String deletePaymentMethod() {
        log.info(LOG_DELETE_PAYMENT_METHODS);
        String json = mPaymentService.deletePaymentDetails();
        return json;

    }

}
