package com.ismart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ismart.model.Transaction;
import com.ismart.service.TransactionService;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin
public class TransactionController {

	Logger logger = LoggerFactory.getLogger(TransactionController.class);

	@Autowired
	TransactionService transactionService;

	@Autowired
	PagingAndSortingRepository<Transaction, Long> repository;

	@PostMapping("/makeTransaction")
	public ResponseEntity<Transaction> saveTransaction(@Valid @RequestBody Transaction transaction){
		logger.info("saveTransaction");
		logger.info("transaction : " + transaction);
		
		Transaction response = transactionService.saveTransaction(transaction);
		logger.info("transaction : " + transaction);
		return new ResponseEntity<Transaction>(response, HttpStatus.OK);
	}

	@GetMapping("/listTransaction")
	public ResponseEntity<List<Transaction>> findTransactions(@RequestParam String period ,@RequestParam String spendCategory) {
		
		List<Transaction> data = new ArrayList<>();
		
		if(!spendCategory.equals("All")) {
			data = transactionService.findBySpendCategory(spendCategory);
			
		} else if (period.equals("Current")) {
		
			Pageable pageable = PageRequest.of(0, 10,Sort.by("date").descending());
			Page<Transaction> page = transactionService.listRecentTransaction(pageable);
			data = page.getContent();
		}
		return new ResponseEntity<List<Transaction>>(data, HttpStatus.OK);
		
	}
}
