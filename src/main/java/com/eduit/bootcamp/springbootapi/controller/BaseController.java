package com.eduit.bootcamp.springbootapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.eduit.bootcamp.springbootapi.model.ErrorItemDTO;
import com.eduit.bootcamp.springbootapi.model.MetaInformationResponseDTO;
import com.eduit.bootcamp.springbootapi.model.ResponseContainerResponseDTO;

public abstract class BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

	protected ResponseEntity<ResponseContainerResponseDTO> buildErrorResponse(
			ResponseContainerResponseDTO responseContainer,  HttpStatus status, 
			Exception e, String code, Long startTime) {
		List<ErrorItemDTO> errorList = new ArrayList<>();
		ErrorItemDTO errorItem = new ErrorItemDTO();
		errorItem.setCode(code);
		errorItem.setDetail(e.getMessage());
		errorList.add(errorItem);
		responseContainer.errors(errorList);
		responseContainer.setMeta(buildMeta(startTime));
		return ResponseEntity.status(status).body(responseContainer);
	}
	
	protected MetaInformationResponseDTO buildMeta(final Long startTime) {
		MetaInformationResponseDTO meta = new MetaInformationResponseDTO();
		 Long endTime = System.currentTimeMillis();
		 Long elapsedTime = endTime - startTime;
		meta.setTime(elapsedTime);
		return meta;
	}
}
