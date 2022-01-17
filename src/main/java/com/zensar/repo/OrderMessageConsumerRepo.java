package com.zensar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.OrderMessageEntity;

public interface OrderMessageConsumerRepo extends JpaRepository<OrderMessageEntity, Integer>{

}
