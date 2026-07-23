package com.food.DTO;

import java.time.LocalDateTime;

import com.food.entities.RequestStatus;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDTO {
	@NotNull(message = "User ID is required")
	private Long userId;

	@NotBlank(message = "Request type is required")
	private String requestType;

	@NotBlank(message = "Status is required")
	private RequestStatus status;

	@NotBlank(message = "Meal preference is required")
	private String mealPreference;

	@NotBlank(message = "Estimated meals is required")
	private String estimatedMeals;

	@NotBlank(message = "Pickup address is required")
	@Size(max = 300)
	private String pickUpAddress;

	private boolean deliveryAvailable;

	@Future(message = "Needed by must be a future date")
	private LocalDateTime neededBy;

	@Size(max = 500)
	private String notes;

	private LocalDateTime createdAt;
}
