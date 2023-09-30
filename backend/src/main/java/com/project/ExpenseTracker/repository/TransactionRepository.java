package com.project.ExpenseTracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.ExpenseTracker.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

	@Query(nativeQuery=true, value = "SELECT * FROM TRANSACTION WHERE transactionTime>= ?1 and transactionTime <= ?2O")
	List<Transaction> findByTransactionTimestampMillisBetween(long startTime, long endTime);

}
