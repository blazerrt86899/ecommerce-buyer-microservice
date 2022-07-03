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
@Table(name = "transaction_history")
public class TransactionHistory implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private Long transactionId;
	@ManyToOne
	@JoinColumn(name = "buyer_id_fk")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Buyer buyerId;
//	private enum transactionType {
//		DEBIT,CREDIT
//	}
	@Column
	private String transactionType;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate createdOn;
	@Column
	private String transactionRemarks;
	
	@Column
	private Double totalAmount;
	//No arg Constructor
	public TransactionHistory() {
		// TODO Auto-generated constructor stub
	}
	
	//Arg Constructor
	public TransactionHistory(Long transactionId, Buyer buyerId, String transactionType, LocalDate createdOn,
			String transactionRemarks) {
		
		this.transactionId = transactionId;
		this.buyerId = buyerId;
		this.transactionType = transactionType;
		this.createdOn = createdOn;
		this.transactionRemarks = transactionRemarks;
	}
	
	//Getters and Setters
	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	
	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Buyer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Buyer buyerId) {
		this.buyerId = buyerId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public String getTransactionRemarks() {
		return transactionRemarks;
	}

	public void setTransactionRemarks(String transactionRemarks) {
		this.transactionRemarks = transactionRemarks;
	}


		
	
	
	

}
