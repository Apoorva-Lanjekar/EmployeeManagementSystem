package com.example.javademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.javademo.controllers.EmployeeController;

@SpringBootApplication
@ComponentScan()
public class ManagementSystemJavaApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(ManagementSystemJavaApplication.class, args);
		
	}

}
