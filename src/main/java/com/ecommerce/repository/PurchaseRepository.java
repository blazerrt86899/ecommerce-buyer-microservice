package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.model.PurchaseHistory;

public interface PurchaseRepository extends JpaRepository<PurchaseHistory, Long>{

	@Query(value = "SELECT * FROM purchase_history WHERE purchase_history.buyer_id_fk = :buyerId"
			,nativeQuery = true)
	List<PurchaseHistory> findByBuyerId(Integer buyerId);

}
