package com.example.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPayment9001Application {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment9001Application.class,args);
    }
}
