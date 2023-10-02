package com.project.ExpenseTracker.controller;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.ExpenseTracker.entity.Transaction;
import com.project.ExpenseTracker.service.TransactionService;

@RestController
@RequestMapping("/transaction")
@CrossOrigin("*")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@GetMapping("/getAllForUser/{userId}")
	private ResponseEntity<List<Transaction>> listTransactions(@PathVariable("userId") Long userId){
		return new ResponseEntity<>(transactionService.listTransactions(userId),HttpStatus.OK);
	}
	
	@PostMapping("/addTransaction")
	private ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction){
		return new ResponseEntity<>(transactionService.addTransaction(transaction),HttpStatus.OK);
	}
	
	 @GetMapping("/daily")
	    public List<Transaction> getTransactionsByDate(
	            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate targetDate,
	            @RequestParam String timeZoneId) {
	 return transactionService.listTransactionsByDay(targetDate,timeZoneId);
	 }
	 
	 @GetMapping("/monthly")
	    public List<Transaction> getTransactionsByMonth(
	            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) YearMonth targetMonth,
	            @RequestParam String timeZoneId) {
		 return transactionService.listTransactionsByMonth(targetMonth, timeZoneId);
	    }

	 @GetMapping("/yearly")
	    public List<Transaction> getTransactionsByYear(
	            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Year targetYear,
	            @RequestParam String timeZoneId) {

	       return transactionService.listTransactionsByYear(targetYear, timeZoneId);
	    }

}
