package com.expertus.microServiceImage.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.expertus.microServiceImage.bean.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
	Optional<List<Image>> findByIdProduct(int idProduct);
}
