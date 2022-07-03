package com.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items_table")
public class ItemInventory implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private Integer itemId;
	@Column
	private String itemName;
	@Column
	private Double itemPrice;
	@Column
	private String itemDescription;
	@Column
	private Long itemStockNumber;
	@Column
	private String itemRemarks;
	
	//No arg Constructor
	public ItemInventory() {
		// TODO Auto-generated constructor stub
	}

	//Arg Constructor
	public ItemInventory(Integer itemId, String itemName, Double itemPrice, String itemDescription,
			Long itemStockNumber, String itemRemarks) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemDescription = itemDescription;
		this.itemStockNumber = itemStockNumber;
		this.itemRemarks = itemRemarks;
	}

	//Getter and Setter
	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Long getItemStockNumber() {
		return itemStockNumber;
	}

	public void setItemStockNumber(Long itemStockNumber) {
		this.itemStockNumber = itemStockNumber;
	}

	public String getItemRemarks() {
		return itemRemarks;
	}

	public void setItemRemarks(String itemRemarks) {
		this.itemRemarks = itemRemarks;
	}

	
	
	
}
