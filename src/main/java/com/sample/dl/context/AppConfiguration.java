package com.sample.dl.context;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import com.sample.dl.controller.BookController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;


@Configuration
@ApplicationPath("api")
public class AppConfiguration extends ResourceConfig {
	public AppConfiguration() {
		
	}
	
	@PostConstruct
	public void setUp() {
		register(BookController.class);
		register(ExceptionBuilder.class);
	}
}
