package com.test.microservices.laptopratingservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.microservices.laptopratingservice.model.Customer;
import com.test.microservices.laptopratingservice.model.CustomerLaptopRating;
import com.test.microservices.laptopratingservice.model.Laptop;
import com.test.microservices.laptopratingservice.service.CustomerService;
import com.test.microservices.laptopratingservice.service.LaptopService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	LaptopService laptopService;
	
	
	@GetMapping("/customers")
	public List<Customer> getCustomerDetails(){
		return customerService.getCustomerDetails();
	}
	
	@PostMapping("/customer")
	public Customer saveCustomer(@RequestBody Customer customer){
		return customerService.saveCustomer(customer);
	}
	
	@PostMapping("/customer/all")
	public List<Customer> saveAllCustomers(@RequestBody List<Customer> customers){
		return customerService.saveAllCustomers(customers);
	}
	
	@GetMapping("/customer/{customerId}/laptop/{laptopId}/rating/{rating}")
	public void saveCustomerRating(@PathVariable String customerId, @PathVariable String laptopId, @PathVariable String rating){
		Optional<Customer> customer = customerService.findCustomerById(Long.parseLong(customerId));
		Optional<Laptop> laptop = laptopService.findLaptopById(Long.parseLong(laptopId));
		Customer customer1 = new Customer(customer.get().getId(),customer.get().getName(), customer.get().getEmail(), customer.get().getPhone(), new CustomerLaptopRating(laptop.get(), Integer.parseInt(rating)));
		customerService.saveCustomer(customer1);
	}
}
