package com.expertus.expertusprojet.service;

import com.expertus.expertusprojet.bean.Image;
import com.expertus.expertusprojet.bean.Product;

public interface IImageService {



	/**
	 * Add a image
	 * 
	 * @param image
	 */
	public void add(Image image);

	/**
	 * Update a image
	 * 
	 * @param image
	 */
	public void update(Image image);

	/**
	 * Delete a image by his id
	 * 
	 * @param id
	 */
	public void delete(Long id);
}
