
package com.virgin.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <p>
 * Starting class for Eureka Server
 * </p>
 * .
 *
 * @author SS00443175
 * @project EurekaServer
 * @updated DateTime: Aug 22, 2016 5:05:02 PM Author: SS00443175
 */

@SpringBootApplication
@EnableEurekaServer
public class Application {

    /**
     * The main method.
     *
     * @param args
     *            the args
     * @throws Exception
     *             the exception
     */
    public static void main( String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
