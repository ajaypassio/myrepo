package com.paymore.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloWorldController {
	
	    @Value("${prop1:default}") private String prop1;
	    @Value("${prop2:default}") private String prop2;

	    @RequestMapping(value = "/world", method = RequestMethod.GET)
	    public String getHelloWorld() {
	        return new StringBuilder()
	                .append("Message: ")
	                .append(prop1).append(" ")
	                .append(prop2).append("!")
	                .toString();
	    }
}
