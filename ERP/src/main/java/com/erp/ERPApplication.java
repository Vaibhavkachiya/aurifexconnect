package com.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ERPApplication {
	public static void main(String[] args) {
		SpringApplication.run(ERPApplication.class, args);
	}
}
