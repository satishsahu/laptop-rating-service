package com.test.microservices.laptopratingservice.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Laptop {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String vendor;
	private String model;
	private String os;
	
	@OneToMany(mappedBy = "laptop", cascade = CascadeType.ALL)
    private Set<CustomerLaptopRating> customerLaptopRatings = new HashSet<>();

	public Laptop() {
	}
	
	public Laptop(long id, String vendor, String model, String os) {
		super();
		this.id = id;
		this.vendor = vendor;
		this.model = model;
		this.os = os;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public Set<CustomerLaptopRating> getCustomerLaptopRatings() {
		return customerLaptopRatings;
	}

	public void setCustomerLaptopRatings(Set<CustomerLaptopRating> customerLaptopRatings) {
		this.customerLaptopRatings = customerLaptopRatings;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", vendor=" + vendor + ", model=" + model + ", os=" + os
				+ ", customerLaptopRatings=" + customerLaptopRatings + "]";
	}
	
}
