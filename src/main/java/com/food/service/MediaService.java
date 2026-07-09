package com.food.service;

import org.springframework.web.multipart.MultipartFile;

import com.food.entities.Media;
import com.food.entities.User;

public interface MediaService {
public String uploadImage(MultipartFile file);

public Media findById(Long id);

public String deleteImage(Long id);

String uploadImage(MultipartFile file, User user);
}
