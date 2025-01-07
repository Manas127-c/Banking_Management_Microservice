package com.banking.customer.service;

import org.springframework.stereotype.Service;

import com.banking.customer.entity.Customer;

@Service
public interface CustomerService {
	public Customer createCustomer(Customer customer);
	public Customer getCustomerById(Integer id);
	public Customer updateCustomer(Customer customer,Integer id);
	public String deleteCustomerById(Integer id);
}
