package com.food.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.entities.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
	 List<Document> findByUserId(Long userId);
}
