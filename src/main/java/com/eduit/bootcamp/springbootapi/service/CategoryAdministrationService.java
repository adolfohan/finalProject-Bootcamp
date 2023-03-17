package com.eduit.bootcamp.springbootapi.service;

import java.util.List;

import com.eduit.bootcamp.springbootapi.model.CategoryDTO;
import com.eduit.bootcamp.springbootapi.model.CategoryRequestDTO;

public interface CategoryAdministrationService 
	extends CrudAdministrationService<CategoryDTO, CategoryRequestDTO, Long>{

	List<CategoryDTO> retrieveChildren(final Long id) throws RuntimeException;
}
