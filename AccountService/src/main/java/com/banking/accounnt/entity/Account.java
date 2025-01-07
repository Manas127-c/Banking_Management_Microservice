package com.banking.accounnt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="Account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(
        name = "customer_seq",
        sequenceName = "customer_sequence",
        initialValue = 006520200100,
        allocationSize = 1
    )
	private long accountNo;
	
	@Column(name="customerid")
	private Integer customerId;
	
	@Column(name="balance")
	private double balance;
	
	@Column(name="type")
	private String type;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(long accountNo, Integer customerId, double balance, String type) {
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

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
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
