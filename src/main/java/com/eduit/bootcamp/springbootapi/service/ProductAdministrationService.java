package com.eduit.bootcamp.springbootapi.service;

import com.eduit.bootcamp.springbootapi.model.ProductDTO;
import com.eduit.bootcamp.springbootapi.model.ProductRequestDTO;

public interface ProductAdministrationService 
	extends CrudAdministrationService<ProductDTO, ProductRequestDTO, Long> {

}
