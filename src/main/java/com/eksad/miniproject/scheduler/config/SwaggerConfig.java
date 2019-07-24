package com.eksad.miniproject.scheduler.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

	@Bean
	public Docket eksadAPI() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.eksad.miniproject.scheduler"))
				.paths(regex("/miniprojectapi.*"))
				.build()
				.tags(
						new Tag("Scheduler", "Scheduler managemen API"))
				.apiInfo(metaInfo()
				);
	}

	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Mini Project - Scheduler- REST API",
				"Rest API Collection for Mini Project -Scheduler-", 
				"1.0.0", 
				"http://eksad.com",
				new Contact("Diah Ayu Anjarwati", "http://www.ciaoanjar.blogspot.com", "diahayu.a@outlook.com"),
				"Diah 2.0",
				"http://www.ciaoanjar.blogspot.com",
				Collections.emptyList());

		return apiInfo;
	}
}
