package com.expertus.expertusprojet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.expertus.expertusprojet")
public class ExpertusprojetApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpertusprojetApplication.class, args);
	}
}
