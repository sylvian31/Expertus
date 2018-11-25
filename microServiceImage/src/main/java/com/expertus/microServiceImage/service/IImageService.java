package com.expertus.microServiceImage.service;

import java.util.List;
import java.util.Optional;
import com.expertus.microServiceImage.bean.Image;

public interface IImageService {

	public List<Image> findAll();
	
	public Optional<Image> findById(int id);
	
	public void deleteById(int id);

	public Image save(Image image);
	
}
