package com.example.javademo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.javademo.serviceImplementation.EmployeeServiceImpl;

@Configuration
public class ServiceConfig {

    @Bean
    EmployeeServiceImpl myService() {
        return new EmployeeServiceImpl();
    }
}
