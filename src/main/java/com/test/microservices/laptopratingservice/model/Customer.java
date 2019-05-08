package com.test.microservices.laptopratingservice.model;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Customer {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String email; 
	private String phone;
	@JsonIgnore
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<CustomerLaptopRating> customerLaptopRatings;
	
	public Customer() {
	}
	
	public Customer(long id, String name, String email, String phone, CustomerLaptopRating... customerLaptopRatings) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		for(CustomerLaptopRating customerLaptopRating : customerLaptopRatings) customerLaptopRating.setCustomer(this);
        this.customerLaptopRatings = Stream.of(customerLaptopRatings).collect(Collectors.toSet());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<CustomerLaptopRating> getCustomerLaptopRatings() {
		return customerLaptopRatings;
	}

	public void setCustomerLaptopRatings(Set<CustomerLaptopRating> customerLaptopRatings) {
		this.customerLaptopRatings = customerLaptopRatings;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", customerLaptopRatings=" + customerLaptopRatings + "]";
	}
	
}
