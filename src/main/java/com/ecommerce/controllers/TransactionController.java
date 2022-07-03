package com.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.response.PurchaseResponse;
import com.ecommerce.response.TransactionResponse;
import com.ecommerce.service.PurchaseService;
import com.ecommerce.service.TransactionService;

@CrossOrigin(origins = "*")
@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private PurchaseService purchaseService;
	
	
	@GetMapping(value = "/transaction/{bid}")
	public List<TransactionResponse> getTransactionResponse(@PathVariable("bid") Integer buyerId){
		return transactionService.getAllTransaction(buyerId);
	}
	
	@GetMapping(value = "/purchase/{bid}")
	public List<PurchaseResponse> getPurchaseResponse(@PathVariable("bid") Integer buyerId){
		return purchaseService.getAllPurchase(buyerId);
	}

}
