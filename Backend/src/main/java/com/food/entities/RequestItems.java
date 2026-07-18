package com.food.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "request_items")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class RequestItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "food_category")
	private String foodCategory;

	@Column(name = "quantity")
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "request_id")
	private Request request;

	@Column(name = "unit")
	private String unit;

	@Column(name = "expiry_time")
	private LocalDateTime expiryTime;

}
