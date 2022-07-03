package com.ecommerce.model;

import java.io.Serializable;
import java.time.LocalDate;

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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "purchase_history")
public class PurchaseHistory implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchase_id")
	private Long purchaseId;
	@ManyToOne
	@JoinColumn(name = "buyer_id_fk")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Buyer buyerId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transaction_history_fk")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private TransactionHistory transactionHistory;
	@Column
	private Integer itemId;
	@Column
	private Integer numberOfItems;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate createdOn;
	@Column
	private String purchaseRemarks;
	
	public PurchaseHistory() {
		// TODO Auto-generated constructor stub
	}

	public PurchaseHistory(Long purchaseId, Buyer buyerId, TransactionHistory transactionHistory,
			Integer itemId, Integer numberOfItems, LocalDate createdOn, String purchaseRemarks) {

		this.purchaseId = purchaseId;
		this.buyerId = buyerId;
		this.transactionHistory = transactionHistory;
		this.itemId = itemId;
		this.numberOfItems = numberOfItems;
		this.createdOn = createdOn;
		this.purchaseRemarks = purchaseRemarks;
	}

	public Long getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Buyer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Buyer buyerId) {
		this.buyerId = buyerId;
	}

	public TransactionHistory getTransactionHistory() {
		return transactionHistory;
	}

	public void setTransactionHistory(TransactionHistory transactionHistory) {
		this.transactionHistory = transactionHistory;
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

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public String getPurchaseRemarks() {
		return purchaseRemarks;
	}

	public void setPurchaseRemarks(String purchaseRemarks) {
		this.purchaseRemarks = purchaseRemarks;
	}

	

}
