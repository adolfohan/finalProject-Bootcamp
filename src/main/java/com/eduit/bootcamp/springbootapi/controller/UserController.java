package com.eduit.bootcamp.springbootapi.controller;

import java.time.OffsetDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.eduit.bootcamp.springbootapi.api.UsersApiDelegate;
import com.eduit.bootcamp.springbootapi.model.EmptyResponseDTO;
import com.eduit.bootcamp.springbootapi.model.ResponseContainerResponseDTO;
import com.eduit.bootcamp.springbootapi.model.UserDTO;
import com.eduit.bootcamp.springbootapi.model.UserListDTO;
import com.eduit.bootcamp.springbootapi.model.UserRequestDTO;
import com.eduit.bootcamp.springbootapi.service.UserAdministrationService;

public class UserController extends BaseController implements UsersApiDelegate {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	private UserAdministrationService userAdministrationService;
	
	public UserController(UserAdministrationService theUserAdministrationService) {
		userAdministrationService = theUserAdministrationService;
	}

	public ResponseEntity<ResponseContainerResponseDTO> createUser(UserRequestDTO userDTO) {
		Long start = System.currentTimeMillis();
		ResponseContainerResponseDTO responseContainer = new ResponseContainerResponseDTO();
		try {
			UserDTO response = userAdministrationService.create(userDTO);
			responseContainer.data(response);
			responseContainer.setMeta(buildMeta(start));
			return ResponseEntity.status(HttpStatus.CREATED).body(responseContainer);
		} catch (Exception e) {
			LOGGER.error(String.format("An error occurred creating a user: \"%s\" ", userDTO), e);
			return buildErrorResponse(responseContainer, HttpStatus.BAD_REQUEST, e, "A1", start);
		}
	}
	
	public ResponseEntity<ResponseContainerResponseDTO> retrieveAllUsers() {
		Long start = System.currentTimeMillis();
		ResponseContainerResponseDTO responseContainer = new ResponseContainerResponseDTO();
		try {
			List<UserDTO> listUser = userAdministrationService.retrieveAll();
			UserListDTO response = new UserListDTO();
			response.setItems(listUser);
			responseContainer.data(response);
			responseContainer.setMeta(buildMeta(start));
			return ResponseEntity.status(HttpStatus.OK).body(responseContainer);
		} catch (Exception e) {
			LOGGER.error(String.format("An error occurred listing users"), e);
			return buildErrorResponse(responseContainer, HttpStatus.BAD_REQUEST, e, "A1", start);
		}
	}

	@Override
	public ResponseEntity<ResponseContainerResponseDTO> deleteUser(Long userId, UserDTO userDTO) {
		Long start = System.currentTimeMillis();
		ResponseContainerResponseDTO responseContainer = new ResponseContainerResponseDTO();
		try {
			userAdministrationService.delete(userId);
			EmptyResponseDTO response = new EmptyResponseDTO();
			response.setDate(OffsetDateTime.now());
			responseContainer.data(response);
			responseContainer.setMeta(buildMeta(start));
			return ResponseEntity.status(HttpStatus.OK).body(responseContainer);
		} catch (Exception e) {
			LOGGER.error(String.format("An error occurred listing uses"), e);
			return buildErrorResponse(responseContainer, HttpStatus.BAD_REQUEST, e, "A1", start);
		}
	}

	@Override
	public ResponseEntity<ResponseContainerResponseDTO> retrieveUser(Long userId) {
		Long start = System.currentTimeMillis();
		ResponseContainerResponseDTO responseContainer = new ResponseContainerResponseDTO();
		try {
			UserDTO user = userAdministrationService.retrieve(userId);
			responseContainer.data(user);
			responseContainer.setMeta(buildMeta(start));
			return ResponseEntity.status(HttpStatus.OK).body(responseContainer);
		} catch (Exception e) {
			LOGGER.error(String.format("An error occurred retrieving userId %d", userId), e);
			return buildErrorResponse(responseContainer, HttpStatus.BAD_REQUEST, e, "A1", start);
		}
	}


	@Override
	public ResponseEntity<ResponseContainerResponseDTO> updateUser(Long userId, UserDTO userDTO) {
		Long start = System.currentTimeMillis();
		ResponseContainerResponseDTO responseContainer = new ResponseContainerResponseDTO();
		if (userId != userDTO.getId()) {
			LOGGER.error(String.format("Product id %d and inner id %d does not match", userId, userDTO.getId()));
			return buildErrorResponse(responseContainer, HttpStatus.BAD_REQUEST, null, "A1", start);
		}
		try {
			UserDTO response = userAdministrationService.update(userDTO);
			responseContainer.data(response);
			responseContainer.setMeta(buildMeta(start));
			return ResponseEntity.status(HttpStatus.OK).body(responseContainer);
		} catch (Exception e) {
			LOGGER.error(String.format("An error occurred updating a user: \"%s\" ", userDTO), e);
			return buildErrorResponse(responseContainer, HttpStatus.BAD_REQUEST, e, "A1", start);
		}
	}
	
}
