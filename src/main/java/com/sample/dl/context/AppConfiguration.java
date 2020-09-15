package com.sample.dl.context;

import com.sample.dl.controller.BookController;
import com.sample.dl.service.ExceptionService;
import org.glassfish.jersey.server.ResourceConfig;
import org.reflections.Reflections;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.ws.rs.Path;


@Configuration
public class AppConfiguration extends ResourceConfig {
	public AppConfiguration() {
//		packages("com.sample.dl.controller");
//		register(ExceptionService.class);
		scan("com.sample.dl.controller");
	}

	// Also lay on both methods
	@PostConstruct
	public void setUp() {
//		packages("com.sample.dl.controller");
		register(ExceptionService.class);
	}

	public void scan(String... packages) {
		for (String pack : packages) {
			Reflections reflections = new Reflections(pack);
			reflections.getTypesAnnotatedWith(Path.class, true)
					   .parallelStream()
					   .forEach((clazz) -> {
//						   logger.info("New resource registered: " + clazz.getName());
						   register(clazz);
					   });
		}
	}
}
