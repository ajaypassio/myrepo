
package com.virgin.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>
 * This is the CLASS Application for the Account microservice which enables Spring Boot
 * </p>
 * .
 *
 * @author ND00434775
 * @project AccountService1
 * @updated DateTime: Sep 14, 2016 5:58:28 PM Author: ND00434775
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Application {

    /**
     * The main method.
     *
     * @param args
     *            the args
     */
    public static void main( String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
