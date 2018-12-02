package com.expertus.expertusprojet.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.expertus.expertusprojet.bean.Image;
import com.expertus.expertusprojet.bean.Product;
import com.expertus.expertusprojet.config.GlobalPropertiesPath;

@Service
public class ImageService implements IImageService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	/** The rest template */
	RestTemplate restTemplate = new RestTemplate();

	@Override
	public void add(Image pImage) {
		restTemplate.postForEntity(GlobalPropertiesPath.URL_IMAGE_MICRO_SERVICE_ADD, pImage, Image.class);
	}

	@Override
	public void update(Image pImage) {
		restTemplate.put(GlobalPropertiesPath.URL_IMAGE_MICRO_SERVICE_UPDATE + pImage.getId(), pImage);
	}

	@Override
	public void delete(Long pId) {
		restTemplate.delete(GlobalPropertiesPath.URL_IMAGE_MICRO_SERVICE_DELETE + pId);
	}

}
