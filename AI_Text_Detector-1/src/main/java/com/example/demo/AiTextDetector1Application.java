package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@ComponentScan(basePackages= {"com.example.demo.config","com.example.demo.controller","com.example.demo.service",
		"com.example.demo.repository","com.example.demo.entity"})
public class AiTextDetector1Application {

	public static void main(String[] args) {
		SpringApplication.run(AiTextDetector1Application.class, args);
	}

}
