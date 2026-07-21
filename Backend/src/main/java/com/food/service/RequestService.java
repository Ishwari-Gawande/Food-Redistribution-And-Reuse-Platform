package com.food.service;

import java.util.List;

import com.food.DTO.RequestDTO;
import com.food.DTO.RequestResponseDTO;
import com.food.entities.Request;

public interface RequestService {

	public RequestResponseDTO AddNewRequest(RequestDTO dto);

	public Request findById(Long id);

	public List<Request> findAllRequest();

	public String deleteById(Long id);
}
