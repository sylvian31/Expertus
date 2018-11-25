package com.expertus.microServiceImage.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expertus.microServiceImage.GlobalPropertiesPath;
import com.expertus.microServiceImage.bean.Image;
import com.expertus.microServiceImage.exception.ImageNotFoundException;
import com.expertus.microServiceImage.service.IImageService;

@RestController
public class ImageController {
	
    @Autowired
    private IImageService imageService;
    
    /* ---------------------------- Route ---------------------------- */
    
    /* -------------- Home -------------- */
    
	@GetMapping(value="${" + GlobalPropertiesPath.ROUTE_IMAGE_HOME_PATH + "}")
	public String showHome() {
	    return "Welcome to image api";
	}
	
	/* -------------- Get -------------- */ 

	@GetMapping(value="${" + GlobalPropertiesPath.ROUTE_IMAGE_ALL_PATH + "}")
    public List<Image> getImageList() {
        return imageService.findAll();
    }
	
//	@SuppressWarnings("el-syntax")
	@GetMapping(value="${" + GlobalPropertiesPath.ROUTE_IMAGE_ID_PATH + "}")
	public Image getImageById(@PathVariable int id) {
	    return imageService.findById(id).orElseThrow(() -> new ImageNotFoundException(id));
	}
	
	/* -------------- Post -------------- */ 
	
	@PostMapping(value="${" + GlobalPropertiesPath.ROUTE_IMAGE_ADD_PATH + "}")
	public void addImage(@RequestBody Image image) {
		imageService.save(image);
	}
	
	/* -------------- Put -------------- */ 
	
	@PutMapping(value="${" + GlobalPropertiesPath.ROUTE_IMAGE_PUT_PATH + "}")
	Image replaceImage(@RequestBody Image pNewImage, @PathVariable int id) {

		return imageService.findById(id)
			.map(image -> {
				image.setName(pNewImage.getName());
				image.setUrl(pNewImage.getUrl());
				return imageService.save(image);
			})
			.orElseGet(() -> {
				pNewImage.setId(id);
				return imageService.save(pNewImage);
			});
	}
	
	/* -------------- Delete -------------- */
	
	@DeleteMapping(value="${" + GlobalPropertiesPath.ROUTE_IMAGE_DELETE_PATH + "}")
	void deleteImage(@PathVariable int id) {
		imageService.deleteById(id);
	}
	
}
