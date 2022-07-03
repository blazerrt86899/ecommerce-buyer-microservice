package com.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.TransactionHistory;
import com.ecommerce.repository.BuyerRepository;
import com.ecommerce.repository.TransactionRepository;
import com.ecommerce.response.TransactionResponse;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private BuyerRepository buyerRepository;

	public Optional<TransactionHistory> addCartItem(TransactionHistory transaction, Integer buyerId) {
		return buyerRepository.findById(buyerId).map(buyer -> {
			transaction.setBuyerId(buyer);
			return transactionRepository.save(transaction);
		});

	}

	public List<TransactionResponse> getAllTransaction(Integer buyerId) {
		List<TransactionResponse> transactionResponse = new ArrayList<TransactionResponse>();
		List<TransactionHistory> transactionHistory = transactionRepository.findByBuyerId(buyerId);
		for(TransactionHistory history : transactionHistory) {
			TransactionResponse sethistory = new TransactionResponse();
			sethistory.setTransactionId(history.getTransactionId());
			sethistory.setTotalAmount(history.getTotalAmount());
			sethistory.setTransactionType(history.getTransactionType());
			sethistory.setTransactionRemarks(history.getTransactionRemarks());
			transactionResponse.add(sethistory);
		}
		return transactionResponse;
	
	}

}
