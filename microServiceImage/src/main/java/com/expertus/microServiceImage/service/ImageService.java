package com.expertus.microServiceImage.service;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expertus.microServiceImage.bean.Image;
import com.expertus.microServiceImage.exception.ImageNotFoundException;
import com.expertus.microServiceImage.repository.ImageRepository;

@Service
public class ImageService implements IImageService{
	
	/** The image repository */
    @Autowired
    private ImageRepository imageRepository;
    
	@Override
	public List<Image> findAll() {
		return imageRepository.findAll();
	}

	@Override
	public Image findById(int pId) {
		return imageRepository.findById(pId).orElseThrow(() -> new ImageNotFoundException(pId));
	}
	
	@Override
	public Optional<List<Image>> findByIdProduct(int idProduct) {
		return imageRepository.findByIdProduct(idProduct);
	}
	
	@Override
	public Image save(Image pImage) throws URISyntaxException {
		return imageRepository.save(pImage);
	}
	
	@Override
	public void deleteById(int pId) {
		imageRepository.deleteById(pId);
	}

	@Override
	public Image update(Image pNewImage, int pId) throws URISyntaxException {
		Image lUpdatedImage = imageRepository.findById(pId).map(image -> {
			image.setUrl(pNewImage.getUrl());
			return imageRepository.save(image);
		}).orElseGet(() -> {
			pNewImage.setId(pId);
			return imageRepository.save(pNewImage);
		});

		return lUpdatedImage;
	}

}
