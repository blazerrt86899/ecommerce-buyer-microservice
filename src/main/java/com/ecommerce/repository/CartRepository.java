package com.ecommerce.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.ecommerce.model.ShoppingCart;

@Repository
public interface CartRepository extends JpaRepository<ShoppingCart, Integer>{
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM cart_item WHERE cart_item.buyer_id_fk = :buyerId"
			,nativeQuery = true)
	public void emptyCart(@Param("buyerId")Integer buyerId);
	
	//public List<ShoppingCart> findAllByBuyerId(Integer buyerId);
	
	@Query(value = "SELECT * FROM cart_item cart WHERE cart.buyer_id_fk = :buyerId"
			,nativeQuery = true)
	public List<ShoppingCart> getAllCartItems(@Param("buyerId")Integer buyerId);
		
	
}
