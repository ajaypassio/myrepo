
package com.virgin.payment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * <p>
 * This is the main Service class for the payment Microservice
 * </p>
 * .
 *
 * @author ND00434775
 * @project PaymentService
 * @updated DateTime: Sep 16, 2016 7:04:07 PM Author: ND00434775
 */
@Service
public class PaymentService {

    /** The log. */
    private static Logger      log              = LoggerFactory.getLogger(PaymentService.class);

    /** The base url. */
    @Value( "${paymentService.virgin.cloudhub.baseUrl.mapping}")
    private String             baseUrl;

    @Value( "${paymentService.SampleJSON}")
    private String             sampleJSON;

    public static final String INFO_GET_PAYMENT = "Inside / getPaymentDetails";

    /**
     * Gets the payment methods.
     *
     * @return the payment methods
     */

    public String getPaymentDetails() {
        log.info(INFO_GET_PAYMENT);
        return sampleJSON;

    }

    /**
     * Adds the payment method.
     *
     * @return the string
     */

    public String addPaymentDetails() {

        return sampleJSON;

    }

    /**
     * Delete payment method.
     *
     * @return the string
     */

    public String deletePaymentDetails() {

        return sampleJSON;

    }

}
