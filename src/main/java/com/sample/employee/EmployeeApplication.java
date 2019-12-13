package com.sample.employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EmployeeApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
		logger.info("Employee Application started successfully");
	}

}
