package com.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.entities.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {

}
