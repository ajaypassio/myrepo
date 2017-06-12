
package com.virgin.utility.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.virgin.utility.service.JWTDecoder;
import com.virgin.utility.service.JWTGenerator;
import com.virgin.utility.service.UtilityServices;
import com.virgin.utility.utils.Constants;

/**
 * <p>
 * This class contains all rest end points for Utility Service
 * </p>
 * .
 *
 * @author UK00472999
 * @project UtilityService
 * @updated DateTime: Sep 14, 2016 5:23:06 PM Author: UK00472999
 */

@RestController
@EnableDiscoveryClient
public class UtilityController {

    /** The log. */
    private static Logger      log                                           = LoggerFactory.getLogger(UtilityController.class);

    /** The service. */
    @Autowired
    private UtilityServices    service;

    /** The Constant INFO_AUTHENTICATE_BT_USER. */
    public static final String LOG_AUTHENTICATE_BT_USER                      = "Inside / authenticatBTUser";

    /** The Constant INFO_SEND_EMAIL. */
    public static final String LOG_SEND_EMAIL                                = "Inside / sendEmail";

    /** The Constant EMAIL_SUCCESS_CONSTANT. */
    public static final String EMAIL_SUCCESS_CONSTANT                        = "\"message\":\"Email successfully sent to...";

    /** The Constant EMAIL_ERROR_CONSTANT. */
    public static final String EMAIL_ERROR_CONSTANT                          = "\"message\":\"Error Sending Email due to...";

    /** The Constant LOG_GET_SUPPORT_SINGIN_DETAILS. */
    public static final String LOG_GET_SUPPORT_SINGIN_DETAILS                = "inside /getSupportSigninDetails";

    /** The Constant LOG_GET_SUPPORT_SCHEDULE_CALL_OPTIONS_DETAILS. */
    public static final String LOG_GET_SUPPORT_SCHEDULE_CALL_OPTIONS_DETAILS = "inside /getsupportscheduleacallOptions";

    /** The email subject. */
    @Value( "${email.subject.content}")
    private String             emailSubject;

    /** The email body. */
    @Value( "${email.body.content}")
    private String             emailBody;

    /**
     * Authenticat bt user.
     *
     * @param email
     *            the email
     * @param password
     *            the password
     * @return the string
     * @throws Exception
     *             the exception
     */
    @RequestMapping( value = "${utilityService.authenticatBTUser.url.mapping}", method = RequestMethod.GET)
    public String authenticatBTUser( @RequestParam( "email") String email, @RequestParam( "password") String password) throws Exception {
        log.info(LOG_AUTHENTICATE_BT_USER);
        return service.authenticatBTUser(email, password);
    }

    /**
     * Send email.
     *
     * @param to
     *            the to
     * @return the string
     */
    @RequestMapping( value = "${utilityService.sendEmail.url.mapping}", method = RequestMethod.GET)
    public String sendEmail( @RequestParam( value = "to") String to) {
        String errorCause = null;
        log.info(LOG_SEND_EMAIL);
        log.debug(to);

        String subject = emailSubject;
        String mailBody = emailBody;

        log.debug(subject);
        log.debug(mailBody);
        try {
            service.sendEmailNotification(to, subject, mailBody);
            return Constants.STARTBRACES + EMAIL_SUCCESS_CONSTANT + to + "\"" + Constants.ENDBRACES;
        } catch (Exception e) {
            errorCause = e.getCause().toString();
            log.error(e.getMessage() + e.getCause());
        }
        return Constants.STARTBRACES + EMAIL_ERROR_CONSTANT + errorCause + "\"" + Constants.ENDBRACES;
    }

    /**
     * Gets the support signin details.
     *
     * @param uid
     *            the uid
     * @return the support signin details
     * @throws Exception
     *             the exception
     */
    @RequestMapping( value = "${support.signinDetails.url.mapping}", method = RequestMethod.GET)
    public String getSupportSigninDetails( @RequestParam( "uid") String uid) throws Exception {
        log.info(LOG_GET_SUPPORT_SINGIN_DETAILS);
        return service.getSupportSigninDetails(uid);
    }

    /**
     * Gets the support schedule a call options.
     *
     * @return the support schedule a call options
     */
    @RequestMapping( value = "${support.schedule.call.options.url.mapping}", method = RequestMethod.GET)
    public String getSupportScheduleACallOptions() {
        log.info(LOG_GET_SUPPORT_SCHEDULE_CALL_OPTIONS_DETAILS);
        return service.getSupportScheduleACallOptions();
    }

    /**
     * Get value from "JWTGenrator" for signing JWT.
     *
     * @param json
     *            the json
     * @return Key for signing JWT
     */
    @RequestMapping( value = { "${crowdcare_jwtgeneratorservice.mapping}" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
    public String getJWTGenerator( @RequestBody String json) {

        log.info("Access /CrowdCare");
        log.info("Gigya Id is" + " " + json);

        String jwt = null;
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> map = new HashMap<String, Object>();

        // convert JSON string to Map
        try {

            map = mapper.readValue(json, new TypeReference<Map<String, Object>>() {
            });

        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("MAP" + (map.size()));
        // Create a JWT
        JWTGenerator generator = new JWTGenerator();
        jwt = generator.createJWT(map);
        log.info("JWT generated:");
        /*
         * JSONObject json = new JSONObject(); json.put("token", jwt);
         */
        return jwt;

    }

    /**
     * Get value from "JWTDecoder" for signing JWT.
     *
     * @param jwt
     *            the jwt
     * @return Key for signing JWT
     */
    @RequestMapping( value = { "${crowdcare_jwtdecoderservice.mapping}" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
    public Map<String, Object> getJWTDecoder( @RequestBody String jwt) {
        log.info("Access /CrowdCare");
        log.info("JWT Key is" + " " + jwt);

        // Decode the JWT
        log.info("Decode JWT:");
        JWTDecoder decoder = new JWTDecoder();
        Map<String, Object> jwtDecoder = decoder.decodeJWT(jwt);
        log.info("JWT Decorder value is" + " " + jwtDecoder);
        return jwtDecoder;

    }
}
