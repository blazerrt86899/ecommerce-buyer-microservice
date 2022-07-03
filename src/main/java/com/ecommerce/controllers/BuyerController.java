package com.ecommerce.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Buyer;
import com.ecommerce.service.BuyerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/buyer")
public class BuyerController {
	
	@Autowired
	private BuyerService buyerService;
	
	@GetMapping
	List<Buyer> getAllBuyer() {
		return buyerService.getAllBuyer();
	}
	
	@PostMapping(value="/signup",produces = "application/json")
	public Buyer createBuyer(@RequestBody Buyer buyer) {
		return buyerService.createBuyer(buyer);
	}
	
	@PutMapping(value = "/update",produces = "application/json")
	public Buyer updateBuyer(@RequestBody Buyer buyer) {
		return buyerService.updateBuyer(buyer);
	}
	
	@GetMapping(value = "/getById/{bid}")
	public Optional<Buyer> getBuyerById(@PathVariable("bid") Integer buyerId) {
		return buyerService.getBuyerById(buyerId);
	}
	
	

}
