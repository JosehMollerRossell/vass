package com.vass.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

//@EnableConfigServer
@SpringBootApplication
public class VassApplication {

	public static void main(String[] args) {
		SpringApplication.run(VassApplication.class, args);
	}

}
