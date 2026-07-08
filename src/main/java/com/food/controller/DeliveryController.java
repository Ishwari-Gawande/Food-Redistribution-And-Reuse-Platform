package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.food.DTO.DeliveryDTO;
import com.food.service.DelieveryServiceImpl;

public class DeliveryController {
@Autowired
private DelieveryServiceImpl deliveryService;
	@PostMapping
	public ResponseEntity<?> createDelivery(
	        @RequestBody DeliveryDTO request){

	    return ResponseEntity.ok(
	            deliveryService.createDelivery(request));
	}
	
}
