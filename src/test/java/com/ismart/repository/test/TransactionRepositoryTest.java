//package com.ismart.repository.test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.Date;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.ismart.model.Transaction;
//import com.ismart.repository.TransactionRepository;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@DataJpaTest
//public class TransactionRepositoryTest {
//
//	@Autowired
//    private TestEntityManager entityManager;
//	
//	@Autowired
//	private TransactionRepository transactionRepository;
//	
//	@Test
//	public void saveTransaction() {
//		Transaction transaction = new Transaction();
//		transaction.setAmount(1000);
//		transaction.setCustomerId(101);
//		transaction.setPaymentType("CREDIT");
//		transaction.setTransactionId(101);
//		transaction.setTransactionDescription("Test");
//		transaction.setSpendCategory("Test");
//		transaction.setDate(new Date());
//		Transaction transactionResponse = transactionRepository.save(transaction);
//		
//		assertThat(transactionResponse).isEqualTo(transaction);
//		
//	}
//
//	
//}
