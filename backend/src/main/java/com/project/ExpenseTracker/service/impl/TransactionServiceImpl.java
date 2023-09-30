package com.project.ExpenseTracker.service.impl;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.ExpenseTracker.entity.Transaction;
import com.project.ExpenseTracker.repository.TransactionRepository;
import com.project.ExpenseTracker.service.TransactionService;

@Component
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepo;

	@Override
	public List<Transaction> listTransactions(Long userId) {
		return transactionRepo.findAll();
	}

	@Override
	public Transaction addTransaction(Transaction transaction) {
		transaction.setCreatedAt(System.currentTimeMillis());
		return transactionRepo.save(transaction);
	}

	@Override
	public List<Transaction> listTransactionsByDay(LocalDate targetDate, String timeZoneId) {
//		Sun Sep 24 2023 11:26:04 GMT+0530 (India Standard Time)
		ZoneId zoneId = ZoneId.of(timeZoneId);
		Date startDate = Date.from(targetDate.atStartOfDay(zoneId).toInstant());
		Date endDate = Date.from(targetDate.plusDays(1).atStartOfDay(zoneId).toInstant());
		return transactionRepo.findByTransactionTimestampMillisBetween(startDate.getTime(), endDate.getTime());
	}

	@Override
	public List<Transaction> listTransactionsByMonth(YearMonth targetMonth, String timeZoneId) {
		ZoneId zoneId = ZoneId.of(timeZoneId);
		Date startDate = Date.from(targetMonth.atDay(1).atStartOfDay(zoneId).toInstant());
		Date endDate = Date.from(targetMonth.atEndOfMonth().atStartOfDay(zoneId).toInstant());
		return transactionRepo.findByTransactionTimestampMillisBetween(startDate.getTime(), endDate.getTime());
	}

	@Override
	public List<Transaction> listTransactionsByYear(Year targetYear, String timeZoneId) {
		ZoneId zoneId = ZoneId.of(timeZoneId);
		Date startDate = Date.from(targetYear.atMonth(1).atDay(1).atStartOfDay(zoneId).toInstant());
		Date endDate = Date.from(targetYear.atMonth(12).atEndOfMonth().atStartOfDay(zoneId).toInstant());
		return transactionRepo.findByTransactionTimestampMillisBetween(startDate.getTime(), endDate.getTime());
	}

}
