package com.eduit.bootcamp.springbootapi.db.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eduit.bootcamp.springbootapi.db.entity.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

	List<ProductEntity> findByCategory(ProductEntity parentCategory);
	
}
