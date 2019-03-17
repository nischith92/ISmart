package com.ismart.model;

public class Customer {

	private long customerId;
	
	private String customerName;
	
	private int accountBalance;
	
	/**
	 * Getter Method For CustomerId
	 * @return customerId
	 */
	public long getCustomerId() {
		return customerId;
	}
	
	/**
	 * Setter Method For CustomerId
	 * @param customerId
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	/**
	 * 
	 * @return customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	
	/**
	 * 
	 * @param customerName
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	/**
	 * 
	 * @return accountBalance
	 */
	public int getAccountBalance() {
		return accountBalance;
	}
	
	/**
	 * 
	 * @param accountBalance
	 */
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	} 
	
}
