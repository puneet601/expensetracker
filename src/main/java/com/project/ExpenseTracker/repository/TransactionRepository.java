package com.project.ExpenseTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ExpenseTracker.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

}
