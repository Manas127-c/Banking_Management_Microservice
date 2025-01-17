package com.banking.customer.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.banking.customer.entity.Account;

@FeignClient(name="ACCOUNTSERVICE")
public interface AccountService {
	@GetMapping("/accounts/customer/{customerId}")
	public Account getAccount(@PathVariable("customerId") int customerId);
}
