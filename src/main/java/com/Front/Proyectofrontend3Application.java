package com.Front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Proyectofrontend3Application {

	public static void main(String[] args) {
		SpringApplication.run(Proyectofrontend3Application.class, args);
	}

}
