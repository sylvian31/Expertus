package com.expertus.microServiceImage.service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.expertus.microServiceImage.assembler.ImageResourceAssembler;
import com.expertus.microServiceImage.bean.Image;
import com.expertus.microServiceImage.controller.ImageController;
import com.expertus.microServiceImage.exception.ImageNotFoundException;
import com.expertus.microServiceImage.repository.ImageRepository;

@Service
public class ImageService implements IImageService{
	
	/** The image repository */
    @Autowired
    private ImageRepository imageRepository;
    
    /** The Image resource assembler */
    @Autowired
    private ImageResourceAssembler imageResourceAssembler;
    

	@Override
	public Resources<Resource<Image>> findAll() {
		List<Resource<Image>> images = imageRepository.findAll().stream()
				.map(imageResourceAssembler::toResource)
				.collect(Collectors.toList());

			return new Resources<>(images,
				linkTo(methodOn(ImageController.class).all()).withSelfRel());
	}

	@Override
	public Resource<Image> findById(int pId) {
		Image image = imageRepository.findById(pId).orElseThrow(() -> new ImageNotFoundException(pId));

		return imageResourceAssembler.toResource(image);
	}
	
	@Override
	public ResponseEntity<?> save(Image pImage) throws URISyntaxException {
		Resource<Image> resource = imageResourceAssembler.toResource(imageRepository.save(pImage));

		return ResponseEntity.created(new URI(resource.getId().expand().getHref())).body(resource);
	}

	@Override
	public ResponseEntity<?> deleteById(int pId) {
		imageRepository.deleteById(pId);
		
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<?> update(Image pNewImage, int pId) throws URISyntaxException {
		Image updatedImage = imageRepository.findById(pId).map(image -> {
			image.setName(pNewImage.getName());
			image.setUrl(pNewImage.getUrl());
			return imageRepository.save(image);
		}).orElseGet(() -> {
			pNewImage.setId(pId);
			return imageRepository.save(pNewImage);
		});

		Resource<Image> resource = imageResourceAssembler.toResource(updatedImage);

		return ResponseEntity.created(new URI(resource.getId().expand().getHref())).body(resource);
	}



}
