package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.food.service.DocumentService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/documents")
@Validated
public class DocumentController {

	@Autowired
	private DocumentService documentService;

	@PostMapping
	public ResponseEntity<String> uploadDocument(@NotNull(message = "User ID is required") @RequestParam Long userId,  @NotBlank(message = "Document type is required") @RequestParam String documentType,
			  @NotNull(message = "File is required")	@RequestParam MultipartFile file) {
		return ResponseEntity.ok(documentService.uploadDocument(userId, documentType, file));
	}

	 @GetMapping("/{id}")
	    public ResponseEntity<?> findById(@PathVariable Long id) {

	        return ResponseEntity.ok(documentService.findById(id));
	    }
	 
	 @GetMapping("/user/{userId}")
	    public ResponseEntity<?> findUserDocuments(
	            @PathVariable Long userId) {

	        return ResponseEntity.ok(documentService.findUserDocuments(userId));
	    }

	 @PutMapping("/{id}/verify")
	    public ResponseEntity<?> verifyDocument(
	            @PathVariable Long id) {

	        return ResponseEntity.ok(documentService.verifyDocument(id));
	    }

	    @PutMapping("/{id}/reject")
	    public ResponseEntity<?> rejectDocument(
	            @PathVariable Long id) {

	        return ResponseEntity.ok(documentService.rejectDocument(id));
	    }

}
