package com.banking.customer.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.banking.customer.entity.Account;
import com.banking.customer.entity.Customer;
import com.banking.customer.repository.CustomerRepository;
import com.banking.customer.service.CustomerService;
import com.banking.customer.exception.ResourseNotFoundException;
import com.banking.customer.external.AccountService;

@Service
public class CustomerServiceImplement implements CustomerService {
	
	@Autowired
	private AccountService accountService;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer customer) {
		return this.customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerById(Integer id) {
		Customer customer= this.customerRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Customer Data Not Found"));
//		Account account=this.restTemplate.getForObject("http://ACCOUNTSERVICE/accounts/customer/"+customer.getId(), Account.class);
//		System.out.println(account.toString());
//		customer.setAccount(account);
//		return this.customerRepository.findById(id);
//				.orElseThrow(() -> new ResourseNotFoundException("Customer Data Not Found"));
		Account account=this.accountService.getAccount(customer.getId());
		customer.setAccount(account);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer, Integer id) {
		Customer customer2 = this.customerRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Customer Data Not Found"));
		customer2.setName(customer.getName());
		customer2.setEmail(customer.getEmail());
		customer2.setPhone(customer.getPhone());
		customer2.setAddress(customer.getAddress());
		return this.customerRepository.save(customer2);
	}

	@Override
	public String deleteCustomerById(Integer id) {
		Customer customer = this.customerRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Customer Data Not Found"));
		this.customerRepository.delete(customer);
		return "customer " + customer.getName() + " data deleted.";
	}

}
