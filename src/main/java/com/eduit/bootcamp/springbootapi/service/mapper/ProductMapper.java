package com.eduit.bootcamp.springbootapi.service.mapper;

import com.eduit.bootcamp.springbootapi.db.entity.ProductEntity;
import com.eduit.bootcamp.springbootapi.model.ProductDTO;
import com.eduit.bootcamp.springbootapi.model.ProductRequestDTO;

public interface ProductMapper {

	ProductEntity map(final ProductRequestDTO theProduct);
	
	ProductEntity map(final ProductDTO theProduct);
	
	ProductDTO map(final ProductEntity theProduct);
}
