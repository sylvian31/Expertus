package com.expertus.expertusprojet.service;

import com.expertus.expertusprojet.bean.Image;

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
