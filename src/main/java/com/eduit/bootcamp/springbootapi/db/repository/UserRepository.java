package com.eduit.bootcamp.springbootapi.db.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.eduit.bootcamp.springbootapi.db.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

	Optional<UserEntity> findOneByUsername(String username);
}
