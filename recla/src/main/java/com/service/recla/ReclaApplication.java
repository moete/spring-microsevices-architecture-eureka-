package com.service.recla;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class ReclaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReclaApplication.class, args);
	}
	@Bean 
	ApplicationRunner init(ReclaRepository repository) {
		return args ->{
			
				Stream.of("1","Tizii","test reclamation","i just want to test").forEach(username ->{
					repository.save(new Recla());
				});
			repository.findAll().forEach(System.out::println);
		};
	}

}
