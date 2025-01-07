package com.banking.accounnt.service;

import org.springframework.stereotype.Service;

import com.banking.accounnt.entity.Account;

@Service
public interface AccountService {
	public Account createAccount(Account account);
	public Account getAccountByAccNo(long accNo);
	public Account updateAccount(long accNo,Account updateAccount);
	public String deleteAccount(long accNo);
	public Account getAccountByUserId(Integer customerId);
}
