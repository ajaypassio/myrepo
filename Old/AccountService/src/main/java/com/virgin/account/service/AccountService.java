
package com.virgin.account.service;

import java.net.InetSocketAddress;
import java.net.Proxy.Type;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.virgin.account.utils.Constants;

/**
 * The Class AccountService.
 */
@Service
public class AccountService {

    /** The log. */
    private static Logger      log                                = LoggerFactory.getLogger(AccountService.class);

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

    /** The Constant INFO_OK. */
    public static final String INFO_OK                            = "OK";

    /** The base url. */
    @Value( "${accountService.virgin.cloudhub.baseUrl.mapping}")
    private String             baseUrl;

    /** The proxy url. */
    @Value( "${accountService.virgin.cloudhub.proxyUrl.mapping}")
    private String             proxyUrl;

    /** The proxy port. */
    @Value( "${accountService.virgin.cloudhub.proxyPort.mapping}")
    private int                proxyPort;

    /** The proxy. */
    @Value( "${useproxy}")
    private String             proxy;

    /** The Sample json_1. */
    @Value( "${accountServiceService.SampleJson_1}")
    private String             SampleJson_1;

    /** The Sample json_2. */
    @Value( "${accountServiceService.SampleJson_2}")
    private String             SampleJson_2;

    /** The Sample json_3. */
    @Value( "${accountServiceService.SampleJson_3}")
    private String             SampleJson_3;

    /**
     * Creates the account.
     *
     * @return the string
     */
    public String createAccount() {

        return SampleJson_1;

    }

    /**
     * Delete account.
     *
     * @return the string
     */

    public String deleteAccount() {

        return SampleJson_2;

    }

    /**
     * Adds the subscriber.
     *
     * @return the string
     */

    public String addSubscriber() {

        return SampleJson_2;

    }

    /**
     * Removes the subscriber.
     *
     * @return the string
     */

    public String removeSubscriber() {

        return SampleJson_2;

    }

    /**
     * Gets the current plans.
     *
     * @return the current plans
     */

    public String getCurrentPlans() {

        return SampleJson_2;

    }

    /**
     * Gets the mrc details.
     *
     * @return the MRC details
     */

    public String getMRCDetails() {

        return SampleJson_2;

    }

    /**
     * Gets the device info.
     *
     * @return the device info
     */

    public String getDeviceInfo() {

        return SampleJson_2;

    }

    /**
     * Gets the billing history.
     *
     * @return the billing history
     */

    public String getBillingHistory() {

        return SampleJson_2;

    }

    /**
     * Swap device.
     *
     * @return the string
     */

    public String swapDevice() {

        return SampleJson_2;

    }

    /**
     * Change phone number.
     *
     * @return the string
     */

    public String changePhoneNumber() {

        return SampleJson_2;

    }

    /**
     * Gets the ib contract.
     *
     * @return the IB contract
     */

    public String getIBContract() {

        return SampleJson_2;

    }

    /**
     * Gets the shipment details.
     *
     * @return the shipment details
     */

    public String getShipmentDetails() {

        return SampleJson_2;

    }

    /**
     * Gets the order and line items.
     *
     * @return the order and line items
     */
    public String getOrderAndLineItems() {
        log.info(GET_ORDER_AND_LINE_ITEMS + Constants.LOG_INFO_VALUE);
        return SampleJson_3;
    }

    /**
     * Gets the ib details.
     *
     * @param iBDetails
     *            the i b details
     * @return the IB details
     */
    public String getIBDetails( String iBDetails) {
        RestTemplate restTemplate = getRestTemplate();

        JSONObject jsonObj = new JSONObject(iBDetails);
        String gigyaId = (String) jsonObj.get("gigyaid");
        String url = baseUrl + Constants.BACK_SLASH + ACCOUNT_URL + Constants.BACK_SLASH + gigyaId + Constants.BACK_SLASH + INSTALL_BILLING;
        log.info(GET_IB_DETAILS + Constants.LOG_INFO_VALUE + url);
        String resp = restTemplate.postForObject(url, new String(iBDetails), String.class);

        return resp;
    }

    /**
     * Check ib.
     *
     * @param checkIbRequest
     *            the check ib request
     * @return the string
     */
    public String checkIB( String checkIbRequest) {
        RestTemplate restTemplate = getRestTemplate();
        String url = baseUrl + Constants.BACK_SLASH + IB_CHECK;
        log.info(CHECK_IB + Constants.LOG_INFO_VALUE + url);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Basic");
        HttpEntity<String> entity = new HttpEntity<String>(checkIbRequest, headers);

        String resp = restTemplate.postForObject(url, entity, String.class);
        return resp;
    }

    /**
     * Accept ib contract.
     *
     * @return the string
     */
    public String acceptIBContract() {
        log.info(ACCEPT_IB_CONTRACT + Constants.LOG_INFO_VALUE);
        return SampleJson_3;
    }

    /**
     * Creates/Update the ticket.
     *
     * @param createTicketRequest
     *            the create ticket request
     * @return the string
     */
    public HttpStatus createUpdateTicket( String createTicketRequest) {
        RestTemplate restTemplate = getRestTemplate();

        JSONObject jsonObj = new JSONObject(createTicketRequest);
        String ticketId = (String) jsonObj.get("id");
        String url = baseUrl + Constants.BACK_SLASH + TICKETS + Constants.BACK_SLASH + ticketId;

        log.info(CREATE_UPDATE_TICKETS + Constants.LOG_INFO_VALUE + url);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Basic");
        HttpEntity<String> entity = new HttpEntity<String>(createTicketRequest, headers);

        // restTemplate.put(url, entity);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
        HttpStatus status = responseEntity.getStatusCode();
        return status;
    }

    /**
     * Close ticket.
     *
     * @param ticketId
     *            the ticket id
     * @return the string
     */
    public String closeTicket( String ticketId) {

        RestTemplate restTemplate = getRestTemplate();
        String url = baseUrl + Constants.BACK_SLASH + TICKETS + Constants.BACK_SLASH + ticketId;
        log.info(CLOSE_TICKETS + Constants.LOG_INFO_VALUE + url);
        restTemplate.delete(url);
        return INFO_OK;
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
     */
    public String getListOfSupportTicketDetails( String gigyaId, int maxRecords, int offSet) {

        RestTemplate restTemplate = null;
        try {
            restTemplate = getRestTemplate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String url = baseUrl + Constants.BACK_SLASH + ACCOUNT_URL + Constants.BACK_SLASH;
        url = url + gigyaId + Constants.BACK_SLASH + TICKETS + Constants.QUESTION_SIGN + MAX_RECORDS + Constants.EQUAL_SIGN + maxRecords + Constants.AMPERSAND
                + OFFSET + Constants.EQUAL_SIGN + offSet;
        log.info(GET_LIST_OF_SUPPORT_TICKET_DETAILS + Constants.LOG_INFO_VALUE + url);
        String json = restTemplate.getForObject(url, String.class);
        return json;

    }

    /**
     * Gets the rest template.
     *
     * @return the rest template
     */
    private RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        if (Constants.TRUE.equalsIgnoreCase(proxy)) {
            SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
            log.info("PORT: " + proxyPort);
            InetSocketAddress address = new InetSocketAddress(proxyUrl, proxyPort);
            java.net.Proxy restProxy = new java.net.Proxy(Type.HTTP, address);

            factory.setProxy(restProxy);

            restTemplate.setRequestFactory(factory);
            return restTemplate;
        }
        return restTemplate;
    }
}
