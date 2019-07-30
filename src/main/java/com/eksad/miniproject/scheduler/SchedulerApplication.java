package com.eksad.miniproject.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class SchedulerApplication {

	public static void main(String[] args) {
		
//		SpringApplication.run(SchedulerApplication.class, args);
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aplicationContext.xml");
	}
	
}
