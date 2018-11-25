package com.expertus.microServiceImage.controller;

import java.net.URISyntaxException;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.expertus.microServiceImage.GlobalPropertiesPath;
import com.expertus.microServiceImage.bean.Image;
import com.expertus.microServiceImage.service.IImageService;

@RestController
public class ImageController {

	private final IImageService imageService;


	public ImageController(IImageService pImageService) {
		super();
		this.imageService = pImageService;
	}

	/* ---------------------------- Route ---------------------------- */

	/* -------------- Home -------------- */

	/**
	 * Home show
	 * 
	 * @return service name
	 */
	@GetMapping(value = "${" + GlobalPropertiesPath.ROUTE_IMAGE_HOME_PATH
			+ "}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String showHome() {
		return "Welcome to image api";
	}

	/* -------------- Get -------------- */

	/**
	 * Get all images
	 * 
	 * @return list images
	 */
	@GetMapping(value = "${" + GlobalPropertiesPath.ROUTE_IMAGE_ALL_PATH
			+ "}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resources<Resource<Image>> getAllImageList() {
		return imageService.findAll();
	}

	/**
	 * Get a image by id
	 * 
	 * @param id
	 * @return one image
	 */
	@GetMapping(value = "${" + GlobalPropertiesPath.ROUTE_IMAGE_ID_PATH
			+ "}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<Image> getImageById(@PathVariable int id) {
		return imageService.findById(id);
	}

	/* -------------- Post -------------- */

	/**
	 * Add a image
	 * 
	 * @param image
	 * @throws URISyntaxException
	 */
	@PostMapping(value = "${" + GlobalPropertiesPath.ROUTE_IMAGE_ADD_PATH
			+ "}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addImage(@RequestBody Image image) throws URISyntaxException {
		return imageService.save(image);
	}

	/* -------------- Put -------------- */

	/**
	 * Update a image
	 * 
	 * @param newImage
	 * @param id
	 * @return the update image
	 */
	@PutMapping(value = "${" + GlobalPropertiesPath.ROUTE_IMAGE_PUT_PATH
			+ "}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> replaceImage(@RequestBody Image newImage, @PathVariable int id) throws URISyntaxException {
		return imageService.update(newImage, id);
	}

	/* -------------- Delete -------------- */

	/**
	 * Delete a image by id
	 * 
	 * @param id
	 */
	@DeleteMapping(value = "${" + GlobalPropertiesPath.ROUTE_IMAGE_DELETE_PATH
			+ "}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteImage(@PathVariable int id) {

		return imageService.deleteById(id);
	}

}
