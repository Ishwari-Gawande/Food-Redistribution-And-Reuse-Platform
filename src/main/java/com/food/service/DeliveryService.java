package com.food.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.DTO.DeliveryDTO;
import com.food.entities.Deliveries;

public interface DeliveryService {
public String createDelivery(DeliveryDTO request);
}
