
package com.virgin.utility.service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.virgin.utility.utils.Constants;

/**
 * <p>
 * This class contains service methods for Utility Service
 * </p>
 * .
 *
 * @author UK00472999
 * @project UtilityService
 * @updated DateTime: Sep 14, 2016 5:23:06 PM Author: UK00472999
 */

@Service
public class UtilityServices {

    /** The log. */
    private static Logger      log                           = LoggerFactory.getLogger(UtilityServices.class);

    /** The Java mail sender. */
    @Autowired
    private JavaMailSender     javaMailSender;

    /** The invited and compatible. */
    @Value( "${email.invitedAndCompatible}")
    private String             invitedAndCompatible;

    /** The not invited and compatible. */
    @Value( "${email.notInvitedAndCompatible}")
    private String             notInvitedAndCompatible;

    /** The invited and non compatible. */
    @Value( "${email.invitedandnoncompatible}")
    private String             invitedAndNonCompatible;

    /** The not invited and non compatible. */
    @Value( "${email.notinvitedandnoncompatible}")
    private String             notInvitedAndNonCompatible;

    /** The not migrated not invited and compatible. */
    @Value( "${email.notmigratednotinvitedandcompatible}")
    private String             notMigratedNotInvitedAndCompatible;

    /** The invited and compatible json. */
    @Value( "${invitedAndCompatible.stub.json}")
    private String             invitedAndCompatibleJson;

    /** The not invited and compatible json. */
    @Value( "${notInvitedAndCompatible.stub.json}")
    private String             notInvitedAndCompatibleJson;

    /** The invited and non compatible json. */
    @Value( "${invitedandnoncompatible.stub.json}")
    private String             invitedAndNonCompatibleJson;

    /** The not invited and non compatible json. */
    @Value( "${notinvitedandnoncompatible.stub.json}")
    private String             notInvitedAndNonCompatibleJson;

    /** The not migrated not invited and compatible json. */
    @Value( "${notmigratednotinvitedandcompatible.stub.json}")
    private String             notMigratedNotInvitedAndCompatibleJson;

    /** The default stub json. */
    @Value( "${default.stub.json}")
    private String             defaultStubJson;

    /** The support signin details. */
    @Value( "${support.signin.details.stub.json}")
    private String             supportSigninDetails;

    /** The supportscheduleacall options. */
    @Value( "${support.schedule.call.options.stub.json}")
    private String             supportScheduleACallOptions;

    /** The Constant LOG_BEFORE_MIME. */
    public static final String LOG_BEFORE                    = "Before";

    /** The Constant LOG_AFTER_MIME. */
    public static final String LOG_AFTER                     = "After";

    /** The Constant LOG_MIME. */
    public static final String LOG_MIME                      = "MIME";

    /** The Constant LOG_AFTER_HELPER. */
    public static final String LOG_HELPER                    = "Helper";

    /** The Constant LOG_UPDATE. */
    public static final String LOG_UPDATE                    = "update";

    /** The Constant MDN_NUMBER_COMPATIBLE. */
    public static final String MDN_NUMBER_COMPATIBLE         = "9132289407";

    /** The Constant MDN_NUMBER_NOT_COMPATIBLE. */
    public static final String MDN_NUMBER_NOT_COMPATIBLE     = "9137423049";

    /** The Constant AUTHENTICATE_BT_USER_PASSWORD. */
    public static final String AUTHENTICATE_BT_USER_PASSWORD = "1234";

    /**
     * Authenticat bt user.
     *
     * @param email
     *            the email
     * @param password
     *            the password
     * @return the string
     */
    public String authenticatBTUser( String email, String password) {

        if (email.equalsIgnoreCase(MDN_NUMBER_COMPATIBLE) && password.equalsIgnoreCase(AUTHENTICATE_BT_USER_PASSWORD)) {
            return invitedAndCompatibleJson;
        } else if (email.equalsIgnoreCase(MDN_NUMBER_COMPATIBLE) && password.equalsIgnoreCase(AUTHENTICATE_BT_USER_PASSWORD)) {
            return notInvitedAndCompatibleJson;
        } else if (email.equalsIgnoreCase(MDN_NUMBER_NOT_COMPATIBLE) && password.equalsIgnoreCase(AUTHENTICATE_BT_USER_PASSWORD)) {
            return invitedAndNonCompatibleJson;
        } else if (email.equalsIgnoreCase(MDN_NUMBER_NOT_COMPATIBLE) && password.equalsIgnoreCase(AUTHENTICATE_BT_USER_PASSWORD)) {
            return notInvitedAndNonCompatibleJson;
        } else if (email.equalsIgnoreCase(MDN_NUMBER_NOT_COMPATIBLE) && password.equalsIgnoreCase(AUTHENTICATE_BT_USER_PASSWORD)) {
            return notMigratedNotInvitedAndCompatibleJson;
        }

        return defaultStubJson;
    }

    /**
     * Send email notification.
     *
     * @param pTo
     *            the To
     * @param pSub
     *            the Sub
     * @param pMailBody
     *            the Mail body
     * @throws Exception
     *             the exception
     */
    public void sendEmailNotification( String pTo, String pSub, String pMailBody) throws Exception {
        log.info(LOG_BEFORE + Constants.BLANK_SPACE + LOG_MIME);
        MimeMessage email = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(email, true);
        log.info(LOG_AFTER + Constants.BLANK_SPACE + LOG_MIME);
        helper.setTo(pTo);
        helper.setSubject(pSub);
        helper.setText(pMailBody);
        log.info(LOG_BEFORE + Constants.BLANK_SPACE + LOG_HELPER);
        javaMailSender.send(email);
        log.info(LOG_AFTER + Constants.BLANK_SPACE + LOG_HELPER);
    }

    /**
     * Gets the support signin details.
     *
     * @param uid
     *            the uid
     * @return the support signin details
     * @throws JsonProcessingException
     *             the json processing exception
     */
    public String getSupportSigninDetails( String uid) throws JsonProcessingException {

        // create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = objectMapper.readTree(supportSigninDetails);
        } catch (IOException e) {
            log.info(e.getMessage());
        }
        String originalSupportSigninJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);

        log.debug(LOG_BEFORE + Constants.BLANK_SPACE + LOG_UPDATE + originalSupportSigninJson);

        ((ObjectNode) root).put("uid", uid);
        JsonNode deduction = root.get("deduction");

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 10);
        Date todate1 = cal.getTime();
        String finalDate = dateFormat.format(todate1);

        ((ObjectNode) deduction).put("date", finalDate);

        String resultUpdate = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
        log.debug(LOG_AFTER + Constants.BLANK_SPACE + LOG_UPDATE + resultUpdate);

        return resultUpdate;

    }

    /**
     * Gets the support schedule a call options.
     *
     * @return the support schedule a call options
     */
    public String getSupportScheduleACallOptions() {
        return supportScheduleACallOptions;
    }

}
