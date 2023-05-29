package com.mrflorez.gatewaycloud;

import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import reactor.netty.http.client.HttpClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayCloudApplication.class, args);
	}


}
