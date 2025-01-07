package com.banking.accounnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.accounnt.entity.Account;
import com.banking.accounnt.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/")
	public ResponseEntity<Account> createAccount(@RequestBody Account account){
		return new ResponseEntity<Account>(this.accountService.createAccount(account),HttpStatus.CREATED);
	}
	
	@GetMapping("/{accNo}")
	public ResponseEntity<Account> getAccountByAccNo(@PathVariable("accNo") long accNo){
		return new ResponseEntity<Account>(this.accountService.getAccountByAccNo(accNo), HttpStatus.OK);
	}
	
	@PutMapping("/{accNo}")
	public ResponseEntity<Account> updateAccount(@PathVariable("accNo") long accNo,@RequestBody Account account){
		return new ResponseEntity<Account>(this.accountService.updateAccount(accNo, account), HttpStatus.OK);
	}
	
	@DeleteMapping("/{accNo}")
	public ResponseEntity<String> deleteAccount(@PathVariable("accNo") long accNo){
		return new ResponseEntity<String>(this.accountService.deleteAccount(accNo), HttpStatus.OK);
	}
	
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<Account> getAccountByCustomerId(@PathVariable("customerId") Integer customerId){
		return new ResponseEntity<Account>(this.accountService.getAccountByUserId(customerId), HttpStatus.OK);
	}
}
