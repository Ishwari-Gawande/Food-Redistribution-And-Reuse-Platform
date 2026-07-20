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
@Table(name = "media")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Media {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "file_name", length = 255, nullable = false)
	private String fileName;

	@Column(name = "file_path", length = 500, nullable = false)
	private String filePath;

	@Column(name = "mime_type", length = 100, nullable = false)
	private String mimeType;

	@Column(name = "file_size", nullable = false)
	private Long fileSize;

	@Column(name = "compression_ratio")
	private Double compressionRatio;

	@ManyToOne
	@JoinColumn(name = "uploaded_by", nullable = false)
	private User uploadedBy;

	@CreationTimestamp
	@Column(name = "uploaded_at", nullable = false, updatable = false)
	private LocalDateTime uploadedAt;

}
