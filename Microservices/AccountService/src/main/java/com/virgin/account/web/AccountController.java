
package com.virgin.account.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.virgin.account.service.AccountService;
import com.virgin.dependency.web.CustomHTTPResponse;
import com.virgin.dependency.web.HTTPErrorResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class AccountController.
 */
@RestController
@RefreshScope
public class AccountController implements ErrorController {

    /** The log. */
    private static Logger      log                                     = LoggerFactory.getLogger(AccountController.class);
    /** The Account service. */
    @Autowired
    private AccountService     mAccountService;

    /** The mapper. */
    @Autowired
    private ObjectMapper       mapper;
    /** The Constant INFO_CREATE_ACCOUNT. */
    public static final String INFO_CREATE_ACCOUNT                     = "Inside /createAccount";

    /** The Constant INFO_CREATE_ACCOUNT. */
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

    /** The Constant INFO_GET_ACCOUNT_PREFERENCES. */
    public static final String INFO_GET_ACCOUNT_PREFERENCES            = "Inside /getAccountPreferences";

    /** The Constant INFO_GET_ACCOUNT_OVERVIEW. */
    public static final String INFO_GET_ACCOUNT_OVERVIEW               = "Inside /getAccountOverview";

    /** The Constant INFO_GET_ACCOUNT_OVERVIEW_POSTPORT. */
    public static final String INFO_GET_ACCOUNT_OVERVIEW_POSTPORT      = "Inside /getAccountOverviewPostPort";

    /** The Constant INFO_ITSONTOKEN. */
    public static final String INFO_ITSONTOKEN                         = "Inside /getItsOnToken";

    /** The Constant PATH. */
    public static final String PATH                                    = "/error";

    /** The Constant SUCCESS. */
    public static final String SUCCESS                                 = "success";

    /** The Constant ERROR. */
    public static final String ERROR                                   = "error";

    /** The Constant STATUS_CODE_SUCCESS. */
    public static final int    STATUS_CODE_SUCCESS                     = 200;

    /** The Constant STATUS_CODE_500. */
    public static final int    STATUS_CODE_500                         = 500;

    /** The Constant STATUS_CODE_404. */
    public static final int    STATUS_CODE_404                         = 404;

    /** The Constant STATUS_MESSAGE_404. */
    public static final String STATUS_MESSAGE_404                      = "No matching resource found";

    /**
     * Error.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @param ex
     *            the ex
     * @return the error json
     */
    @ExceptionHandler
    @RequestMapping( value = PATH)
    CustomHTTPResponse error( HttpServletRequest request, HttpServletResponse response, Exception ex) {

        int statusCode = STATUS_CODE_500;
        HTTPErrorResponse errorResp = new HTTPErrorResponse(ex.getClass().getName(), ex.getMessage());
        if (response.getStatus() == STATUS_CODE_404) {
            statusCode = STATUS_CODE_404;
            errorResp = new HTTPErrorResponse(ex.getClass().getName(), STATUS_MESSAGE_404);
        }
        return new CustomHTTPResponse(ERROR, statusCode, errorResp, request.getRequestURI());
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.boot.autoconfigure.web.ErrorController#getErrorPath()
     */

    @Override
    public String getErrorPath() {

        return PATH;

    }

    /**
     * Creates the account.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the string
     */
    @RequestMapping( value = "${accountService.createAccount.url.mapping}", method = RequestMethod.GET)

    public String createAccount( HttpServletRequest request, HttpServletResponse response) {
        log.info(INFO_CREATE_ACCOUNT);
        return mAccountService.createAccount();
    }

    /**
     * Creates the account.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the string
     */
    @RequestMapping( value = "${accountService.deleteAccount.url.mapping}", method = RequestMethod.GET)
    public String deleteAccount( HttpServletRequest request, HttpServletResponse response) {
        log.info(INFO_DELETE_ACCOUNT);
        return mAccountService.deleteAccount();
    }

    /**
     * Gets the current plans.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the current plans
     * @throws IOException
     *             the IO exception
     */
    @RequestMapping( value = "${accountService.getCurrentPlans.url.mapping}", method = RequestMethod.GET)

    public CustomHTTPResponse getCurrentPlans( HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info(INFO_GET_CURR_PLANS);
        String json = mAccountService.getCurrentPlans();
        JsonNode obj = mapper.readValue(json, JsonNode.class);
        return new CustomHTTPResponse(SUCCESS, STATUS_CODE_SUCCESS, obj, request.getRequestURI());
    }

    /**
     * Retrieves the details of charges, services and date of next MRC.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the MRC details
     * @throws IOException
     *             the IO exception
     */
    @RequestMapping( value = "${accountService.getMRCDetails.url.mapping}", method = RequestMethod.GET)

    public CustomHTTPResponse getMRCDetails( HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info(INFO_MRC_DETAILS);
        String json = mAccountService.getMRCDetails();

        JsonNode obj = mapper.readValue(json, JsonNode.class);
        return new CustomHTTPResponse(SUCCESS, STATUS_CODE_SUCCESS, obj, request.getRequestURI());
    }

    /**
     * Retrieves details about the current device(s) associated with an account.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the device info
     * @throws IOException
     *             the IO exception
     */
    @RequestMapping( value = "${accountService.getDeviceInfo.url.mapping}", method = RequestMethod.GET)

    public CustomHTTPResponse getDeviceInfo( HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info(INFO_GET_DEVICE_INFO);
        String json = mAccountService.getDeviceInfo();
        JsonNode obj = mapper.readValue(json, JsonNode.class);
        return new CustomHTTPResponse(SUCCESS, STATUS_CODE_SUCCESS, obj, request.getRequestURI());
    }

    /**
     * Gets the billing history.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the billing history
     * @throws IOException
     *             the IO exception
     */
    @RequestMapping( value = "${accountService.getBillingHistory.url.mapping}", method = RequestMethod.GET)

    public CustomHTTPResponse getBillingHistory( HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info(INFO_BILLING_HISTORY);
        String json = mAccountService.getBillingHistory();

        JsonNode obj = mapper.readValue(json, JsonNode.class);
        return new CustomHTTPResponse(SUCCESS, STATUS_CODE_SUCCESS, obj, request.getRequestURI());
    }

    /**
     * Swap device.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the string
     * @throws IOException
     *             the IO exception
     */
    @RequestMapping( value = "${accountService.swapDevice.url.mapping}", method = RequestMethod.GET)

    public CustomHTTPResponse swapDevice( HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info(INFO_SWAP_DEVICE);
        String json = mAccountService.swapDevice();

        JsonNode obj = mapper.readValue(json, JsonNode.class);
        return new CustomHTTPResponse(SUCCESS, STATUS_CODE_SUCCESS, obj, request.getRequestURI());
    }

    /**
     * Change phone number.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the string
     * @throws IOException
     *             the IO exception
     */
    @RequestMapping( value = "${accountService.changePhoneNumber.url.mapping}", method = RequestMethod.GET)

    public CustomHTTPResponse changePhoneNumber( HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info(INFO_CHANGE_PHONE_NUMBER);
        String json = mAccountService.changePhoneNumber();

        JsonNode obj = mapper.readValue(json, JsonNode.class);
        return new CustomHTTPResponse(SUCCESS, STATUS_CODE_SUCCESS, obj, request.getRequestURI());
    }

    /**
     * This service is called in Account Service flow, to get Shipment details.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the shipment details
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${accountService.shipmentDetails.url.mapping}", method = RequestMethod.GET)
    public String getShipmentDetails( HttpServletRequest request, HttpServletResponse response) throws Throwable {
        log.info(INFO_GET_SHIPMENT_DETAILS);
        return mAccountService.getShipmentDetails();
    }

    /**
     * This service is called in Account Service flow, to get order details.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the order and line items
     * @throws IOException
     *             the IO exception
     */

    @RequestMapping( value = "${accountService.orderAndLineItems.url.mapping}", method = RequestMethod.GET)
    public String getOrderAndLineItems( HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info(INFO_GET_ORDER_AND_LINE_ITEMS);
        return mAccountService.getOrderAndLineItems();
    }

    /**
     * This service is called to get customer IB payment status.
     *
     * @param iBDetails
     *            the i b details
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the IB details
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${accountService.IBDetails.url.mapping}", method = RequestMethod.POST)
    public CustomHTTPResponse getIBDetails( @RequestBody( required = true) String iBDetails, HttpServletRequest request, HttpServletResponse response)
            throws Throwable {

        log.info(INFO_GET_IB_DETAILS);
        String json = mAccountService.getIBDetails(iBDetails);
        JsonNode obj = mapper.readValue(json, JsonNode.class);
        return new CustomHTTPResponse(SUCCESS, STATUS_CODE_SUCCESS, obj, request.getRequestURI());
    }

    /**
     * This service is called, to get the link for IB contract PDF document.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the IB contract
     * @throws IOException
     *             the IO exception
     */
    @RequestMapping( value = "${accountService.IBContract.url.mapping}", method = RequestMethod.GET)
    public CustomHTTPResponse getIBContract( HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info(INFO_GET_IB_CONTRACT);
        String json = mAccountService.getIBContract();

        JsonNode obj = mapper.readValue(json, JsonNode.class);
        return new CustomHTTPResponse(SUCCESS, STATUS_CODE_SUCCESS, obj, request.getRequestURI());
    }

    /**
     * This service is called in eCommerce flow, to check customer eligibility for IB.
     *
     * @param checkIbRequest
     *            the check ib request
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the string
     * @throws IOException
     *             the IO exception
     */
    @RequestMapping( value = "${accountService.checkIB.url.mapping}", method = RequestMethod.POST)
    public CustomHTTPResponse checkIB( @RequestBody( required = true) String checkIbRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        log.info(INFO_CHECK_IB);
        String json = mAccountService.checkIB(checkIbRequest);
        log.info("json return value " + json);
        JsonNode obj = mapper.readValue(json, JsonNode.class);
        return new CustomHTTPResponse(SUCCESS, STATUS_CODE_SUCCESS, obj, request.getRequestURI());
    }

    /**
     * This service is called in eCommerce flow, to indicate to CRM that customer has accepted IB contract.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the string
     * @throws IOException
     *             the IO exception
     */
    @RequestMapping( value = "${accountService.acceptIBContract.url.mapping}", method = RequestMethod.GET)
    public String acceptIBContract( HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info(INFO_ACCEPT_IB_CONTRACT);
        return mAccountService.acceptIBContract();
    }

    /**
     * Close ticket. This service called in Account Service flow, to close a support ticket.
     *
     * @param ticketId
     *            the ticket id
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the string
     * @throws IOException
     *             the IO exception
     */
    @RequestMapping( value = "${accountService.closeTicket.url.mapping}", method = RequestMethod.DELETE)
    public CustomHTTPResponse closeTicket( @RequestParam( value = "ticketId") String ticketId, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        log.info(INFO_CLOSE_TICKET);
        String json = mAccountService.closeTicket(ticketId);

        JsonNode obj = mapper.readValue(json, JsonNode.class);
        return new CustomHTTPResponse(SUCCESS, STATUS_CODE_SUCCESS, obj, request.getRequestURI());
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
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the list of support ticket details
     * @throws IOException
     *             the IO exception
     */
    @RequestMapping( value = "${accountService.createUpdateTicket.url.mapping}", method = RequestMethod.GET)
    public CustomHTTPResponse getListOfSupportTicketDetails( @RequestParam( value = "gigyaId") String gigyaId,
            @RequestParam( value = "maxRecords") int maxRecords, @RequestParam( value = "offSet") int offSet, HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        log.info(INFO_GET_LIST_OF_SUPPORT_TICKET_DETAILS);
        String json = mAccountService.getListOfSupportTicketDetails(gigyaId, maxRecords, offSet);
        log.info("json return value " + json);
        JsonNode obj = mapper.readValue(json, JsonNode.class);
        return new CustomHTTPResponse(SUCCESS, STATUS_CODE_SUCCESS, obj, request.getRequestURI());
    }

    /**
     * Gets the account preferences.
     *
     * @param uid
     *            the uid
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the account preferences
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${accountService.accountPreferences.url.mapping}", method = RequestMethod.GET)
    public String getAccountPreferences( @RequestParam( value = "uid") String uid, HttpServletRequest request, HttpServletResponse response) throws Throwable {
        log.info(INFO_GET_ACCOUNT_PREFERENCES);
        return mAccountService.getAccountPreferences(uid);
    }

    /**
     * Gets the account overview.
     *
     * @param uid
     *            the uid
     * @param optedToPort
     *            the opted to port
     * @param portStatus
     *            the port status
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the account overview
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${accountService.accountOverview.url.mapping}", method = RequestMethod.GET)
    public String getAccountOverview( @RequestParam( value = "uid") String uid, @RequestParam( value = "opted_to_port") String optedToPort,
            @RequestParam( value = "port_status") String portStatus, HttpServletRequest request, HttpServletResponse response) throws Throwable {
        log.info(INFO_GET_ACCOUNT_OVERVIEW);
        return mAccountService.getAccountOverview(uid, optedToPort, portStatus);
    }

    /**
     * Gets the account overview post port.
     *
     * @param uid
     *            the uid
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the account overview post port
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${accountService.accountOverview.postPort.url.mapping}", method = RequestMethod.GET)
    public String getAccountOverviewPostPort( @RequestParam( value = "uid") String uid, HttpServletRequest request, HttpServletResponse response)
            throws Throwable {
        log.info(INFO_GET_ACCOUNT_OVERVIEW_POSTPORT);
        return mAccountService.getAccountOverviewPostPort(uid);
    }

    /**
     * Gets the account benefits.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the account benefits
     * @throws IOException
     *             the IO exception
     */
    @RequestMapping( value = "${accountService.accountBenefits.url.mapping}", method = RequestMethod.GET)
    public String getAccountBenefits( HttpServletRequest request, HttpServletResponse response) throws IOException {

        return mAccountService.getAccountbenefits();
    }

    /**
     * Gets the user line list.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the user line list
     * @throws IOException
     *             the IO exception
     */
    @RequestMapping( value = "${accountService.userLineList.url.mapping}", method = RequestMethod.GET)
    public String getUserLineList( HttpServletRequest request, HttpServletResponse response) throws IOException {
        return mAccountService.getUserLineList();
    }

    /**
     * Gets the refer friend details.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the refer friend details
     * @throws IOException
     *             the IO exception
     */
    @RequestMapping( value = "${accountService.referFriend.url.mapping}", method = RequestMethod.GET)
    public String getReferFriendDetails( HttpServletRequest request, HttpServletResponse response) throws IOException {
        String str = Double.toString(1.2);
        log.info("String is : " + str.toString());
        return mAccountService.getReferFriendDetails();
    }

    /**
     * Gets the invite friend details.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the invite friend details
     * @throws IOException
     *             the IO exception
     */
    @RequestMapping( value = "${accountService.inviteFriend.url.mapping}", method = RequestMethod.GET)
    public String getInviteFriendDetails( HttpServletRequest request, HttpServletResponse response) throws IOException {
        return mAccountService.getInviteFriendDetails();
    }

    /**
     * Gets the account details.
     *
     * @param authToken
     *            the auth token
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the account details
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${accountService.accountDetails.url.mapping}", method = RequestMethod.GET)
    public CustomHTTPResponse getAccountDetails( @RequestHeader( value = "Authorization") String authToken, HttpServletRequest request,
            HttpServletResponse response) throws Throwable {

        String json = mAccountService.getAccountDetails(authToken);

        JsonNode obj = mapper.readValue(json, JsonNode.class);
        return new CustomHTTPResponse(SUCCESS, STATUS_CODE_SUCCESS, obj, request.getRequestURI());
    }

    /**
     * Gets the account balance.
     *
     * @param authToken
     *            the auth token
     * @param accountId
     *            the account id
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the account balance
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${accountService.accountBalance.url.mapping}", method = RequestMethod.GET)
    public CustomHTTPResponse getAccountBalance( @RequestHeader( value = "Authorization") String authToken,
            @RequestParam( value = "accountId") String accountId, HttpServletRequest request, HttpServletResponse response) throws Throwable {

        String json = mAccountService.getAccountBalance(authToken, accountId);

        JsonNode obj = mapper.readValue(json, JsonNode.class);
        return new CustomHTTPResponse(SUCCESS, STATUS_CODE_SUCCESS, obj, request.getRequestURI());
    }

    /**
     * Gets the account invoices.
     *
     * @param authToken
     *            the auth token
     * @param accountId
     *            the account id
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the account invoices
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${accountService.accountInvoices.url.mapping}", method = RequestMethod.GET)
    public CustomHTTPResponse getAccountInvoices( @RequestHeader( value = "Authorization") String authToken,
            @RequestParam( value = "accountId") String accountId, HttpServletRequest request, HttpServletResponse response) throws Throwable {

        String json = mAccountService.getAccountInvoices(authToken, accountId);

        JsonNode obj = mapper.readValue(json, JsonNode.class);
        return new CustomHTTPResponse(SUCCESS, STATUS_CODE_SUCCESS, obj, request.getRequestURI());
    }

    /**
     * Gets the account mrc.
     *
     * @param authToken
     *            the auth token
     * @param accountId
     *            the account id
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the account mrc
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${accountService.accountMRC.url.mapping}", method = RequestMethod.GET)
    public CustomHTTPResponse getAccountMRC( @RequestHeader( value = "Authorization") String authToken, @RequestParam( value = "accountId") String accountId,
            HttpServletRequest request, HttpServletResponse response) throws Throwable {

        String json = mAccountService.getAccountMRC(authToken, accountId);

        JsonNode obj = mapper.readValue(json, JsonNode.class);
        return new CustomHTTPResponse(SUCCESS, STATUS_CODE_SUCCESS, obj, request.getRequestURI());
    }

    /**
     * Gets the account usages.
     *
     * @param authToken
     *            the auth token
     * @param accountId
     *            the account id
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the account usages
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${accountService.accountUsages.url.mapping}", method = RequestMethod.GET)
    public CustomHTTPResponse getAccountUsages( @RequestHeader( value = "Authorization") String authToken, @RequestParam( value = "accountId") String accountId,
            HttpServletRequest request, HttpServletResponse response) throws Throwable {

        String json = mAccountService.getAccountUsages(authToken, accountId);

        JsonNode obj = mapper.readValue(json, JsonNode.class);
        return new CustomHTTPResponse(SUCCESS, STATUS_CODE_SUCCESS, obj, request.getRequestURI());
    }

    /**
     * Gets the its on token.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the its on token
     */
    @RequestMapping( value = "${service.getItsOnToken.url.mapping}", method = RequestMethod.POST)
    public CustomHTTPResponse getItsOnToken( HttpServletRequest request, HttpServletResponse response) {
        log.info(INFO_ITSONTOKEN);
        String json = mAccountService.getItsOnToken();
        return new CustomHTTPResponse(SUCCESS, STATUS_CODE_SUCCESS, json, request.getRequestURI());
    }

    /**
     * Gets the phone and plan details.
     *
     * @param uid
     *            the uid
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the phone and plan details
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${accountService.phoneAndPlanDetails.url.mapping}", method = RequestMethod.GET)
    public String getPhoneAndPlanDetails( @RequestParam( value = "uid") int uid, HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return mAccountService.getPhoneAndPlanDetails(uid);
    }

    /**
     * Gets the profile details.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the profile details
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${accountService.profileDetails.url.mapping}", method = RequestMethod.GET)
    public String getProfileDetails( HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return mAccountService.ProfileDetails();
    }

    /**
     * Gets the manufacturer details.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the manufacturer details
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${accountService.manufacturerDetails.url.mapping}", method = RequestMethod.GET)
    public String getManufacturerDetails( HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return mAccountService.getManufacturerDetails();
    }

    /**
     * Adds the on programs.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the string
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${accountService.addOnPrograms.url.mapping}", method = RequestMethod.GET)
    public String addOnPrograms( HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return mAccountService.addOnPrograms();
    }

    /**
     * Gets the pending activation events.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the pending activation events
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${accountService.pendingActivationEvents.url.mapping}", method = RequestMethod.GET)
    public String getPendingActivationEvents( HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return mAccountService.getPendingActivationEvents();
    }

    /**
     * Activate device.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the string
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${accountService.activateDevice.url.mapping}", method = RequestMethod.GET)
    public String activateDevice( HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return mAccountService.activateDevice();
    }

    /**
     * Update nick name.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the string
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${accountService.updateNickName.url.mapping}", method = RequestMethod.GET)
    public String updateNickName( HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return mAccountService.activateDevice();
    }

    /**
     * Gets the nick name.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the nick name
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${accountService.nickName.url.mapping}", method = RequestMethod.GET)
    public String getNickName( HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return mAccountService.getNickName();
    }

    /**
     * Gets the shipment status.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the shipment status
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${accountService.shipmentStatus.url.mapping}", method = RequestMethod.GET)
    public String getShipmentStatus( HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return mAccountService.getShipmentStatus();
    }

    /**
     * Check device delivery status.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the string
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${accountService.checkDeviceDeliveryStatus.url.mapping}", method = RequestMethod.GET)
    public String checkDeviceDeliveryStatus( HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return mAccountService.checkDeviceDeliveryStatus();
    }

    /**
     * Creates the order.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the string
     * @throws Throwable
     *             the throwable
     */
    @RequestMapping( value = "${accountService.createOrder.url.mapping}", method = RequestMethod.GET)
    public String createOrder( HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return mAccountService.createOrder();
    }

}
