package com.project.ExpenseTracker.service;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ExpenseTracker.entity.Transaction;
import com.project.ExpenseTracker.repository.TransactionRepository;

@Service("transactionService")
public interface TransactionService {

	List<Transaction> listTransactions(Long userId);

	Transaction addTransaction(Transaction transaction);

	List<Transaction> listTransactionsByDay(LocalDate targetDate,String date);

	List<Transaction> listTransactionsByMonth(YearMonth targetMonth, String timeZoneId);

	List<Transaction> listTransactionsByYear(Year targetYear, String timeZoneId);

}
