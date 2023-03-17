package com.eduit.bootcamp.springbootapi.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eduit.bootcamp.springbootapi.db.entity.ProductEntity;
import com.eduit.bootcamp.springbootapi.db.repository.ProductRepository;
import com.eduit.bootcamp.springbootapi.model.ProductDTO;
import com.eduit.bootcamp.springbootapi.model.ProductRequestDTO;
import com.eduit.bootcamp.springbootapi.service.mapper.ProductMapper;

public class ProductAdministrationServiceImpl implements ProductAdministrationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductAdministrationServiceImpl.class);
	
	private ProductRepository productRepository;
	
	private ProductMapper productMapper;
	
	public ProductAdministrationServiceImpl(final ProductMapper theProductMapper, 
			final ProductRepository theProductRepository) {
		productRepository = theProductRepository;
		productMapper = theProductMapper;
	}

	@Override
	public List<ProductDTO> retrieveAll() throws RuntimeException {
		LOGGER.trace(String.format("Listing all products"));
		Iterable<ProductEntity> products = productRepository.findAll();
		Iterator<ProductEntity> iter = products.iterator();
		List<ProductDTO> response = new ArrayList<>();
		while (iter.hasNext()) {
			response.add(productMapper.map(iter.next()));
		}
		return response;
	}

	@Override
	public ProductDTO retrieve(Long id) throws RuntimeException {
		Optional<ProductEntity> opProd = productRepository.findById(id);
		if (opProd.isEmpty()) {
			throw new RuntimeException(String.format("The product could not be found under id %d", id));
		}
		return productMapper.map(opProd.get());
	}

	@Override
	public ProductDTO create(ProductRequestDTO element) throws RuntimeException {
		ProductEntity product =  productMapper.map(element);
		productRepository.save(product);
		return productMapper.map(product);
	}

	@Override
	public ProductDTO update(ProductDTO element) throws RuntimeException {
		ProductEntity product =  productMapper.map(element);
		productRepository.save(product);
		return productMapper.map(product);
	}

	@Override
	public void delete(Long id) throws RuntimeException {
		productRepository.deleteById(id);
	}

}
