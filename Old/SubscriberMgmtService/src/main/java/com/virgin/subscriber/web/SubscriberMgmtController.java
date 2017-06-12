
package com.virgin.subscriber.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virgin.subscriber.service.SubscriberService;

/**
 * The Class SubscriberMgmtController is having all rest end points.
 *
 * @author UK00472999
 * @project SubscriberMgmtService
 * @updated DateTime: Sep 7, 2016 10:26:23 PM Author: UK00472999
 */
@RefreshScope
@RestController
public class SubscriberMgmtController {

    /** The log. */
    private static Logger      log                     = LoggerFactory.getLogger(SubscriberMgmtController.class);

    /** The m service. */
    @Autowired
    private SubscriberService  mService;

    /** The Constant LOG_ADD_SUBSCRIBER. */
    public static final String LOG_ADD_SUBSCRIBER      = "Inside /addSubscriber";

    /** The Constant LOG_REMOVE_SUBSCRIBER. */
    public static final String LOG_REMOVE_SUBSCRIBER   = "Inside /removeSubscriber";

    /** The Constant LOG_CHANGE_PHONE_NUMBER. */
    public static final String LOG_CHANGE_PHONE_NUMBER = "Inside /changePhoneNumber";

    /** The Constant LOG_UPDATE_CUST_INFO. */
    public static final String LOG_UPDATE_CUST_INFO    = "Inside /updateCustomerAccountInfo";

    /**
     * Update customer account info.
     *
     * @return the string
     */
    @RequestMapping( value = "${subscriberMgmtService.updateCustomerAccountInfo.url.mapping}", method = RequestMethod.GET)
    public String updateCustomerAccountInfo() {
        log.info(LOG_UPDATE_CUST_INFO);
        String json = mService.updateCustomerAccountInfo();
        return json;
    }

    /**
     * Adds the subscriber.
     *
     * @return the string
     */
    @RequestMapping( value = "${subscriberMgmtService.addSubscriber.url.mapping}", method = RequestMethod.GET)

    public String addSubscriber() {
        log.info(LOG_ADD_SUBSCRIBER);
        String json = mService.addSubscriber();
        return json;
    }

    /**
     * Removes the subscriber.
     *
     * @return the string
     */
    @RequestMapping( value = "${subscriberMgmtService.removeSubscriber.url.mapping}", method = RequestMethod.GET)

    public String removeSubscriber() {
        log.info(LOG_REMOVE_SUBSCRIBER);
        String json = mService.removeSubscriber();
        return json;
    }

    /**
     * Change phone number.
     *
     * @return the string
     */
    @RequestMapping( value = "${subscriberMgmtService.changePhoneNumber.url.mapping}", method = RequestMethod.GET)

    public String changePhoneNumber() {
        log.info(LOG_CHANGE_PHONE_NUMBER);
        String json = mService.changePhoneNumber();
        return json;
    }

}
