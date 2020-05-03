package com.example.microservice.microapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class MicroappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroappApplication.class, args);
	}

}