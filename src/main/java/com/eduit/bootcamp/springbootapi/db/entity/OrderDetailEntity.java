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
@Table(name = OrderDetailEntity.TABLE_NAME)
public class OrderDetailEntity {
	
	public static final String TABLE_NAME = "order_details";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_order_id")
	private ProductOrderEntity productOrder;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id")
	private OrderEntity order;
	
	@Column(nullable = false)
	private Integer qty;
	
	@Column(name = "date_created", nullable = false)
	private Date dateCreated;
	
	public OrderDetailEntity() { }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductOrderEntity getProduct() {
		return productOrder;
	}

	public void setProduct(ProductOrderEntity productOrder) {
		this.productOrder = productOrder;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
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
