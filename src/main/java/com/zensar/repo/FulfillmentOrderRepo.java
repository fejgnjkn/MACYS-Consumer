package com.zensar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.FulfillmentOrderEntity;

public interface FulfillmentOrderRepo extends JpaRepository<FulfillmentOrderEntity, Integer>{

}
