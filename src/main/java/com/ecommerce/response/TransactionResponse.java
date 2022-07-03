package com.ecommerce.response;

public class TransactionResponse {
	
	private Long transactionId;
	private String transactionType;
	private Double totalAmount;
	private String transactionRemarks;
	
	
	public TransactionResponse() {
		// TODO Auto-generated constructor stub
	}

	public TransactionResponse(Long transactionId, String transactionType, Double totalAmount, String transactionRemarks,
			Long purchaseId, Integer itemId, Integer numberOfItems, String purchaseRemarks) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.totalAmount = totalAmount;
		this.transactionRemarks = transactionRemarks;
	}
	

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getTransactionRemarks() {
		return transactionRemarks;
	}

	public void setTransactionRemarks(String transactionRemarks) {
		this.transactionRemarks = transactionRemarks;
	}


}
