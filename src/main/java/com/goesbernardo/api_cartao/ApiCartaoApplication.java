package com.goesbernardo.api_cartao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.goesbernardo.api_cartao")
public class ApiCartaoApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApiCartaoApplication.class, args);
	}



	}

