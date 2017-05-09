
package com.virgin.configServer;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import com.virgin.configServer.util.Constant;

/**
 * <p>
 * Starter class for Config Server
 * </p>
 * .
 *
 * @author SS00443175
 * @project ConfigServer
 * @updated DateTime: Sep 9, 2016 3:17:51 PM Author: SS00443175
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigServiceApplication {

    /** The proxy. */
    @Value( "${configServer.createProxy.useproxy}")
    private boolean             proxy;

    /** The proxy host. */
    @Value( "${configServer.createProxy.proxy.host}")
    private String              proxyHost;

    /** The proxt port. */
    @Value( "${configServer.createProxy.proxy.port}")
    private Integer             proxyPort;

    /** The log. */
    private static Logger       log           = LoggerFactory.getLogger(ConfigServiceApplication.class);

    /** The Constant LOG_START_MSG. */
    private static final String LOG_START_MSG = "ConfigService started";

    /**
     * The main method.
     *
     * @param args
     *            the args
     */
    public static void main( String[] args) {
        SpringApplication.run(ConfigServiceApplication.class, args);
    }

    /**
     * Creates the proxy.
     */
    @PostConstruct
    public void createProxy() {
        log.info(LOG_START_MSG + Constant.COLON + Constant.SPACE + proxy);

        if (proxy) {
            System.setProperty("http.proxyHost", proxyHost);
            System.setProperty("http.proxyPort", String.valueOf(proxyPort));

            System.setProperty("https.proxyHost", proxyHost);
            System.setProperty("https.proxyPort", String.valueOf(proxyPort));
        }
    }

}
