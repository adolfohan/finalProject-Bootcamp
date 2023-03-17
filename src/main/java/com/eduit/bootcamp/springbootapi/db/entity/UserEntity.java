package com.eduit.bootcamp.springbootapi.db.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.Validate;

@Entity
@Table(name = UserEntity.TABLE_NAME)

public class UserEntity {

	public static final String TABLE_NAME = "users";
	
	public static final String ROLE_RELATION_TABLE_NAME = "users_roles";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING) 
	@Column(name = "role")
	private UserRoleEnum role;
	
	@Column(name = "date_created", nullable = false)
	private Date dateCreated;
	
	@Column(name = "date_deleted", nullable = true)
	private Date dateDeleted;
	
	public UserEntity() {}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		Validate.notBlank(username, "The username cannot be null or blank");
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		Validate.notBlank(firstName, "The firstName cannot be null or blank");
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		Validate.notBlank(lastName, "The lastName cannot be null or blank");
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	/**
	 * Set the given password to the user.
	 * 
	 * @param password the Password, It cannot be null or blank and should be between 6 an 12 chars.
	 */
	public void setPassword(String password) {
		Validate.notBlank(password, "The password cannot be null or blank");
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRoleEnum getRole() {
		return role;
	}

	public void setRole(UserRoleEnum role) {
		this.role = role;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateDeleted() {
		return dateDeleted;
	}

	public void setDateDeleted(Date dateDeleted) {
		this.dateDeleted = dateDeleted;
	}

	
	
}
