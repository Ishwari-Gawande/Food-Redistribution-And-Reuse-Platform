package com.food.service;

import java.util.List;

import com.food.DTO.UserDTO;
import com.food.entities.User;

public interface UserService {

	public String addNewUser(UserDTO request);
	public User findById(Long id);
	
	public List<User>findAllUsers();
	
	public User findByEmail(String email);
	
	public String updateUser(Long id, UserDTO request);
	
	public String deleteUser(Long id);
	
	String updateProfile(UserDTO request);
}
