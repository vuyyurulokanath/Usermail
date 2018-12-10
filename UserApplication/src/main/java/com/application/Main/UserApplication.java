package com.application.Main;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.application"})
@EntityScan("com.application.Entity")
@EnableJpaRepositories("com.application.Repository")
public class UserApplication {
	public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(UserApplication.class, args);
  	}
}



	
	

