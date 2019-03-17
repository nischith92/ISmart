package com.ismart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ismart.model.Customer;
import com.ismart.model.Transaction;
import com.ismart.repository.CustomerRepository;
import com.ismart.repository.TransactionRepository;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Transaction saveTransaction(Transaction transaction) {
		long custId = transaction.getCustomerId();
		Customer cust = customerRepository.findById(custId).orElse(null);
		if(cust == null)
			throw new RuntimeException("User does not exist");
		
		int bal = cust.getAccountBalance();
		int txAmt = transaction.getAmount();
		
		int amount;
		if(transaction.getPaymentType().equalsIgnoreCase("CREDIT")) {
			amount = bal+txAmt;	
		}
		else if(bal-txAmt < 0) {
//			throw new RuntimeException("User does not have sufficient funds");
			amount = 0;
		}
		else
			amount = bal - txAmt;
		
		cust.setAccountBalance(amount);
		customerRepository.save(cust);
		return transactionRepository.save(transaction);
	}
	public List<Transaction> findBySpendCategory(String spendCategory){
	
			List<Transaction> transactions = transactionRepository.findBySpendCategory(spendCategory);
			
			return transactions;
	}

	@Override
	public Page<Transaction> listRecentTransaction(Pageable pageable) {
		return transactionRepository.findAll(pageable);
	}

}
