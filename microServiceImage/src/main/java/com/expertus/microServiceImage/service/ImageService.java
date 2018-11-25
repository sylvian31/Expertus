package com.expertus.microServiceImage.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.expertus.microServiceImage.bean.Image;
import com.expertus.microServiceImage.repository.ImageRepository;

@Service
public class ImageService implements IImageService{
	
    @Autowired
    private ImageRepository repository;
    
	@Override
	public List<Image> findAll() {
		return (List<Image>) repository.findAll();
	}

	@Override
	public Optional<Image> findById(int pId) {
		return (Optional<Image>) repository.findById(pId);
	}

	@Override
	public void deleteById(int pId) {
		repository.deleteById(pId);
		
	}

	@Override
	public Image save(Image pImage) {
		return repository.save(pImage);
	}

}
