package com.eduit.bootcamp.springbootapi;

import org.openapitools.configuration.SpringDocConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.eduit.bootcamp.springbootapi.service.UserInitializationService;

@SpringBootApplication
@ComponentScan
@Import({SpringDocConfiguration.class})
public class SpringbootApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringbootApiApplication.class, args);
	}
	
	@Autowired
	private ApplicationContext context;

	@Override
	public void run(String... args) throws Exception {
		UserInitializationService userInitService = context.getBean(UserInitializationService.class);
		userInitService.createDefaultAdminUser();
	}

}
