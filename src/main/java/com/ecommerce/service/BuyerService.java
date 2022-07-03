package com.ecommerce.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Buyer;
import com.ecommerce.repository.AddressRepository;
import com.ecommerce.repository.BuyerRepository;

@Service
public class BuyerService implements UserDetailsService{
	
	@Autowired
	private BuyerRepository buyerRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	
	public List<Buyer> getAllBuyer() {
		return buyerRepository.findAll();
	}
	
	public Buyer createBuyer(Buyer buyer) {
		addressRepository.save(buyer.getAddress());
		buyer.setPassword(bcryptEncoder.encode(buyer.getPassword()));
		return buyerRepository.save(buyer);
	}
	
	public Buyer updateBuyer(Buyer buyer) {
		Optional<Buyer> existingBuyer = buyerRepository.findById(buyer.getBuyerId());
		Buyer newBuyer = null;
		if(existingBuyer.isPresent()) {
			newBuyer = existingBuyer.get();
			newBuyer.setUsername(buyer.getUsername());
			newBuyer.setPassword(buyer.getPassword());
			newBuyer.setEmailId(buyer.getEmailId());
			newBuyer.setMobileNumber(buyer.getMobileNumber());
			newBuyer = buyerRepository.save(newBuyer);
		}
		
		return newBuyer;
	}
	
	public Optional<Buyer> getBuyerById(Integer buyerId) {
		return buyerRepository.findById(buyerId);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Buyer buyer = buyerRepository.findByUsername(username);
		
		if(buyer == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(buyer.getUsername(), buyer.getPassword(), getAuthority());
	}
	
	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public Buyer findOne(String username) {
		// TODO Auto-generated method stub
		return buyerRepository.findByUsername(username);
	}
	

}
