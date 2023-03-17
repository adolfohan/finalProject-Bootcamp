package com.eduit.bootcamp.springbootapi.db.repository;

import org.springframework.data.repository.CrudRepository;

import com.eduit.bootcamp.springbootapi.db.entity.CartEntity;

public interface CartRepository extends CrudRepository<CartEntity, Long> {

	
}
