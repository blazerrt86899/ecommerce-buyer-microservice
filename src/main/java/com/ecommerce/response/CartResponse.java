package com.ecommerce.response;

public class CartResponse {

	private Integer cartId;
	private Integer itemId;
	private Integer itemQuantity;
	private Double unitPrice;
	
	
	
	public CartResponse() {
		// TODO Auto-generated constructor stub
	}


	public CartResponse(Integer cartId, Integer itemId, Integer itemQuantity, Double unitPrice) {
		
		this.cartId = cartId;
		this.itemId = itemId;
		this.itemQuantity = itemQuantity;
		this.unitPrice = unitPrice;
	}


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
	
	
	public Double getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
}
