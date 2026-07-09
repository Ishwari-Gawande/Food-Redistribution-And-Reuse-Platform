package com.food.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.DTO.DeliveryDTO;
import com.food.entities.Deliveries;

public interface DeliveryService {
public String createDelivery(DeliveryDTO request);

public Deliveries findById(Long id);

public List<Deliveries> findAssignedDeliveries();

public String startDelivery(Long id);

public String completeDelivery(Long id);

public Deliveries trackDelivery(Long id);
}
