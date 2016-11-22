package com.customer.zipcodeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
 
@SpringBootApplication
@ComponentScan(basePackages = "com.customer.zipcodeservice")
public class ZipCodeServiceApplication {
     
    public static void main(String[] args) {
       SpringApplication.run(ZipCodeServiceApplication.class, args);
    }
     
    @Bean
    public RestTemplate geRestTemplate() {
        return new RestTemplate();
    }
}