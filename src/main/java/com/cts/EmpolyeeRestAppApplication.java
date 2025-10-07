package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.*")
public class EmpolyeeRestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpolyeeRestAppApplication.class, args);
	}

}
