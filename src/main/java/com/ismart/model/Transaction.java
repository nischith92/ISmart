package com.ismart.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Transaction")
@Setter @Getter @NoArgsConstructor @ToString
public class Transaction implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long transactionId;
	
	private int customerId;
	
	private String transactionDescription;
	
	private String spendCategory;
	
	private int amount;
	
	private Date date;
	
	private String paymentType;
	

}
