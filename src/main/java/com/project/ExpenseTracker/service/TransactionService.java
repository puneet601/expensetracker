package com.project.ExpenseTracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ExpenseTracker.entity.Transaction;
import com.project.ExpenseTracker.repository.TransactionRepository;

@Service
public class TransactionService {

	
	@Autowired
	TransactionRepository transactionRepo;
	
	public List<Transaction> listTransactions(Long userId) {
		return transactionRepo.findAll();
	}

	public Transaction addTransaction(Transaction transaction) {	
		transaction.setCreatedAt(System.currentTimeMillis());
		return transactionRepo.save(transaction);
	}

}
