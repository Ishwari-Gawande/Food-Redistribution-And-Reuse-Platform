package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.DTO.DeliveryDTO;
import com.food.service.DelieveryServiceImpl;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
@Autowired
private DelieveryServiceImpl deliveryService;
	@PostMapping
	public ResponseEntity<?> createDelivery(
	       @Valid @RequestBody DeliveryDTO request){

	    return ResponseEntity.ok(
	            deliveryService.createDelivery(request));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){

	    return ResponseEntity.ok(
	            deliveryService.findById(id));
	}
	
	@GetMapping("/assigned")
	public ResponseEntity<?> findAssignedDeliveries(){

	    return ResponseEntity.ok(
	            deliveryService.findAssignedDeliveries());
	}
	
	@PutMapping("/{id}/start")
	public ResponseEntity<?> startDelivery(
	        @PathVariable Long id){

	    return ResponseEntity.ok(
	            deliveryService.startDelivery(id));
	}
	
	@PutMapping("/{id}/complete")
	public ResponseEntity<?> completeDelivery(
	        @PathVariable Long id){

	    return ResponseEntity.ok(
	            deliveryService.completeDelivery(id));
	}
	
	@GetMapping("/{id}/track")
	public ResponseEntity<?> trackDelivery(
	        @PathVariable Long id){

	    return ResponseEntity.ok(
	            deliveryService.trackDelivery(id));
	}
}
