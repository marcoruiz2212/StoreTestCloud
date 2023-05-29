package com.mrflorez.eurekaservicesregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServicesRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServicesRegistryApplication.class, args);
	}

}
