package com.eduit.bootcamp.springbootapi.db.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = OrderEntity.TABLE_NAME)
public class OrderEntity {

	
	public static final String TABLE_NAME = "orders";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	
	@ManyToOne
	@JoinColumn(name ="user_id")
	private UserEntity user;
	
	@OneToMany(mappedBy = "order")
	private Set<OrderDetailEntity> details;

	@Column(name = "date_created", nullable = false)
	private Date dateCreated;
	
	@Column(name = "date_deleted", nullable = true)
	private Date dateDeleted;
	
	public OrderEntity() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public Set<OrderDetailEntity> getDetails() {
		return details;
	}

	public void setDetails(Set<OrderDetailEntity> details) {
		this.details = details;
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
