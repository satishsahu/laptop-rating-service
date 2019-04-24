package com.test.microservices.laptopratingservice.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@JsonIgnoreProperties
public class CustomerLaptopRatingKey implements Serializable{

	@Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
	//@NotNull
	private Customer customer;
	
	@Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "laptop_id", referencedColumnName = "id", nullable = false)
	//@NotNull
	private Laptop laptop;
	
	public CustomerLaptopRatingKey() {
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((laptop == null) ? 0 : laptop.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerLaptopRatingKey other = (CustomerLaptopRatingKey) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (laptop == null) {
			if (other.laptop != null)
				return false;
		} else if (!laptop.equals(other.laptop))
			return false;
		return true;
	}

}
