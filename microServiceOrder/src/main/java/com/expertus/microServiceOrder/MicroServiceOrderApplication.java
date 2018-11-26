package com.expertus.microServiceOrder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.expertus.microServiceOrder")
@EnableJpaRepositories("com.expertus.microServiceOrder.repository")
@EnableEurekaClient
public class MicroServiceOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceOrderApplication.class, args);
	}
}
