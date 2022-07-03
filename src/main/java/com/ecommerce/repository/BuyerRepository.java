package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Integer>{

	Buyer findByUsername(String username);

}
