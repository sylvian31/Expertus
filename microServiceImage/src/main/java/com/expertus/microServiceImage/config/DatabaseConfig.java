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
				"https://banner2.kisspng.com/20180403/oie/kisspng-macbook-pro-laptop-macbook-family-macbook-5ac3add0c92cd0.959931101522773456824.jpg",
				1));
		imageRepository.save(new Image("https://banner2.kisspng.com/20180130/wze/kisspng-iphone-5s-iphone-4s-iphone-6-plus-iphone-5psd-5a7058507d3502.6192628515173120805129.jpg", 2));
		imageRepository.save(new Image(
				"https://banner2.kisspng.com/20180325/giw/kisspng-computer-keyboard-computer-mouse-laptop-microsoft-keyboard-5ab730327f4cf5.9072492715219548665214.jpg",
				3));
		imageRepository.save(new Image(
				"https://zdnet3.cbsistatic.com/hub/i/r/2016/11/21/fd5b0448-c08a-423c-88fd-78eca6bed603/thumbnail/770x433/5a5c11a7051bce9d1a17c8ec516af039/mpb-15-2016-header.jpg",
				1));
		return null;
	}
}
