package com.sample.dl.context;

import com.sample.dl.controller.*;
import com.sample.dl.filter.AppFilter;
import com.sample.dl.service.ExceptionService;
import org.glassfish.jersey.server.ResourceConfig;
import org.reflections.Reflections;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.ws.rs.Path;


@Configuration
public class AppConfiguration extends ResourceConfig {
	public AppConfiguration() {
	}

	// Also lay on both methods
	@PostConstruct
	public void setUp() {
		register(BaseController.class);
		register(BikeController.class);
		register(BookController.class);
		register(CarController.class);
		register(UserController.class);
		register(AppFilter.class);
		register(ExceptionService.class);
	}
}
