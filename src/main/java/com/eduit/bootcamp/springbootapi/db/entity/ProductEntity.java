package com.eduit.bootcamp.springbootapi.db.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = ProductEntity.TABLE_NAME)

public class ProductEntity {
	
	public static final String TABLE_NAME = "products";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String description;
	
	@ManyToOne
	@JoinColumn(name="category_id", nullable = false)
	private CategoryEntity category;
	
	@Column(nullable = false)
	private BigDecimal price;
	
	@Column(nullable = false)
	private Integer qty;
	
	@Column(name = "date_created", nullable = false)
	private Date dateCreated;
	
	@Column(name = "date_deleted", nullable = true)
	private Date dateDeleted;
	
	public ProductEntity() { }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
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
