package com.food.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name = "activitylogs")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class ActivityLogs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")

	private User user;

	private String action;

	@Column(name = "entity_type")
	private String entityType;

	@Column(name = "entity_id")
	private String entityId;

	@Column(name = "created_at")
	@CreationTimestamp
	private LocalDateTime createdAt;
}
