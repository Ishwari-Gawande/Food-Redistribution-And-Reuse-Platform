package com.food.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "deliveries")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Deliveries {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "delivery_mode")
	private String deliveryMode;

	@Column(name = "status")
	private String status;

	@Column(name = "pickup_time")
	private LocalDateTime pickupTime;

	@Column(name = "delivery_time")
	private LocalDateTime deliveryTime;

	@ManyToOne
	@JoinColumn(name = "delivery_partner_id")
	private User deliveryPartner;

	@OneToOne
	@JoinColumn(name = "match_id")
	private Matches match;

}
