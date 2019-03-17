package com.ismart.service;

import org.springframework.beans.factory.annotation.Autowired;
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
	TransactionRepository TrxRepository;
	
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
		return TrxRepository.save(transaction);
	}

}
