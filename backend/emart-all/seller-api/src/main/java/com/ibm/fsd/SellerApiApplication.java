package com.ibm.fsd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.ibm.fsd" })
@EnableDiscoveryClient
public class SellerApiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SellerApiApplication.class, args);
	}

}
