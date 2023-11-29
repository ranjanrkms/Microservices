package com.learning.ecom.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;




@Entity
@Table(name = "T_ORDER")
@NoArgsConstructor
@AllArgsConstructor

public class Order {
	@Id
	@Column( nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;
	private Long productId ;
	private int quantity;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	} 
	
	
	
	
	
}
