package com.food.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "delivery_outcomes")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class DeliveryOutcomes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@OneToOne
//	@JoinColumn(name="delievery_id")
//	//@Column(name="delievery_id")
//private Delieveries delieveries;

	@Column(name = "outcome")
	private String outcome;

	@Column(name = "remark")
	private String remark;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@OneToOne
	@JoinColumn(name = "delivery_id")
	private Deliveries delivery;
}
