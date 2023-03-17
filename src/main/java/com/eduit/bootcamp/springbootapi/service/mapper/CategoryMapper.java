package com.eduit.bootcamp.springbootapi.service.mapper;

import com.eduit.bootcamp.springbootapi.db.entity.CategoryEntity;
import com.eduit.bootcamp.springbootapi.model.CategoryDTO;
import com.eduit.bootcamp.springbootapi.model.CategoryRequestDTO;

public interface CategoryMapper {

	CategoryEntity map(final CategoryRequestDTO theCategory);
	
	CategoryEntity map(final CategoryDTO theCategory);
	
	CategoryDTO map(final CategoryEntity theCategory);
}
