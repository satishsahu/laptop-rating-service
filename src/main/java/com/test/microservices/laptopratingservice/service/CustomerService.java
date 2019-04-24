package com.test.microservices.laptopratingservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.microservices.laptopratingservice.model.Customer;
import com.test.microservices.laptopratingservice.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> getCustomerDetails(){
		return customerRepository.findAll();
	}
	
	public Customer saveCustomer(Customer customer){
		return customerRepository.save(customer);
	}
	
	public List<Customer> saveAllCustomers(List<Customer> customers){
		return customerRepository.saveAll(customers);
	}
	
	public Optional<Customer> findCustomerById(long id){
		return customerRepository.findById(id);
	}
}
