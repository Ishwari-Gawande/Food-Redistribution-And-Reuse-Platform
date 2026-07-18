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
@Table(name = "matches")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Matches {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "donation_request_id")
	private Request donationRequest;

	@ManyToOne
	@JoinColumn(name = "receiver_request_id")
	private Request receiverRequest;

	@Column(name = "match_status")
	private String matchStatus;

	@Column(name = "matched_at")
	private LocalDateTime matchedAt;

	@ManyToOne
	@JoinColumn(name = "matched_by")
	private User matchedBy;

	@ManyToOne
	@JoinColumn(name = "delivery_partner_id")
	private User deliveryPartner;
//@OneToOne(mappedBy = "match")
//private Deliveries delivery;
}
