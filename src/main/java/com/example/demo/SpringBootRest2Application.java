package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.bean.AppProperties;

@SpringBootApplication(scanBasePackages = {"com.example"})
@EnableConfigurationProperties(AppProperties.class)

public class SpringBootRest2Application {
	 
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRest2Application.class, args);
	}

}

