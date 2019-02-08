package com.qa.saul.josh.springboot.vetProject.vetProjectApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class VetProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(VetProjectApplication.class, args);
	}
}

