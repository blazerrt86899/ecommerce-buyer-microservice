package com.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "cart_item")
public class ShoppingCart implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private Integer cartId;
	@Column
	private Integer itemId;
	@Column
	private Integer itemQuantity;
	@ManyToOne
	@JoinColumn(name = "buyer_id_fk")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Buyer buyerId;
	
	private Double unitPrice;
	
	//No arg Constructor
	public ShoppingCart() {
		// TODO Auto-generated constructor stub
	}

	//Arg Constructor
	public ShoppingCart(Integer cartId, Integer itemId, Integer itemQuantity, Buyer buyerId,Double unitPrice) {
		
		this.cartId = cartId;
		this.itemId = itemId;
		this.itemQuantity = itemQuantity;
		this.buyerId = buyerId;
		this.unitPrice = unitPrice;
	}

	//Getters and Setters
	public Integer getCartId() {
		return cartId;
	}


	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}


	public Integer getItemId() {
		return itemId;
	}
	
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}


	public Integer getItemQuantity() {
		return itemQuantity;
	}


	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}


	public Buyer getBuyerId() {
		return buyerId;
	}


	public void setBuyerId(Buyer buyerId) {
		this.buyerId = buyerId;
	}
	
	public Double getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	
	
}
