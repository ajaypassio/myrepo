
package com.virgin.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>
 * The starter clas for Ecommerce Service
 * </p>
 * .
 *
 * @author ND00434775
 * @project EcommerceService
 * @updated DateTime: Sep 14, 2016 5:23:06 PM Author: ND00434775
 */

@SpringBootApplication
@EnableDiscoveryClient
public class Application {

    /**
     * The main method.
     *
     * @param args
     *            the args
     * @throws Throwable
     */
    public static void main( String[] args) throws Throwable {

        SpringApplication.run(Application.class, args);

    }

}
