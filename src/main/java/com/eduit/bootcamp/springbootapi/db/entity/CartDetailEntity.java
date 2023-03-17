package com.eduit.bootcamp.springbootapi.db.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = CartDetailEntity.TABLE_NAME)

public class CartDetailEntity {
	
	public static final String TABLE_NAME = "cart_details";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private ProductEntity product;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cart_id")
	private CartEntity cart;
	
	@Column(nullable = false)
	private Integer qty;
	
	@Column(name = "date_created", nullable = false)
	private Date dateCreated;
	
	public CartDetailEntity() { }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public CartEntity getCart() {
		return cart;
	}

	public void setCart(CartEntity cart) {
		this.cart = cart;
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

}
