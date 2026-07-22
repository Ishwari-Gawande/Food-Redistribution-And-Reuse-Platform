package com.food.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.entities.Request;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface RequestRepository extends JpaRepository<Request, Long> {

	public List<Request> findByStatus(String status);
}
