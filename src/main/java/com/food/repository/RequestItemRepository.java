package com.food.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.entities.Request;
import com.food.entities.RequestItems;

public interface RequestItemRepository extends JpaRepository<RequestItems, Long> {

	List<RequestItems> findByRequest(Request requestId);
}
