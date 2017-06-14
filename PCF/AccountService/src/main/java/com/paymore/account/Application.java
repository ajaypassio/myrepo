/**
 * 
 */
package com.paymore.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author AK00487304
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
public class Application {

	/** The log. */
    private static Logger    log = LoggerFactory.getLogger(Application.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		    log.info("Account Service is starting now");
			SpringApplication.run(Application.class, args);
			/*@SuppressWarnings("resource")
			ApplicationContext context=new FileSystemXmlApplicationContext();
			System.out.print(context.getBeanDefinitionCount());*/
			
	}
}
