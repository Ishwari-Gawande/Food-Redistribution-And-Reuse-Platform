package com.food.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "requests")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "request_type")
	private String requestType;

	@Column(name = "status")
	private String status;

	@Column(name = "meal_preference")
	private String mealPreference;

	@Column(name = "estimated_meals")
	private String estimatedMeals;

	@Column(name = "pickup_address")
	private String pickUpAddress;

	@Column(name = "delivery_available")
	private boolean deliveryAvailable;

	@Column(name = "needed_by")
	private LocalDateTime neededBy;

	@Column(name = "notes")
	private String notes;

	@Column(name = "created_at")
	@CreationTimestamp
	private LocalDateTime createdAt;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

}
