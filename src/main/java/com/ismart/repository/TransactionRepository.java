package com.ismart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ismart.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>  {

}
