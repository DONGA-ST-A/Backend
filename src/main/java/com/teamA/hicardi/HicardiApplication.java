package com.teamA.hicardi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HicardiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HicardiApplication.class, args);
	}

}
