package com.example.demoapp.main;

import com.example.demoapp.config.AppConfig;
import com.example.demoapp.controller.AdminController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackageClasses = {AppConfig.class, AdminController.class})
@EnableJpaRepositories("com.example.demoapp.repo")
@EntityScan(basePackages = "com.example.demoapp.model")
public class XsportApplication {

	public static void main(String[] args) {
		SpringApplication.run(XsportApplication.class, args);
	}
}
