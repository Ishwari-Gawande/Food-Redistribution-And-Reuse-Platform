package com.food.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.food.DTO.DeliveryDTO;
import com.food.DTO.DeliveryOutcomeDTO;
import com.food.Exception.ResourceNotFoundException;
import com.food.entities.Deliveries;
import com.food.entities.DeliveryOutcomes;
import com.food.repository.DelieveryRepository;
import com.food.repository.DeliveryOutcomesRepository;

public class DeliveryOutcomeServiceImpl implements DeliveryOutcomesService{
@Autowired
private DelieveryRepository deliveriesRepo;
@Autowired
private DeliveryOutcomesRepository deliveryOutcomeRepo;

@Override
	public String addOutcome(DeliveryOutcomeDTO request) {
		Deliveries delivery = deliveriesRepo.findById(request.getDeliveryId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Delivery not found"));

        DeliveryOutcomes outcome=new DeliveryOutcomes();

        outcome.setDelivery(delivery);
        outcome.setOutcome(request.getOutcome());
        outcome.setRemark(request.getRemarks());
        outcome.setCreatedAt(LocalDateTime.now());

        deliveryOutcomeRepo.save(outcome);

        return "Delivery Outcome Added Successfully";
	}

}
