package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.food.DTO.DeliveryOutcomeDTO;
import com.food.service.DeliveryOutcomeServiceImpl;

public class DeliveryOutcomeController {
	@Autowired 
	private DeliveryOutcomeServiceImpl deliveryOutcomeService;
	
	 @PostMapping
	    public ResponseEntity<?> addOutcome(
	            @RequestBody DeliveryOutcomeDTO request) {

	        return ResponseEntity.ok(
	                deliveryOutcomeService.addOutcome(request));
	    }
}
