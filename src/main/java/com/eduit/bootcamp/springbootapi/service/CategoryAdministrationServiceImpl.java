package com.eduit.bootcamp.springbootapi.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eduit.bootcamp.springbootapi.db.entity.CategoryEntity;
import com.eduit.bootcamp.springbootapi.db.entity.ProductEntity;
import com.eduit.bootcamp.springbootapi.db.repository.CategoryRepository;
import com.eduit.bootcamp.springbootapi.db.repository.ProductRepository;
import com.eduit.bootcamp.springbootapi.model.CategoryDTO;
import com.eduit.bootcamp.springbootapi.model.CategoryRequestDTO;
import com.eduit.bootcamp.springbootapi.model.ProductDTO;
import com.eduit.bootcamp.springbootapi.service.mapper.CategoryMapper;
import com.eduit.bootcamp.springbootapi.service.mapper.ProductMapper;

public class CategoryAdministrationServiceImpl implements CategoryAdministrationService {

	
private static final Logger LOGGER = LoggerFactory.getLogger(ProductAdministrationServiceImpl.class);
	
	private CategoryRepository categoryRepository;
	
	private CategoryMapper mapper;
	
	public CategoryAdministrationServiceImpl(final CategoryMapper theCategoryMapper, 
			final CategoryRepository theCategoryRepository) {
		categoryRepository = theCategoryRepository;
		mapper = theCategoryMapper;
	}

	@Override
	public List<CategoryDTO> retrieveAll() throws RuntimeException {
		LOGGER.trace(String.format("Listing all categories"));
		Iterable<CategoryEntity> products = categoryRepository.findAll();
		Iterator<CategoryEntity> iter = products.iterator();
		List<CategoryDTO> response = new ArrayList<>();
		while (iter.hasNext()) {
			response.add(mapper.map(iter.next()));
		}
		return response;
	}

	@Override
	public CategoryDTO retrieve(Long id) throws RuntimeException {
		return null;
	}

	@Override
	public CategoryDTO create(CategoryRequestDTO element) throws RuntimeException {
		return null;
	}

	@Override
	public CategoryDTO update(CategoryDTO element) throws RuntimeException {
		return null;
	}

	@Override
	public void delete(Long id) throws RuntimeException {

	}

	@Override
	public List<CategoryDTO> retrieveChildren(Long id) throws RuntimeException {
		return null;
	}

}
