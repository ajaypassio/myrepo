
package com.virgin.subscriber.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.virgin.subscriber.utils.Constants;

/**
 * <p>
 * This is the service class having business logic for Subscriber Mgmt Service
 * </p>
 * .
 *
 * @author UK00472999
 * @project SubscriberMgmtService
 * @updated DateTime: Sep 14, 2016 5:23:06 PM Author: UK00472999
 */

@Service
public class SubscriberService {

    /** The log. */
    private static Logger      log                                = LoggerFactory.getLogger(SubscriberService.class);

    /** The Constant ACCOUNT_URL. */
    public static final String ACCOUNT_URL                        = "accounts";

    /** The Constant INSTALL_BILLING. */
    public static final String INSTALL_BILLING                    = "installbilling";

    /** The Constant IB_CHECK. */
    public static final String IB_CHECK                           = "ibcheck";

    /** The Constant TICKETS. */
    public static final String TICKETS                            = "tickets";

    /** The Constant INVENTORY. */
    public static final String INVENTORY                          = "inventory";

    /** The Constant MAX_RECORDS. */
    public static final String MAX_RECORDS                        = "maxrecords";

    /** The Constant OFFSET. */
    public static final String OFFSET                             = "offset";

    /** The Constant COUNT. */
    public static final String COUNT                              = "count";

    /** The Constant GET_ACCOUNT_DETAILS. */
    public static final String GET_ACCOUNT_DETAILS                = "getAccountDetails";

    /** The Constant ACTION. */
    public static final String ACTION                             = "action";

    /** The Constant GET_IB_DETAILS. */
    public static final String GET_IB_DETAILS                     = "getIBDetails";

    /** The Constant GET_IB_CONTRACT. */
    public static final String GET_IB_CONTRACT                    = "getIBContract";

    /** The Constant GET_ORDER_AND_LINE_ITEMS. */
    public static final String GET_ORDER_AND_LINE_ITEMS           = "getOrderAndLineItems";

    /** The Constant GET_SHIPMENT_DETAILS. */
    public static final String GET_SHIPMENT_DETAILS               = "getShipmentDetails";

    /** The Constant UPDATE_CUSTOMER_ACCOUNT_INFO. */
    public static final String UPDATE_CUSTOMER_ACCOUNT_INFO       = "updateCustomerAccountInfo";

    /** The Constant CHECK_IB. */
    public static final String CHECK_IB                           = "checkIB";

    /** The Constant ACCEPT_IB_CONTRACT. */
    public static final String ACCEPT_IB_CONTRACT                 = "acceptIBContract";

    /** The Constant CREATE_UPDATE_TICKETS. */
    public static final String CREATE_UPDATE_TICKETS              = "createUpdateTicket";

    /** The Constant CLOSE_TICKETS. */
    public static final String CLOSE_TICKETS                      = "closeTicket";

    /** The Constant GET_LIST_OF_SUPPORT_TICKET_DETAILS. */
    public static final String GET_LIST_OF_SUPPORT_TICKET_DETAILS = "getListOfSupportTicketDetails";

    /** The Constant GET_INVENTORY. */
    public static final String GET_INVENTORY                      = "getInventory";

    /** The Constant GET_RESERVE_INVENTORY. */
    public static final String GET_RESERVE_INVENTORY              = "getReserveInventory";

    /** The Constant GET_RELEASE_INVENTORY. */
    public static final String GET_RELEASE_INVENTORY              = "getReleaseInventory";

    /** The base url. */
    @Value( "${subscriberMgmtService.virgin.cloudhub.baseUrl.mapping}")
    private String             baseUrl;

    /** The stub json. */
    @Value( "${subscriber.stub.json}")
    private String             stubJson;

    /**
     * Update customer account info.
     *
     * @return the string
     */
    public String updateCustomerAccountInfo() {
        // It's returning stub data. This will be replaced with actual API calls
        log.info(UPDATE_CUSTOMER_ACCOUNT_INFO + Constants.BLANK_SPACE + Constants.URL_STRING + Constants.BLANK_SPACE + Constants.COLON);
        return stubJson;
    }

    /**
     * Adds the subscriber.
     *
     * @return the string
     */
    public String addSubscriber() {
        // It's returning stub data. This will be replaced with actual API calls
        return stubJson;

    }

    /**
     * Removes the subscriber.
     *
     * @return the string
     */
    public String removeSubscriber() {
        // It's returning stub data. This will be replaced with actual API calls
        return stubJson;

    }

    /**
     * Change phone number.
     *
     * @return the string
     */
    public String changePhoneNumber() {
        // It's returning stub data. This will be replaced with actual API calls
        return stubJson;

    }
}
