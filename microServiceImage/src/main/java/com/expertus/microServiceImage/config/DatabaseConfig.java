package com.expertus.microServiceImage.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.expertus.microServiceImage.bean.Image;
import com.expertus.microServiceImage.repository.ImageRepository;

@Configuration
public class DatabaseConfig {

	@Bean
	CommandLineRunner initDatabase(ImageRepository imageRepository) {
		imageRepository.save(new Image(
				"https://www.naturephotographie.com/wp-content/uploads/2016/12/Back-From-The-Edge-Best-Of-2016.jpg",
				1));
		imageRepository.save(new Image("https://lemag.nikonclub.fr/wp-content/uploads/2017/07/08.jpg", 2));
		imageRepository.save(new Image(
				"https://s3.amazonaws.com/cdn.clearfacts.ca/wp-content/uploads/2017/07/montreal-ville-innovation-newtech-1.jpg",
				3));
		imageRepository.save(new Image(
				"https://s3.amazonaws.com/cdn.clearfacts.ca/wp-content/uploads/2017/07/montreal-ville-innovation-newtech-1.jpg",
				3));
		return null;
	}
}
