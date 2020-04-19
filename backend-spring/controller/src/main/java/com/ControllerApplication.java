package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.spring.FreemarkerConfig;
import com.spring.WebConfig;
import com.swagger.SwaggerConfig;

@PropertySource("classpath:application.properties")
@EntityScan(basePackages = "com.entities")
@ComponentScan({ "com.repositories" })
@ComponentScan({ "com.services" })
@Configuration
@Import({
	FreemarkerConfig.class,
	WebConfig.class,
	SwaggerConfig.class
})
@SpringBootApplication
public class ControllerApplication{
	public static void main(String[] args) {
		SpringApplication.run(ControllerApplication.class, args);
	}	
}
