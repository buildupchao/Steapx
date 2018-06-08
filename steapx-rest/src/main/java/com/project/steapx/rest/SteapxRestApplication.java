package com.project.steapx.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.project.steapx.service", "com.project.steapx.rest" })
public class SteapxRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SteapxRestApplication.class, args);
	}
}
