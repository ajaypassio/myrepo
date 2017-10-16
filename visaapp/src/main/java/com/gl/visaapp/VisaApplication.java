package com.gl.visaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ajay Kumar
 *
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan("com")
public class VisaApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(VisaApplication.class, args);
	}
	
}
