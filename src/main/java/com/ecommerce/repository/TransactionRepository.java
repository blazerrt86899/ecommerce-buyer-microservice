package com.ecommerce.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerce.model.TransactionHistory;

public interface TransactionRepository extends JpaRepository<TransactionHistory, Long>{

	@Query(value = "SELECT * FROM transaction_history WHERE transaction_history.buyer_id_fk = :buyerId"
			,nativeQuery = true)
	List<TransactionHistory> findByBuyerId(@Param("buyerId") Integer buyerId);

}
