/**
 * 
 */
package com.paymore.account.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AK00487304
 *
 */
@RestController
@RefreshScope
public class AccountServiceController {
	
	/** The log. */
    private static Logger    log = LoggerFactory.getLogger(AccountServiceController.class);
	
	@RequestMapping( value = "${account.getAccountDetails.url.mapping}", method = RequestMethod.GET)
    public String getAccountDetails( HttpServletRequest request, HttpServletResponse response) throws IOException {
       log.info("Request received");
       return "success";
    }
	
}
