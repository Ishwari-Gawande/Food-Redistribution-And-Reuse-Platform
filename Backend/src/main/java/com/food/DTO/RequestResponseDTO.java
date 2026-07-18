package com.food.DTO;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestResponseDTO {
	
	private Long id;

	private String requestType;

	private String status;

	private String mealPreference;

	private String estimatedMeals;

	private String pickUpAddress;

	private boolean deliveryAvailable;

	private LocalDateTime neededBy;

	private String notes;

	private LocalDateTime createdAt;
	
	private String message;
}
