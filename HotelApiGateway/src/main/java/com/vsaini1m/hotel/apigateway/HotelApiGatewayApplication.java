package com.vsaini1m.hotel.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HotelApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelApiGatewayApplication.class, args);
	}

}
