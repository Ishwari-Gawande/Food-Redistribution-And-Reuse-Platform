package com.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.entities.Deliveries;

public interface DelieveryRepository extends JpaRepository<Deliveries,Long> {

}
