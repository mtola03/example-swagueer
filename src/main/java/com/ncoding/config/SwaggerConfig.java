package com.ncoding.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;

import springfox.documentation.service.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	 @Bean
	    public Docket api(){
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.any())
	                .paths(PathSelectors.any())
	                .build()
	                .securitySchemes(securitySchemes())
	                .pathMapping("/")
	                .apiInfo(metaData());
	    }

	    private ApiInfo metaData(){
	        Contact contact = new Contact("Manuel jesus", "",
	                "jesus.developer.3000@gmail.com");

	        return new ApiInfo(
	                "BACKEND BASE API",
	                "API: EndPoints para la App",
	                "1.0",
	                "Terms of Service",
	                contact,
	                "Manuel Jesus tola - Copyright 2021",
	                "",
	                new ArrayList<>()
	                );
	    }

	    private static ArrayList<? extends SecurityScheme> securitySchemes() {

	        return Lists.newArrayList(new ApiKey("Bearer", "Authorization", "header"));
	    }
}
