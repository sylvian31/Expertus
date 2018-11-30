package com.expertus.microServiceImage.service;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;

import com.expertus.microServiceImage.bean.Image;

public interface IImageService {

	public List<Image> findAll();
	
	public Image findById(int id);
	
	public Image save(Image image) throws URISyntaxException;
	
	public void deleteById(int id);

	public Image update(Image image, int id) throws URISyntaxException;

	public Optional<Image> findByIdProduct(int idProduct);
	
}
