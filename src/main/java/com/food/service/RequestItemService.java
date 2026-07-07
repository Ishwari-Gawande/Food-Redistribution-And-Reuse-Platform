package com.food.service;

import java.util.List;

import com.food.entities.RequestItems;

public interface RequestItemService {

	public RequestItems findById(Long id);

	public List<RequestItems> findByRequest(Long requestId);
}
