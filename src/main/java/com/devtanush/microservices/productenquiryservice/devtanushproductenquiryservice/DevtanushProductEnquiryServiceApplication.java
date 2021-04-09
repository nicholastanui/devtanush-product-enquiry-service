package com.devtanush.microservices.productenquiryservice.devtanushproductenquiryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.devtanush.microservices.productenquiryservice.devtanushproductenquiryservice")
public class DevtanushProductEnquiryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevtanushProductEnquiryServiceApplication.class, args);
    }

}
