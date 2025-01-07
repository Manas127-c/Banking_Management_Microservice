package com.banking.accounnt.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.accounnt.entity.Account;
import com.banking.accounnt.repository.AccountRepository;
import com.banking.accounnt.service.AccountService;
import com.banking.accounnt.exception.ResourseNotFoundException;

@Service

public class AccountServiceImplement implements AccountService{
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account createAccount(Account account) { 
		List<Account> accounts=this.accountRepository.findAll();
		List<Account> accounts2=accounts.stream().filter(acc->acc.getCustomerId()==account.getCustomerId()).collect(Collectors.toList());
		if(accounts2.isEmpty()) {
			return this.accountRepository.save(account);
		}else {
			throw new ResourseNotFoundException("Customer already has an account");
		}
	}

	@Override
	public Account getAccountByAccNo(long accNo) {
		return this.accountRepository.findById(accNo).orElseThrow(()->new ResourseNotFoundException("Data Not found"));
	}

	@Override
	public Account updateAccount(long accNo,Account updateAccount) {
		Account account=this.accountRepository.findById(accNo).orElseThrow(()->new ResourseNotFoundException("Data Not found"));
		account.setCustomerId(updateAccount.getCustomerId());
		account.setBalance(updateAccount.getBalance());
		account.setType(updateAccount.getType());
		return this.accountRepository.save(account);
	}

	@Override
	public String deleteAccount(long accNo) {
		Account account=this.accountRepository.findById(accNo).orElseThrow(()->new ResourseNotFoundException("Data Not found"));
		this.accountRepository.delete(account);
		return "Account no. "+account.getAccountNo()+" deleted";
	}

	@Override
	public Account getAccountByUserId(Integer customerId) {
		return this.accountRepository.findByCustomerId(customerId);
	}

}
