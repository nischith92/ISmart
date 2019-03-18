package com.ismart.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ismart.model.Transaction;

public interface TransactionService {

	Transaction saveTransaction(Transaction transaction);
	
	List<Transaction> findBySpendCategory(String spendCategory);
	
	Page<Transaction> listRecentTransaction(Pageable pageable);
	
}
