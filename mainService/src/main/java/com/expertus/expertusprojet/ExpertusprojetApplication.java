package com.expertus.expertusprojet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.expertus.expertusprojet")
@EnableDiscoveryClient
@EnableEurekaClient
public class ExpertusprojetApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ExpertusprojetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
