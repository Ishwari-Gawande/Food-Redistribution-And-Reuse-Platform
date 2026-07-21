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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/Ishwari-Gawande/Food-Redistribution-And-Reuse-Platform
	@NotBlank(message = "Outcome is required")
<<<<<<< HEAD
	@Column(name = "outcome", nullable = false)
	private String outcome;
=======
	@Column(name = "outcome",nullable = false)
private String outcome;
>>>>>>> branch 'master' of https://github.com/Ishwari-Gawande/Food-Redistribution-And-Reuse-Platform

	@NotBlank(message = "Remark is required")
	@Column(name = "remark", nullable = false)
	private String remark;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@NotNull(message = "Delivery is required")
	@OneToOne
	@JoinColumn(name = "delivery_id")
	private Deliveries delivery;
}
