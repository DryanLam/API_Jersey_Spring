package com.sample.dl.context;

import com.sample.dl.controller.BookController;
import com.sample.dl.service.ExceptionService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;


@Configuration
public class AppConfiguration extends ResourceConfig {
	public AppConfiguration() {
//		packages("com.sample.dl.controller");
//		register(ExceptionService.class);
	}

	// Also lay on both methods
	@PostConstruct
	public void setUp() {
		packages("com.sample.dl.controller");
		register(ExceptionService.class);
	}
}
