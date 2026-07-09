package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.food.service.MediaServiceImpl;

@RestController
@RequestMapping("/api/media")
public class MediaController {
	@Autowired
    private MediaServiceImpl mediaService;

    @PostMapping
    public ResponseEntity<?> uploadImage(
            @RequestParam("file") MultipartFile file) {

        return ResponseEntity.ok(mediaService.uploadImage(file));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(mediaService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteImage(
            @PathVariable Long id) {

        return ResponseEntity.ok(mediaService.deleteImage(id));
    }
}
