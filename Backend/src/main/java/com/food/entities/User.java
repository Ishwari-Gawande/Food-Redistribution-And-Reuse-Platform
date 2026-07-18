package com.food.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString(exclude = "passwordHash")
@NoArgsConstructor

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JoinColumn(name = "profile_media_id")
	@OneToOne
	private Media profileMediaId;

	@Column(length = 100, nullable = false)
	private String name;

	@Column(length = 255, unique = true, nullable = false)
	private String email;

	@Column(length = 255, nullable = false)
	private String passwordHash;

	@Column(length = 15, nullable = false, unique = true)
	private String phone;

	@Column(name = "account_type", length = 20, nullable = false)
	private String accountType;

	@Column(name = "team_role", length = 30)
	private String teamRole;

	@Column(length = 20, nullable = false)
	private String status;

	@Column(length = 300, nullable = false)
	private String address;

	@Column(length = 100, nullable = false)
	private String city;

	@Column(precision = 10, scale = 7)
	private BigDecimal latitude;

	@Column(precision = 10, scale = 7)
	private BigDecimal longitude;

	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

//	@OneToMany(mappedBy = "uploadedBy")
//	private List<Media>uploadedMedia=new ArrayList<>();
//
//	@OneToMany(mappedBy = "user")
//	private List<Document>documents=new ArrayList<>();
//
//@OneToMany(mappedBy = "user")
//private List<Request>requests=new ArrayList<>();
//
//@OneToMany(mappedBy = "user")
//List<Notification> notifications=new ArrayList<>();
//
//@OneToMany(mappedBy = "user")
//List<ActivityLogs>activityLogs=new ArrayList<>();
//
//@OneToMany(mappedBy = "deliveryPartnerId")
//List<Deliveries>deliveryPartnerId=new ArrayList<>();
//
//@OneToMany(mappedBy = "matchedBy")
//List<Matches>matchedBy=new ArrayList<>();

}
