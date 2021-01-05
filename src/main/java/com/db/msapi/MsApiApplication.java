package com.db.msapi;

import java.util.function.Predicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class MsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsApiApplication.class, args);
	}

	@Bean
	 public Docket api() {
	     return new Docket(DocumentationType.SWAGGER_2)
	         .select()
	         .apis(RequestHandlerSelectors.any())
	         .paths(PathSelectors.any())
	         .paths(Predicate.not(PathSelectors.regex("/error.*")))
	         .build();  
	 }
	

}
