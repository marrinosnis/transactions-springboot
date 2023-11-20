package com.example.transactionsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com"})
public class TransactionsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionsProjectApplication.class, args);
	}

}
