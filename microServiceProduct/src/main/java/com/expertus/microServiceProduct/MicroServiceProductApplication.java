package com.expertus.microServiceProduct;

import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.expertus.microServiceProduct.service.IProductService;

@SpringBootApplication
@ComponentScan("com.expertus.microServiceProduct")
@EnableJpaRepositories("com.expertus.microServiceProduct.repository")
@EnableEurekaClient
@EnableAsync
public class MicroServiceProductApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	IProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceProductApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		logger.info("All users 1 -> {}", productService.findAll());	

	}

	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("ImageService-");
		executor.initialize();
		return executor;
	}

}
