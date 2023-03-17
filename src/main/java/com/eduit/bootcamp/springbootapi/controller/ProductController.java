package com.eduit.bootcamp.springbootapi.controller;

import java.time.OffsetDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.eduit.bootcamp.springbootapi.api.ProductsApiDelegate;
import com.eduit.bootcamp.springbootapi.model.CategoryDTO;
import com.eduit.bootcamp.springbootapi.model.CategoryListDTO;
import com.eduit.bootcamp.springbootapi.model.CategoryRequestDTO;
import com.eduit.bootcamp.springbootapi.model.EmptyResponseDTO;
import com.eduit.bootcamp.springbootapi.model.ProductDTO;
import com.eduit.bootcamp.springbootapi.model.ProductListDTO;
import com.eduit.bootcamp.springbootapi.model.ProductRequestDTO;
import com.eduit.bootcamp.springbootapi.model.ResponseContainerResponseDTO;
import com.eduit.bootcamp.springbootapi.service.CategoryAdministrationService;
import com.eduit.bootcamp.springbootapi.service.ProductAdministrationService;

public class ProductController extends BaseController implements ProductsApiDelegate {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	private ProductAdministrationService productAdministrationService;
	private CategoryAdministrationService categoryAdministrationService;
	
	public ProductController(CategoryAdministrationService theCategoryAdministrationService,
			ProductAdministrationService theProductAdministrationService) {
		productAdministrationService = theProductAdministrationService;
		categoryAdministrationService = theCategoryAdministrationService;
	}

	@Override
	public ResponseEntity<ResponseContainerResponseDTO> retrieveAllProducts() {
		Long start = System.currentTimeMillis();
		ResponseContainerResponseDTO responseContainer = new ResponseContainerResponseDTO();
		try {
			List<ProductDTO> product = productAdministrationService.retrieveAll();
			ProductListDTO response = new ProductListDTO();
			response.setItems(product);
			responseContainer.data(response);
			responseContainer.setMeta(buildMeta(start));
			return ResponseEntity.status(HttpStatus.OK).body(responseContainer);
		} catch (Exception e) {
			LOGGER.error(String.format("An error occurred retrieve all products"), e);
			return buildErrorResponse(responseContainer, HttpStatus.BAD_REQUEST, e, "A1", start);
		}
	}
	
	@Override
	public ResponseEntity<ResponseContainerResponseDTO> createProduct(ProductRequestDTO productDTO) {
		Long start = System.currentTimeMillis();
		ResponseContainerResponseDTO responseContainer = new ResponseContainerResponseDTO();
		try {
			ProductDTO response = productAdministrationService.create(productDTO);
			responseContainer.data(response);
			responseContainer.setMeta(buildMeta(start));
			return ResponseEntity.status(HttpStatus.CREATED).body(responseContainer);
		} catch (Exception e) {
			LOGGER.error(String.format("An error occurred creating a product: \"%s\" ", productDTO), e);
			return buildErrorResponse(responseContainer, HttpStatus.BAD_REQUEST, e, "A1", start);
		}
	}
	
	@Override
	public ResponseEntity<ResponseContainerResponseDTO> deleteProduct(Long productId) {
		Long start = System.currentTimeMillis();
		ResponseContainerResponseDTO responseContainer = new ResponseContainerResponseDTO();
		try {
			productAdministrationService.delete(productId);
			EmptyResponseDTO response = new EmptyResponseDTO();
			response.setDate(OffsetDateTime.now());
			responseContainer.data(response);
			responseContainer.setMeta(buildMeta(start));
			return ResponseEntity.status(HttpStatus.OK).body(responseContainer);
		} catch (Exception e) {
			LOGGER.error(String.format("An error occurred deleting a product: \"%s\" ", productId), e);
			return buildErrorResponse(responseContainer, HttpStatus.BAD_REQUEST, e, "A1", start);
		}
	}

	@Override
	public ResponseEntity<ResponseContainerResponseDTO> retrieveProduct(Long productId) {
		Long start = System.currentTimeMillis();
		ResponseContainerResponseDTO responseContainer = new ResponseContainerResponseDTO();
		try {
			ProductDTO response = productAdministrationService.retrieve(productId);
			responseContainer.data(response);
			responseContainer.setMeta(buildMeta(start));
			return ResponseEntity.status(HttpStatus.OK).body(responseContainer);
		} catch (Exception e) {
			LOGGER.error(String.format("An error occurred retrieving product: \"%d\" ", productId), e);
			return buildErrorResponse(responseContainer, HttpStatus.BAD_REQUEST, e, "A1", start);
		}
	}

	@Override
	public ResponseEntity<ResponseContainerResponseDTO> updateProduct(Long productId, ProductDTO productDTO) {
		Long start = System.currentTimeMillis();
		ResponseContainerResponseDTO responseContainer = new ResponseContainerResponseDTO();
		if (productId != productDTO.getId()) {
			LOGGER.error(String.format("Product id %d and inner id %d does not match", productId, productDTO.getId()));
			return buildErrorResponse(responseContainer, HttpStatus.BAD_REQUEST, null, "A1", start);
		}
		try {
			ProductDTO response = productAdministrationService.update(productDTO);
			responseContainer.data(response);
			responseContainer.setMeta(buildMeta(start));
			return ResponseEntity.status(HttpStatus.OK).body(responseContainer);
		} catch (Exception e) {
			LOGGER.error(String.format("An error occurred updating a product: \"%s\" ", productDTO), e);
			return buildErrorResponse(responseContainer, HttpStatus.BAD_REQUEST, e, "A1", start);
		}
	}

	@Override
	public ResponseEntity<ResponseContainerResponseDTO> createCategory(CategoryRequestDTO categoryRequestDTO) {
		Long start = System.currentTimeMillis();
		ResponseContainerResponseDTO responseContainer = new ResponseContainerResponseDTO();
		try {
			CategoryDTO response = categoryAdministrationService.create(categoryRequestDTO);
			responseContainer.data(response);
			responseContainer.setMeta(buildMeta(start));
			return ResponseEntity.status(HttpStatus.CREATED).body(responseContainer);
		} catch (Exception e) {
			LOGGER.error(String.format("An error occurred creating a category: \"%s\" ", categoryRequestDTO), e);
			return buildErrorResponse(responseContainer, HttpStatus.BAD_REQUEST, e, "A1", start);
		}
	}

	@Override
	public ResponseEntity<ResponseContainerResponseDTO> deleteCategory(Long categoryId) {
		Long start = System.currentTimeMillis();
		ResponseContainerResponseDTO responseContainer = new ResponseContainerResponseDTO();
		try {
			categoryAdministrationService.delete(categoryId);
			EmptyResponseDTO response = new EmptyResponseDTO();
			response.setDate(OffsetDateTime.now());
			responseContainer.data(response);
			responseContainer.setMeta(buildMeta(start));
			return ResponseEntity.status(HttpStatus.OK).body(responseContainer);
		} catch (Exception e) {
			LOGGER.error(String.format("An error occurred deleting a category: \"%s\" ", categoryId), e);
			return buildErrorResponse(responseContainer, HttpStatus.BAD_REQUEST, e, "A1", start);
		}
	}

	@Override
	public ResponseEntity<ResponseContainerResponseDTO> retrieveAllCategory() {
		Long start = System.currentTimeMillis();
		ResponseContainerResponseDTO responseContainer = new ResponseContainerResponseDTO();
		try {
			List<CategoryDTO> categories = categoryAdministrationService.retrieveAll();
			CategoryListDTO response = new CategoryListDTO();
			response.setItems(categories);
			responseContainer.data(response);
			responseContainer.setMeta(buildMeta(start));
			return ResponseEntity.status(HttpStatus.CREATED).body(responseContainer);
		} catch (Exception e) {
			LOGGER.error(String.format("An error occurred retrieve all categories"), e);
			return buildErrorResponse(responseContainer, HttpStatus.BAD_REQUEST, e, "A1", start);
		}
	}

	@Override
	public ResponseEntity<ResponseContainerResponseDTO> retrieveCategory(Long categoryId) {
		Long start = System.currentTimeMillis();
		ResponseContainerResponseDTO responseContainer = new ResponseContainerResponseDTO();
		try {
			CategoryDTO response = categoryAdministrationService.retrieve(categoryId);
			responseContainer.data(response);
			responseContainer.setMeta(buildMeta(start));
			return ResponseEntity.status(HttpStatus.OK).body(responseContainer);
		} catch (Exception e) {
			LOGGER.error(String.format("An error occurred retrieving the category: \"%d\" ", categoryId), e);
			return buildErrorResponse(responseContainer, HttpStatus.BAD_REQUEST, e, "A1", start);
		}
	}

	@Override
	public ResponseEntity<ResponseContainerResponseDTO> updateCategory(Long categoryId, CategoryDTO categoryDTO) {
		Long start = System.currentTimeMillis();
		ResponseContainerResponseDTO responseContainer = new ResponseContainerResponseDTO();
		if (categoryId != categoryDTO.getId()) {
			LOGGER.error(String.format("Product id %d and inner id %d does not match", categoryId, 
					categoryDTO.getId()));
			return buildErrorResponse(responseContainer, HttpStatus.BAD_REQUEST, null, "A1", start);
		}
		try {
			CategoryDTO response = categoryAdministrationService.update(categoryDTO);
			responseContainer.data(response);
			responseContainer.setMeta(buildMeta(start));
			return ResponseEntity.status(HttpStatus.OK).body(responseContainer);
		} catch (Exception e) {
			LOGGER.error(String.format("An error occurred updating a product: \"%s\" ", categoryDTO), e);
			return buildErrorResponse(responseContainer, HttpStatus.BAD_REQUEST, e, "A1", start);
		}
	}
	
}
