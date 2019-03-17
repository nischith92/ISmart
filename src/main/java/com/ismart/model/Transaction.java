package com.ismart.model;

import java.util.Date;

public class Transaction {
	
	private long transactionId;
	
	private int customerId;
	
	private String transactionDescription;
	
	private String spendCategory;
	
	private int amount;
	
	private Date date;
	
	private String paymentType;

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public String getSpendCategory() {
		return spendCategory;
	}

	public void setSpendCategory(String spendCategory) {
		this.spendCategory = spendCategory;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}	

}
