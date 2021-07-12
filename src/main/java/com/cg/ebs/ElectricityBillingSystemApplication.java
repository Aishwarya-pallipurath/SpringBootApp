package com.cg.ebs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElectricityBillingSystemApplication {

	private static final Logger LOGGER = LogManager.getLogger(ElectricityBillingSystemApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ElectricityBillingSystemApplication.class, args);
		LOGGER.info("Application started at port 8081");

	}

}
