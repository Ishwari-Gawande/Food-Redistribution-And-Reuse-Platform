package com.food.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.food.entities.Document;

public interface DocumentService {
public 
String uploadDocument(Long userId,String documentType, MultipartFile file);

public Document findById(Long id);

public  List<Document> findUserDocuments(Long userId);
}
