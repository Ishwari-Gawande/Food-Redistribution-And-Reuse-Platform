package com.food.DTO;

import java.time.LocalDateTime;

import com.food.entities.RequestStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestResponseDTO {
	
	private Long id;

	private String requestType;

	private RequestStatus status;

	private String mealPreference;

	private Long estimatedMeals;

	private String pickUpAddress;

	private boolean deliveryAvailable;

	private LocalDateTime neededBy;

	private String notes;

	private LocalDateTime createdAt;
	
	private String message;
}
