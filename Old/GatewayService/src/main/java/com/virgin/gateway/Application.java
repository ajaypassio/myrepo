
package com.virgin.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.virgin.gateway.filters.ResponseFilter;
import com.virgin.gateway.filters.RequestFilter;

/**
 * <p>
 * Starter class for API Gateway Service
 * </p>
 * .
 *
 * @author SS00443175
 * @project GatewayService
 * @updated DateTime: Jul 28, 2016 4:30:51 PM Author: SS00443175
 */

@EnableZuulProxy
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

    /**
     * Simple filter.
     *
     * @return the simple filter
     */
    @Bean
    public RequestFilter simpleFilter() {
        return new RequestFilter();
    }

    /**
     * Response filter.
     *
     * @return the response filter
     */
    @Bean
    public ResponseFilter responseFilter() {
        return new ResponseFilter();
    }

}
