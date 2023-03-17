package com.eduit.bootcamp.springbootapi.service.mapper;

import com.eduit.bootcamp.springbootapi.db.entity.UserEntity;
import com.eduit.bootcamp.springbootapi.model.UserDTO;
import com.eduit.bootcamp.springbootapi.model.UserRequestDTO;

public interface UserMapper {

	UserEntity map(final UserDTO theUser);

	UserEntity mapEncoded(final UserDTO theUser);
	
	UserEntity mapEncoded(final UserRequestDTO theUser);
	
	UserDTO map(final UserEntity theUser);
}
