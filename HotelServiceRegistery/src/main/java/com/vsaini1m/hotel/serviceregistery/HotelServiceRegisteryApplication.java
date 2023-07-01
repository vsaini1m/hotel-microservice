package com.vsaini1m.hotel.serviceregistery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HotelServiceRegisteryApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelServiceRegisteryApplication.class, args);
	}

}
