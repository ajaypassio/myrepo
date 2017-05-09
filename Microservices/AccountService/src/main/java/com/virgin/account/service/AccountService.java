
package com.virgin.account.service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy.Type;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.virgin.account.utils.Constants;

// TODO: Auto-generated Javadoc
/**
 * The Class AccountService.
 */
@Service
public class AccountService {

    /** The log. */
    private static Logger      log                                = LoggerFactory.getLogger(AccountService.class);

    /** The mapper. */
    @Autowired
    ObjectMapper               mapper;

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

    /** The Constant TOKEN. */
    public static final String TOKEN                              = "token";

    /** The Constant OAUTH. */
    public static final String OAUTH                              = "oauth2";

    /** The Constant GET_INVENTORY. */
    public static final String GET_INVENTORY                      = "getInventory";

    /** The Constant INFO_OK. */
    public static final String INFO_OK                            = "OK";

    /** The Constant LOG_BEFORE_MIME. */
    public static final String LOG_BEFORE                         = "Before";

    /** The Constant LOG_AFTER_MIME. */
    public static final String LOG_AFTER                          = "After";

    /** The Constant LOG_UPDATE. */
    public static final String LOG_UPDATE                         = "update";

    /** The Constant ACCOUNT. */
    public static final String ACCOUNT                            = "account";

    /** The Constant XIO_REQUEST_ID. */
    public static final String XIO_REQUEST_ID                     = "X-Io-Request-Id";

    /** The Constant AUTHORIZATION. */
    public static final String AUTHORIZATION                      = "Authorization";

    /** The Constant BALANCE. */
    public static final String BALANCE                            = "balance";

    /** The Constant INVOICES. */
    public static final String INVOICES                           = "invoices";

    /** The Constant RECURRING. */
    public static final String RECURRING                          = "recurring";

    /** The Constant PAYMENT_METHODS. */
    public static final String PAYMENT_METHODS                    = "paymentmethods";

    /** The Constant USAGES. */
    public static final String USAGES                             = "usages";

    /** The Constant DEFAULT. */
    public static final String DEFAULT                            = "default";

    /** The Constant AUTOPAY. */
    public static final String AUTOPAY                            = "autopay";

    /** The base url. */
    @Value( "${accountService.virgin.cloudhub.baseUrl.mapping}")
    private String             baseUrl;

    /** The its on base url. */
    @Value( "${virgin.itsOn.baseUrl.mapping}")
    private String             itsOnBaseUrl;

    /** The proxy url. */
    @Value( "${accountService.virgin.cloudhub.proxyUrl.mapping}")
    private String             proxyUrl;

    /** The proxy port. */
    @Value( "${accountService.virgin.cloudhub.proxyPort.mapping}")
    private int                proxyPort;

    /** The add on programs json. */
    @Value( "${accountService.account.addOnPrograms.stubJson}")
    private String             addOnProgramsJson;

    /** The proxy. */
    @Value( "${useproxy}")
    private String             proxy;

    /** The Sample json_1. */
    @Value( "${accountService.SampleJson_1}")
    private String             SampleJson_1;

    /** The Sample json_2. */
    @Value( "${accountService.SampleJson_2}")
    private String             SampleJson_2;

    /** The Sample json_3. */
    @Value( "${accountService.SampleJson_3}")
    private String             SampleJson_3;

    /** The account preferneces json. */
    @Value( "${accountService.account.preferences.stubJson}")
    private String             accountPrefernecesJson;

    /** The account overview json. */
    @Value( "${accountService.account.overview.stubJson}")
    private String             accountOverviewJson;

    /** The account overview post port json. */
    @Value( "${accountService.account.overview.postPort.stubJson}")
    private String             accountOverviewPostPortJson;

    /** The account benefits json. */
    @Value( "${accountService.account.benefits.stubJson}")
    private String             accountBenefitsJson;

    /** The user line list. */
    @Value( "${accountService.account.userLineList.stubJson}")
    private String             userLineList;

    /** The refer friend json. */
    @Value( "${accountService.account.referFriend.stubJson}")
    private String             referFriendJson;

    /** The invite friend json. */
    @Value( "${accountService.account.inviteFriend.stubJson}")
    private String             inviteFriendJson;

    /** The response json uid1. */
    @Value( "${accountService.account.responseJsonUid1.stubJson}")
    private String             responseJsonUid1;

    /** The response json uid2. */
    @Value( "${accountService.account.responseJsonUid2.stubJson}")
    private String             responseJsonUid2;

    /** The response json uid3. */
    @Value( "${accountService.account.responseJsonUid3.stubJson}")
    private String             responseJsonUid3;

    /** The response json uid undefine. */
    @Value( "${accountService.account.responseJsonUidUndefine.stubJson}")
    private String             responseJsonUidUndefine;

    /** The profile response json. */
    @Value( "${accountService.account.profileResponseJson.stubJson}")
    private String             profileResponseJson;

    /** The manufacturer response json. */
    @Value( "${accountService.account.manufacturerResponseJson.stubJson}")
    private String             manufacturerResponseJson;

    /**
     * Creates the account.
     *
     * @return the string
     */
    public String createAccount() {

        return SampleJson_1;

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
     * @throws Throwable
     *             the throwable
     */
    public String getIBDetails( String iBDetails) throws Throwable {
        RestTemplate restTemplate = getRestTemplate();

        JsonNode jsonObj = mapper.readValue(iBDetails, JsonNode.class);
        JsonNode gigyaId = jsonObj.get("gigyaid");
        String url = baseUrl + Constants.BACK_SLASH + ACCOUNT_URL + Constants.BACK_SLASH + gigyaId.asText() + Constants.BACK_SLASH + INSTALL_BILLING;
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

    /**
     * Gets the account preferences.
     *
     * @param uid
     *            the uid
     * @return the account preferences
     * @throws Throwable
     *             the throwable
     */
    public String getAccountPreferences( String uid) throws Throwable {

        // create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = objectMapper.readTree(accountPrefernecesJson);
        } catch (IOException e) {
            log.info(e.getMessage());
        }
        String originalSupportSigninJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);

        log.debug(LOG_BEFORE + Constants.BLANK_SPACE + LOG_UPDATE + originalSupportSigninJson);
        JsonNode accountPreferences = root.get("Account_preferences");
        ((ObjectNode) accountPreferences).put("uid", uid);

        String resultUpdate = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
        log.debug(LOG_AFTER + Constants.BLANK_SPACE + LOG_UPDATE + resultUpdate);

        return resultUpdate;

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
     * @return the account overview
     * @throws Throwable
     *             the throwable
     */
    public String getAccountOverview( String uid, String optedToPort, String portStatus) throws Throwable {

        // create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = objectMapper.readTree(accountOverviewJson);
        } catch (IOException e) {
            log.info(e.getMessage());
        }
        String originalSupportSigninJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);

        log.debug(LOG_BEFORE + Constants.BLANK_SPACE + LOG_UPDATE + originalSupportSigninJson);

        ((ObjectNode) root).put("uid", uid);
        ((ObjectNode) root).put("opted_to_port", optedToPort);
        ((ObjectNode) root).put("port_status", portStatus);

        String resultUpdate = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
        log.debug(LOG_AFTER + Constants.BLANK_SPACE + LOG_UPDATE + resultUpdate);

        return resultUpdate;

    }

    /**
     * Gets the accountbenefits.
     *
     * @return the accountbenefits
     */
    public String getAccountbenefits() {

        return accountBenefitsJson;
    }

    /**
     * Gets the user line list.
     *
     * @return the user line list
     */
    public String getUserLineList() {

        return userLineList;
    }

    /**
     * Gets the refer friend details.
     *
     * @return the refer friend details
     */
    public String getReferFriendDetails() {

        return referFriendJson;

    }

    /**
     * Gets the invite friend details.
     *
     * @return the invite friend details
     */
    public String getInviteFriendDetails() {

        return inviteFriendJson;

    }

    /**
     * Gets the account details.
     *
     * @param authToken
     *            the auth token
     * @return the account details
     */
    public String getAccountDetails( String authToken) {

        RestTemplate restTemplate = getRestTemplate();
        String url = itsOnBaseUrl + Constants.BACK_SLASH + ACCOUNT;
        // "https://api.stg.itsonsaas.net/unified-api/1.0/account";

        HttpHeaders headers = new HttpHeaders();
        headers.add(XIO_REQUEST_ID, getRandomUUID());
        headers.add(AUTHORIZATION, authToken);

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        HttpEntity resp = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return resp.getBody().toString();

    }

    /**
     * Gets the account balance.
     *
     * @param authToken
     *            the auth token
     * @param accountId
     *            the account id
     * @return the account balance
     */
    public String getAccountBalance( String authToken, String accountId) {

        RestTemplate restTemplate = getRestTemplate();
        String url = itsOnBaseUrl + Constants.BACK_SLASH + ACCOUNT + Constants.BACK_SLASH + accountId + Constants.BACK_SLASH + BALANCE;
        // https://api.stg.itsonsaas.net/unified-api/1.0/account/384a8745-def6-4e89-b52f-ca7b1533fff1/balance

        HttpHeaders headers = new HttpHeaders();
        headers.add(XIO_REQUEST_ID, getRandomUUID());
        headers.add(AUTHORIZATION, authToken);

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        HttpEntity resp = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return resp.getBody().toString();

    }

    /**
     * Gets the account invoices.
     *
     * @param authToken
     *            the auth token
     * @param accountId
     *            the account id
     * @return the account invoices
     */
    public String getAccountInvoices( String authToken, String accountId) {

        RestTemplate restTemplate = getRestTemplate();
        String url = itsOnBaseUrl + Constants.BACK_SLASH + ACCOUNT + Constants.BACK_SLASH + accountId + Constants.BACK_SLASH + INVOICES;
        // https://api.stg.itsonsaas.net/unified-api/1.0/account/384a8745-def6-4e89-b52f-ca7b1533fff1/invoices

        HttpHeaders headers = new HttpHeaders();
        headers.add(XIO_REQUEST_ID, getRandomUUID());
        headers.add(AUTHORIZATION, authToken);

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        HttpEntity resp = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return resp.getBody().toString();

    }

    /**
     * Gets the account mrc.
     *
     * @param authToken
     *            the auth token
     * @param accountId
     *            the account id
     * @return the account mrc
     */
    public String getAccountMRC( String authToken, String accountId) {

        RestTemplate restTemplate = getRestTemplate();
        String url = itsOnBaseUrl + Constants.BACK_SLASH + ACCOUNT + Constants.BACK_SLASH + accountId + Constants.BACK_SLASH + RECURRING;
        // https://api.stg.itsonsaas.net/unified-api/1.0/account/0dfd2663-0012-4020-be17-0da734353601/recurring

        HttpHeaders headers = new HttpHeaders();
        headers.add(XIO_REQUEST_ID, getRandomUUID());
        headers.add(AUTHORIZATION, authToken);

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        HttpEntity resp = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return resp.getBody().toString();

    }

    /**
     * Gets the account usages.
     *
     * @param authToken
     *            the auth token
     * @param accountId
     *            the account id
     * @return the account usages
     */
    public String getAccountUsages( String authToken, String accountId) {

        RestTemplate restTemplate = getRestTemplate();
        String url = itsOnBaseUrl + Constants.BACK_SLASH + ACCOUNT + Constants.BACK_SLASH + accountId + Constants.BACK_SLASH + USAGES;
        // https://api.stg.itsonsaas.net/unified-api/1.0/account/0dfd2663-0012-4020-be17-0da734353601/usages
        // account/{{accountId}}/usages
        HttpHeaders headers = new HttpHeaders();
        headers.add(XIO_REQUEST_ID, getRandomUUID());
        headers.add(AUTHORIZATION, authToken);

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        HttpEntity resp = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return resp.getBody().toString();

    }

    /**
     * Gets the random uuid.
     *
     * @return the random uuid
     */
    private String getRandomUUID() {

        return UUID.randomUUID().toString();

    }

    /**
     * Gets the its on token.
     *
     * @return the its on token
     */
    public String getItsOnToken() {
        // It's returning stub data. This will be replaced with actual API calls
        String uniqueID = getRandomUUID();
        log.info(" UUID : " + uniqueID);

        RestTemplate restTemplate = getRestTemplate();
        String url = itsOnBaseUrl + Constants.BACK_SLASH + OAUTH + Constants.BACK_SLASH + TOKEN;

        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
        form.add("grant_type", "password");
        form.add("client_id", "9e671a2e-5eda-11e6-aec3-28cfe9161629");
        form.add("username", "nhontam.che-111@gmail.com");
        form.add("password", "qqqqqqqq");
        form.add("client_secret", "832930076b43f45ebeb714fd7c9e66bb");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add(XIO_REQUEST_ID, uniqueID);

        // headers.set("Accept", "application/json");
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(form, headers);

        // HttpEntity<String> entity = new HttpEntity<String>(body, headers);
        HttpEntity resp = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        return resp.toString();
    }

    /**
     * Gets the account overview post port.
     *
     * @param uid
     *            the uid
     * @return the account overview post port
     * @throws Throwable
     *             the throwable
     */
    public String getAccountOverviewPostPort( String uid) throws Throwable {

        // create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = objectMapper.readTree(accountOverviewPostPortJson);
        } catch (IOException e) {
            log.info(e.getMessage());
        }
        String originalSupportSigninJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);

        log.debug(LOG_BEFORE + Constants.BLANK_SPACE + LOG_UPDATE + originalSupportSigninJson);

        ((ObjectNode) root).put("uid", uid);

        String resultUpdate = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
        log.debug(LOG_AFTER + Constants.BLANK_SPACE + LOG_UPDATE + resultUpdate);

        return resultUpdate;

    }

    /**
     * Delete account.
     *
     * @return the string
     */
    public String deleteAccount() {

        return SampleJson_3;

    }

    /**
     * Gets the phone and plan details.
     *
     * @param uid
     *            the uid
     * @return the phone and plan details
     */
    public String getPhoneAndPlanDetails( int uid) {
        if (uid == 1)
            return responseJsonUid1;
        else if (uid == 2)
            return responseJsonUid2;
        else if (uid == 3)
            return responseJsonUid3;
        else
            return responseJsonUidUndefine;

    }

    /**
     * Profile details.
     *
     * @return the string
     */
    public String ProfileDetails() {

        return profileResponseJson;

    }

    /**
     * Gets the manufacturer details.
     *
     * @return the manufacturer details
     */
    public String getManufacturerDetails() {

        return manufacturerResponseJson;

    }

    /**
     * Adds the on programs.
     *
     * @return the string
     */
    public String addOnPrograms() {

        return addOnProgramsJson;

    }

    public String getPendingActivationEvents() {

        return SampleJson_1;

    }

    public String activateDevice() {

        return SampleJson_1;

    }

    public String getNickName() {

        return SampleJson_1;

    }

    public String getShipmentStatus() {

        return SampleJson_1;

    }

    public String checkDeviceDeliveryStatus() {

        return SampleJson_1;

    }

    public String createOrder() {

        return SampleJson_1;

    }
}
