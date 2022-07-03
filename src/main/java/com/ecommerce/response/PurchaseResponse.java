package com.ecommerce.response;

public class PurchaseResponse {

	private Long purchaseId;
	private Integer itemId;
	private Integer numberOfItems;
	private String purchaseRemarks;
	
	public PurchaseResponse() {
		// TODO Auto-generated constructor stub
	}

	public PurchaseResponse(Long purchaseId, Integer itemId, Integer numberOfItems, String purchaseRemarks) {
		super();
		this.purchaseId = purchaseId;
		this.itemId = itemId;
		this.numberOfItems = numberOfItems;
		this.purchaseRemarks = purchaseRemarks;
	}

	public Long getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(Integer numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public String getPurchaseRemarks() {
		return purchaseRemarks;
	}

	public void setPurchaseRemarks(String purchaseRemarks) {
		this.purchaseRemarks = purchaseRemarks;
	}
	
	
}
