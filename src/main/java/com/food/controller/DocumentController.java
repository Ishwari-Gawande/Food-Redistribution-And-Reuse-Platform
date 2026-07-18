package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.food.service.DocumentService;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

	@Autowired
	private DocumentService documentService;

	@PostMapping
	public ResponseEntity<String> uploadDocument(@RequestParam Long userId, @RequestParam String documentType,
			@RequestParam MultipartFile file) {
		return ResponseEntity.ok(documentService.uploadDocument(userId, documentType, file));
	}

}
