package com.example.transactionsproject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@ComponentScan(basePackages = {"com"})
public class TransactionsProjectApplication {

    @Bean
    public ModelMapper modelMapper() { //since ModelMapper class is just a java class, I have to annotate with @Configuration and @Bean the method, in order to avoid error
        return new ModelMapper();     //'AccountMapper required a bean of type 'org.modelmapper.ModelMapper' that could not be found'
    }

    public static void main(String[] args) {
        SpringApplication.run(TransactionsProjectApplication.class, args);
    }

}
