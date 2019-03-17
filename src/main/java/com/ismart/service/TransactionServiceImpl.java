package com.ismart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ismart.model.Transaction;
import com.ismart.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository TrxRepository;
	
	@Override
	public Transaction saveTransaction(Transaction transaction) {
		return TrxRepository.save(transaction);
	}

}
