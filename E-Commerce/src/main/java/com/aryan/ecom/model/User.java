package com.aryan.ecom.model;

import com.aryan.ecom.enums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String password;
	private String email;
	// @Enumerated(value = EnumType.STRING)
	private UserRole role;

	@Lob
	@Column(columnDefinition = "longblob")
	private byte[] img;
}
