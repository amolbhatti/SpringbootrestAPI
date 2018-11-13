package com.devglan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringbootexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootexampleApplication.class, args);
	}
}
