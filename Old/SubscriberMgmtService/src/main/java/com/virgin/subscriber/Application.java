
package com.virgin.subscriber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>
 * This is the Starter class for Subscriber Mgmt Service.
 * </p>
 * 
 * @author UK00472999
 * @project SubscriberMgmtService
 * @updated DateTime: Sep 14, 2016 5:23:06 PM Author: UK00472999
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
