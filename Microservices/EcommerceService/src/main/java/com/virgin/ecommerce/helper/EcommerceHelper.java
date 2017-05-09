
package com.virgin.ecommerce.helper;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy.Type;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.virgin.ecommerce.utils.Constants;

/**
 * <p>
 * Helper class for Ecommerce Service. Contains common functions for Ecommerce Service
 * </p>
 * .
 *
 * @project EcommerceService
 * 
 */
@Component
public class EcommerceHelper {

    /** The log. */
    private static Logger log = LoggerFactory.getLogger(EcommerceHelper.class);

    /** The base url. */
    @Value( "${ecommerceService.virgin.cloudhub.baseUrl.mapping}")
    private String        baseUrl;

    /** The its on url. */
    @Value( "${ecommerceService.virgin.cloudhub.itsOnUrl.mapping}")
    private String        itsOnUrl;

    /** The proxy url. */
    @Value( "${ecommerceService.virgin.cloudhub.proxyUrl.mapping}")
    private String        proxyUrl;

    @Value( "${ecommerceService.virgin.cloudhub.iconUrl.mapping}")
    private String        iconUrl;

    /** The proxy port. */
    @Value( "${ecommerceService.virgin.cloudhub.proxyPort.mapping}")
    private Integer       proxyPort;

    /** The use proxy. */
    @Value( "${useproxy}")
    private String        useproxy;

    /**
     * Gets the its on token.
     * 
     * @param client_secret
     * @param password
     * @param username
     * @param client_id
     * @param grant_type
     * 
     * @param body
     *
     * @return the its on token
     * @throws IOException
     * @throws JsonProcessingException
     */
    public String getItsOnToken( JsonNode rootNode) throws Throwable {
        String uniqueID = getRandomUUID();
        log.debug(" UUID : " + uniqueID);
        log.debug("Node : " + rootNode.toString() + ", " + rootNode.findValue("grant_type").asText());

        RestTemplate restTemplate = getRestTemplate();
        String url = "https://api.stg.itsonsaas.net/api/1.0/oauth2/token";

        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
        form.add("grant_type", rootNode.findValue("grant_type").asText());
        form.add("client_id", rootNode.findValue("client_id").asText());
        form.add("username", rootNode.findValue("username").asText());
        form.add("password", rootNode.findValue("password").asText());
        form.add("client_secret", rootNode.findValue("client_secret").asText());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Content-Type", "application/json");
        headers.add("X-Io-Request-Id", uniqueID);

        headers.set("Accept", "application/json");
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(form, headers);

        // HttpEntity<String> entity = new HttpEntity<String>(body, headers);
        HttpEntity resp = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        // String resp = jerseyWebTarget.request().accept(MediaType.APPLICATION_FORM_URLENCODED).post(Entity.form(form));
        String clientToken = resp.getBody().toString();
        return getActualToken(clientToken, url, form);

    }

    private String getActualToken( String clientToken, String url, MultiValueMap<String, String> form) {

        RestTemplate restTemplate = getRestTemplate();
        String uniqueID = getRandomUUID();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Content-Type", "application/json");
        headers.add("X-Io-Request-Id", uniqueID);
        headers.add("Authorization", clientToken);
        headers.set("Accept", "application/json");
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(form, headers);

        HttpEntity resp = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        String respJson = resp.getBody().toString();
        return respJson;
    }

    public String getRandomUUID() {

        return UUID.randomUUID().toString();

    }

    /**
     * Gets the rest template.
     *
     * @return the rest template
     */
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        if (Constants.TRUE.equalsIgnoreCase(useproxy)) {
            SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
            InetSocketAddress address = new InetSocketAddress(proxyUrl, proxyPort);
            java.net.Proxy proxy = new java.net.Proxy(Type.HTTP, address);

            factory.setProxy(proxy);

            restTemplate.setRequestFactory(factory);
            try {
                // restTemplate = createRestTemplate();
                // restTemplate = new RestTemplate();
            } catch (Exception ex) {
                log.error("" + ex);
            }
            return restTemplate;
        }
        return restTemplate;
    }

    /**
     * Adds the header and token.
     *
     * @param clientToken
     *            the client token
     * @return the http entity< string>
     */
    public HttpEntity<String> addHeaderAndToken( String clientToken) {
        String uniqueID = getRandomUUID();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("X-IO-Request-Id", "******************");
        headers.add("Authorization", clientToken);
        headers.set("Accept", "application/json");
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return entity;
    }

}
