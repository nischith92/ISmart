package com.ismart.controller.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.ismart.controller.TransactionController;
import com.ismart.model.Transaction;

@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
public class TransactionControllerTest {

	Logger logger = LoggerFactory.getLogger(TransactionController.class);
	
	@Autowired
	TransactionController trxCtrl;
	
	@Test
	public void saveTransaction() {
		Transaction transaction = new Transaction();
		transaction.setAmount(1001);
		transaction.setCustomerId(2);
		transaction.setPaymentType("DEBIT");
		transaction.setTransactionId(102);
		transaction.setTransactionDescription("Test2");
		transaction.setSpendCategory("Test2");
		transaction.setDate(new Date());
		ResponseEntity<Transaction> transactionResponse = trxCtrl.saveTransaction(transaction);
		logger.info("transactionResponse====");
		logger.info("transactionResponse===="+transactionResponse.getStatusCode());
		logger.info("transactionResponse===="+transactionResponse.getBody());
		assertThat(transactionResponse).isEqualTo(transaction);
		
	}

	
}
