package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.WarhammerCharacter;
import com.example.demo.repository.WarhammerCharacterRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("Hello, Spring Boot!");
		SpringApplication.run(DemoApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner run(WarhammerCharacterRepository repository) {
	// 	return args -> {
	// 		System.out.println("Hello, Spring Boot!");
	// 		repository.save(new WarhammerCharacter("Karak Eight Peaks", "Dwarfs"));
	// 		repository.save(new WarhammerCharacter("Altdorf", "Empire"));
	// 		repository.save(new WarhammerCharacter("Lothern", "High Elves"));
	// 	};
	// }
}
