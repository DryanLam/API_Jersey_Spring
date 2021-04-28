package com.sample.dl.context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude={MongoAutoConfiguration.class})
@ComponentScan(basePackages = {"com.sample.dl"})
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
