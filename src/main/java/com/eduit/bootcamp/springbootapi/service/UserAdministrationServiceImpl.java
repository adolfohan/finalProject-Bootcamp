package com.eduit.bootcamp.springbootapi.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eduit.bootcamp.springbootapi.db.entity.ProductEntity;
import com.eduit.bootcamp.springbootapi.db.entity.UserEntity;
import com.eduit.bootcamp.springbootapi.db.repository.UserRepository;
import com.eduit.bootcamp.springbootapi.model.UserDTO;
import com.eduit.bootcamp.springbootapi.model.UserRequestDTO;
import com.eduit.bootcamp.springbootapi.service.mapper.UserMapper;

public class UserAdministrationServiceImpl implements UserAdministrationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserAdministrationServiceImpl.class);
	
	private UserRepository userRepository;
	
	private UserMapper userMapper;
	
	public UserAdministrationServiceImpl(UserMapper theUserMapper, UserRepository theUserRepository) {
		userRepository = theUserRepository;
		userMapper = theUserMapper;
	}

	@Override
	public List<UserDTO> retrieveAll() throws RuntimeException {
		LOGGER.trace(String.format("Listing all users"));
		Iterable<UserEntity> users = userRepository.findAll();
		Iterator<UserEntity> iter = users.iterator();
		List<UserDTO> response = new ArrayList<>();
		while (iter.hasNext()) {
			response.add(userMapper.map(iter.next()));
		}
		return response;
	}

	@Override
	public UserDTO retrieve(Long id) throws RuntimeException {
		Optional<UserEntity> opUser = userRepository.findById(id);
		if (opUser.isEmpty()) {
			throw new RuntimeException(String.format("The product could not be found under id %d", id));
		}
		return userMapper.map(opUser.get());
	}

	@Override
	public UserDTO create(UserRequestDTO theUser) throws RuntimeException {
		Validate.notNull(theUser, "The user cannot be null.");
		LOGGER.trace(String.format("Creating user with attributes: %s", theUser.toString()));
		UserEntity toCreate = userMapper.mapEncoded(theUser);
		UserEntity created = userRepository.save(toCreate);
		return userMapper.map(created);
	}

	@Override
	public UserDTO update(UserDTO element) throws RuntimeException {
		
		return null;
	}

	@Override
	public void delete(Long id) throws RuntimeException {

	}
}
