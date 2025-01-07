package com.banking.customer.entity;

public class Account {
	private long accountNo;
	private int customerId;
	private double balance;
	private String type;
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public Account(long accountNo, int customerId, double balance, String type) {
		super();
		this.accountNo = accountNo;
		this.customerId = customerId;
		this.balance = balance;
		this.type = type;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
