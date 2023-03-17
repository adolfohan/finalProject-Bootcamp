package com.eduit.bootcamp.springbootapi.db.repository;

import org.springframework.data.repository.Repository;

import com.eduit.bootcamp.springbootapi.db.entity.OrderEntity;

public interface OrderRepository extends Repository<OrderEntity, Long> {

}
