package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne(fetch = FetchType.EAGER)
	private Post post;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private long userid;
	@Column(columnDefinition = "text", nullable = false)
	private String message;
	@Column(updatable = false)
	private LocalDateTime createdDate;
	
	@PrePersist
	protected void onCreate() {
		this.createdDate = LocalDateTime.now();
	}
	
}
