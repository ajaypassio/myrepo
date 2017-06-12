
package com.virgin.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>
 * Application Class for Payment Microservice which enables Spring Boot
 * </p>
 * .
 *
 * @author ND00434775
 * @project PaymentService
 * @updated DateTime: Sep 14, 2016 6:08:57 PM Author: ND00434775
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
