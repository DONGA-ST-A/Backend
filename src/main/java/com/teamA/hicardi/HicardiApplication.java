package com.teamA.hicardi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@OpenAPIDefinition(servers = {@Server(url = "/", description = "https://dev-api.dongahicardi.site")})
@EnableJpaAuditing
@SpringBootApplication
public class HicardiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HicardiApplication.class, args);
	}

}
