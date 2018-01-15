package com.gramcha.chessservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.gramcha.controller","com.gramcha.service","com.gramcha.entities"})
public class ChessServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChessServiceApplication.class, args);
	}
}
