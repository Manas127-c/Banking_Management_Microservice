package com.banking.customer.contoller;

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

import com.banking.customer.entity.Customer;
import com.banking.customer.service.CustomerService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		return new ResponseEntity<Customer>(this.customerService.createCustomer(customer), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id){
		return new ResponseEntity<Customer>(this.customerService.getCustomerById(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer,@PathVariable("id") Integer id){
		return new ResponseEntity<Customer>(this.customerService.updateCustomer(customer, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") Integer id){
		return new ResponseEntity<String>(this.customerService.deleteCustomerById(id), HttpStatus.OK);
	}
}
