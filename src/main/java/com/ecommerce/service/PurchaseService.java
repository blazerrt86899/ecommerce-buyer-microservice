package com.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.PurchaseHistory;
import com.ecommerce.repository.PurchaseRepository;
import com.ecommerce.response.PurchaseResponse;

@Service
public class PurchaseService {
	
	@Autowired
	private PurchaseRepository purchaseRepository;

	public List<PurchaseResponse> getAllPurchase(Integer buyerId) {
		List<PurchaseResponse> purchaseResponse = new ArrayList<PurchaseResponse>();
		List<PurchaseHistory> purchaseHistory = purchaseRepository.findByBuyerId(buyerId);
		
		for(PurchaseHistory history : purchaseHistory) {
			PurchaseResponse sethistory = new PurchaseResponse();
			sethistory.setPurchaseId(history.getPurchaseId());
			sethistory.setItemId(history.getItemId());
			sethistory.setNumberOfItems(history.getNumberOfItems());
			sethistory.setPurchaseRemarks(history.getPurchaseRemarks());
			purchaseResponse.add(sethistory);
		}
		
		return purchaseResponse;
	
	}
	
	
	
}
