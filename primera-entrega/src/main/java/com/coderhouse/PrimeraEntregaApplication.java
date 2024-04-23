package com.coderhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.coderhouser.repositorios")

public class PrimeraEntregaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeraEntregaApplication.class, args);
	}

}
