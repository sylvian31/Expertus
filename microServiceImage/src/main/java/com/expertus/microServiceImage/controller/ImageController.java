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

	/** The image service */
	private final IImageService imageService;

	/**
	 * Constructor
	 * 
	 * @param pImageService
	 */
	public ImageController(IImageService pImageService) {
		super();
		this.imageService = pImageService;
	}

	/* -------------- Get -------------- */

	/**
	 * Show home
	 * 
	 * @return micro service name
	 */
	@GetMapping(value = "${" + GlobalPropertiesPath.ROUTE_IMAGE_HOME_PATH
			+ "}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String showHome() {
		return "Welcome to image api";
	}

	/**
	 * Get all Images
	 * 
	 * @return list Image
	 */
	@GetMapping(value = "${" + GlobalPropertiesPath.ROUTE_IMAGE_ALL_PATH
			+ "}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resources<Resource<Image>> all() {
		return imageService.findAll();
	}

	/**
	 * Get a Image by id
	 * 
	 * @param id
	 * @return a Image
	 */
	@GetMapping(value = "${" + GlobalPropertiesPath.ROUTE_IMAGE_ID_PATH
			+ "}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<Image> one(@PathVariable int id) {
		return imageService.findById(id);
	}

	/* -------------- Post -------------- */

	/**
	 * Add a new Image
	 * 
	 * @param Image
	 * @return Image
	 * @throws URISyntaxException
	 */
	@PostMapping(value = "${" + GlobalPropertiesPath.ROUTE_IMAGE_ADD_PATH
			+ "}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> newImage(@RequestBody Image image) throws URISyntaxException {
		return imageService.save(image);
	}

	/* -------------- Put -------------- */

	/**
	 * Update a Image
	 * 
	 * @param newImage
	 * @param id
	 * @return the update Image
	 */
	@PutMapping(value = "${" + GlobalPropertiesPath.ROUTE_IMAGE_PUT_PATH
			+ "}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> replaceImage(@RequestBody Image newImage, @PathVariable int id) throws URISyntaxException {
		return imageService.update(newImage, id);
	}

	/* -------------- Delete -------------- */

/**
 * Delete a Image
 * @param id
 * @return ResponseEntity without content
 */
	@DeleteMapping(value = "${" + GlobalPropertiesPath.ROUTE_IMAGE_DELETE_PATH
			+ "}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteImage(@PathVariable int id) {
		return imageService.deleteById(id);
	}

}
