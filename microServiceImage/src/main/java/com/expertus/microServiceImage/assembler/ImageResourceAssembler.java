package com.expertus.microServiceImage.assembler;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.expertus.microServiceImage.bean.Image;
import com.expertus.microServiceImage.controller.ImageController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class ImageResourceAssembler implements ResourceAssembler<Image, Resource<Image>>{

	@Override
	public Resource<Image> toResource(Image image) {
		return new Resource<>(image,
				linkTo(methodOn(ImageController.class).getImageById(image.getId())).withSelfRel(),
				linkTo(methodOn(ImageController.class).getAllImageList()).withRel("images"));
	}

}
