package com.food.service;

import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {
public 
String uploadDocument(Long userId,String documentType, MultipartFile file);

}
