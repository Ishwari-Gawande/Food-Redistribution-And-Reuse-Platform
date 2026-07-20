package com.food.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.DTO.RequestItemDTO;
import com.food.entities.Request;
import com.food.entities.RequestItems;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface RequestItemRepository extends JpaRepository<RequestItems, Long> {

	List<RequestItems> findByRequestId(Long requestId);

	List<RequestItems> findByRequest(Request requestId);
}
