package com.expertus.microServiceImage.service;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;

import com.expertus.microServiceImage.bean.Image;

public interface IImageService {

	public Resources<Resource<Image>> findAll();
	
	public Resource<Image> findById(int id);
	
	public ResponseEntity<?> save(Image image) throws URISyntaxException;
	
	public ResponseEntity<?> deleteById(int id);

	public ResponseEntity<?> update(Image image, int id) throws URISyntaxException;
	
}
