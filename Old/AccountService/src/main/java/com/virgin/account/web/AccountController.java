
package com.virgin.account.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virgin.account.service.AccountService;

/**
 * <p>
 * AccountController Class is the controller class for the Account Microservice
 * </p>
 * .
 *
 * @author ND00434775
 * @project AccountService1
 * @updated DateTime: Sep 14, 2016 5:59:23 PM Author: ND00434775
 */
@RestController
public class AccountController {

    /** The log. */
    private static Logger      log                                     = LoggerFactory.getLogger(AccountController.class);
    /** The Account service. */
    @Autowired
    private AccountService     mAccountService;

    /** The Constant INFO_CREATE_ACCOUNT. */
    public static final String INFO_CREATE_ACCOUNT                     = "Inside /createAccount";

    /** The Constant INFO_DELETE_ACCOUNT. */
    public static final String INFO_DELETE_ACCOUNT                     = "Inside /deleteAccount";

    /** The Constant INFO_GET_CURR_PLANS. */
    public static final String INFO_GET_CURR_PLANS                     = "Inside /getCurrentPlans";

    /** The Constant INFO_MRC_DETAILS. */
    public static final String INFO_MRC_DETAILS                        = "Inside /getMRCDetails";

    /** The Constant INFO_GET_DEVICE_INFO. */
    public static final String INFO_GET_DEVICE_INFO                    = "Inside /getDeviceInfo";

    /** The Constant INFO_BILLING_HISTORY. */
    public static final String INFO_BILLING_HISTORY                    = "Inside /getBillingHistory";

    /** The Constant INFO_SWAP_DEVICE. */
    public static final String INFO_SWAP_DEVICE                        = "Inside /swapDevice";

    /** The Constant INFO_CHANGE_PHONE_NUMBER. */
    public static final String INFO_CHANGE_PHONE_NUMBER                = "Inside /changePhoneNumber";

    /** The Constant INFO_CREATE_UPDATE_TICKET. */
    public static final String INFO_CREATE_UPDATE_TICKET               = "Inside / CreateTicket OR UpdateTicket";

    /** The Constant INFO_CLOSE_TICKET. */
    public static final String INFO_CLOSE_TICKET                       = "Inside / Close Ticket";

    /** The Constant INFO_GET_LIST_OF_SUPPORT_TICKET_DETAILS. */
    public static final String INFO_GET_LIST_OF_SUPPORT_TICKET_DETAILS = "Inside / getListOfSupport Ticket Details";

    /** The Constant INFO_ACCEPT_IB_CONTRACT. */
    public static final String INFO_ACCEPT_IB_CONTRACT                 = "Inside / IBContract";

    /** The Constant INFO_CHECK_IB. */
    public static final String INFO_CHECK_IB                           = "Inside / checkIB";

    /** The Constant INFO_GET_IB_CONTRACT. */
    public static final String INFO_GET_IB_CONTRACT                    = "Inside / getIBContract";

    /** The Constant INFO_GET_SHIPMENT_DETAILS. */
    public static final String INFO_GET_SHIPMENT_DETAILS               = "Inside / getShipmentDetails";

    /** The Constant INFO_GET_ORDER_AND_LINE_ITEMS. */
    public static final String INFO_GET_ORDER_AND_LINE_ITEMS           = "Inside / getOrderAndLineItems";

    /** The Constant INFO_GET_IB_DETAILS. */
    public static final String INFO_GET_IB_DETAILS                     = "Inside /getIBDetails ";

    /**
     * Creates the account.
     *
     * @return the string
     */
    @RequestMapping( value = "${accountService.createAccount.url.mapping}", method = RequestMethod.GET)

    public String createAccount() {
        log.info(INFO_CREATE_ACCOUNT);
        String json = mAccountService.createAccount();
        return json;
    }

    /**
     * Delete account.
     *
     * @return the string
     */
    @RequestMapping( value = "${accountService.deleteAccount.url.mapping}", method = RequestMethod.GET)

    public String deleteAccount() {
        log.info(INFO_DELETE_ACCOUNT);
        String json = mAccountService.deleteAccount();
        return json;
    }

    /**
     * Gets the current plans.
     *
     * @return the current plans
     */
    @RequestMapping( value = "${accountService.getCurrentPlans.url.mapping}", method = RequestMethod.GET)

    public String getCurrentPlans() {
        log.info(INFO_GET_CURR_PLANS);
        String json = mAccountService.getCurrentPlans();
        return json;
    }

    /**
     * Retrieves the details of charges, services and date of next MRC.
     *
     * @return the MRC details
     */
    @RequestMapping( value = "${accountService.getMRCDetails.url.mapping}", method = RequestMethod.GET)

    public String getMRCDetails() {
        log.info(INFO_MRC_DETAILS);
        String json = mAccountService.getMRCDetails();
        return json;
    }

    /**
     * Retrieves details about the current device(s) associated with an account.
     *
     * @return the device info
     */
    @RequestMapping( value = "${accountService.getDeviceInfo.url.mapping}", method = RequestMethod.GET)

    public String getDeviceInfo() {
        log.info(INFO_GET_DEVICE_INFO);
        String json = mAccountService.getDeviceInfo();
        return json;
    }

    /**
     * Gets the billing history.
     *
     * @return the billing history
     */
    @RequestMapping( value = "${accountService.getBillingHistory.url.mapping}", method = RequestMethod.GET)

    public String getBillingHistory() {
        log.info(INFO_BILLING_HISTORY);
        String json = mAccountService.getBillingHistory();
        return json;
    }

    /**
     * Swap device.
     *
     * @return the string
     */
    @RequestMapping( value = "${accountService.swapDevice.url.mapping}", method = RequestMethod.GET)

    public String swapDevice() {
        log.info(INFO_SWAP_DEVICE);
        String json = mAccountService.swapDevice();
        return json;
    }

    /**
     * Change phone number.
     *
     * @return the string
     */
    @RequestMapping( value = "${accountService.changePhoneNumber.url.mapping}", method = RequestMethod.GET)

    public String changePhoneNumber() {
        log.info(INFO_CHANGE_PHONE_NUMBER);
        String json = mAccountService.changePhoneNumber();
        return json;
    }

    /**
     * This service is called in Account Service flow, to get Shipment details.
     *
     * @return the shipment details
     */
    @RequestMapping( value = "${accountService.shipmentDetails.url.mapping}", method = RequestMethod.GET)
    public String getShipmentDetails() {
        log.info(INFO_GET_SHIPMENT_DETAILS);
        String json = mAccountService.getShipmentDetails();
        return json;
    }

    /**
     * This service is called in Account Service flow, to get order details.
     *
     * @return the order and line items
     */

    @RequestMapping( value = "${accountService.orderAndLineItems.url.mapping}", method = RequestMethod.GET)
    public String getOrderAndLineItems() {
        log.info(INFO_GET_ORDER_AND_LINE_ITEMS);
        String json = mAccountService.getOrderAndLineItems();

        return json;

    }

    /**
     * This service is called to get customer IB payment status.
     *
     * @param iBDetails
     *            the i b details
     * @return the IB details
     */
    @RequestMapping( value = "${accountServiceService.IBDetails.url.mapping}", method = RequestMethod.POST)
    public String getIBDetails( @RequestBody( required = true) String iBDetails) {

        log.info(INFO_GET_IB_DETAILS);
        String json = mAccountService.getIBDetails(iBDetails);
        return json;
    }

    /**
     * This service is called, to get the link for IB contract PDF document.
     *
     * @return the IB contract
     */
    @RequestMapping( value = "${accountService.IBContract.url.mapping}", method = RequestMethod.GET)
    public String getIBContract() {
        log.info(INFO_GET_IB_CONTRACT);
        String json = mAccountService.getIBContract();
        return json;
    }

    /**
     * This service is called in eCommerce flow, to check customer eligibility for IB.
     *
     * @param checkIbRequest
     *            the check ib request
     * @return the string
     */
    @RequestMapping( value = "${accountService.checkIB.url.mapping}", method = RequestMethod.POST)
    public String checkIB( @RequestBody( required = true) String checkIbRequest) {
        log.info(INFO_CHECK_IB);
        return mAccountService.checkIB(checkIbRequest);
    }

    /**
     * This service is called in eCommerce flow, to indicate to CRM that customer has accepted IB contract.
     *
     * @return the string
     */
    @RequestMapping( value = "${accountService.acceptIBContract.url.mapping}", method = RequestMethod.GET)
    public String acceptIBContract() {
        log.info(INFO_ACCEPT_IB_CONTRACT);
        String json = mAccountService.acceptIBContract();
        return json;
    }

    /**
     * This service called in support flow, to create ticket when customer request for call back.
     *
     * @param createTicketRequest
     *            the create ticket request
     * @return the string
     */

    @RequestMapping( value = "${accountService.createTicket.url.mapping}", method = RequestMethod.PUT)
    public HttpStatus createTicket( @RequestBody( required = true) String createTicketRequest) {
        log.info(INFO_CREATE_UPDATE_TICKET);
        HttpStatus status = mAccountService.createUpdateTicket(createTicketRequest);
        return status;
    }

    /**
     * Close ticket. This service called in Account Service flow, to close a support ticket.
     *
     * @param ticketId
     *            the ticket id
     * @return the string
     */
    @RequestMapping( value = "${accountService.closeTicket.url.mapping}", method = RequestMethod.DELETE)
    public String closeTicket( @RequestParam( value = "ticketId") String ticketId) {
        log.info(INFO_CLOSE_TICKET);
        String json = mAccountService.closeTicket(ticketId);
        return json;
    }

    /**
     * Gets the list of support ticket details.
     *
     * @param gigyaId
     *            the gigya id
     * @param maxRecords
     *            the max records
     * @param offSet
     *            the off set
     * @return the list of support ticket details
     * @throws Exception
     *             the exception
     */
    @RequestMapping( value = "${accountService.listOfSupportTicketDetails.url.mapping}", method = RequestMethod.GET)
    public String getListOfSupportTicketDetails( @RequestParam( value = "gigyaId") String gigyaId, @RequestParam( value = "maxRecords") int maxRecords,
            @RequestParam( value = "offSet") int offSet) throws Exception {
        log.info(INFO_GET_LIST_OF_SUPPORT_TICKET_DETAILS);
        String json = mAccountService.getListOfSupportTicketDetails(gigyaId, maxRecords, offSet);
        return json;
    }

}
