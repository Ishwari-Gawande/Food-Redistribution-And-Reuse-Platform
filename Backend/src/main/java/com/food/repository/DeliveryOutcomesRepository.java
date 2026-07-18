package com.food.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.entities.DeliveryOutcomes;

public interface DeliveryOutcomesRepository extends JpaRepository<DeliveryOutcomes, Long>{
    Optional<DeliveryOutcomes> findByDeliveryId(Long deliveryId);

}
