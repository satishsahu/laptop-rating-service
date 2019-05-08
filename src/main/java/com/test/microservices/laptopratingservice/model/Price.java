package com.test.microservices.laptopratingservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Price {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long rate;
	private String currency;
	
	@OneToOne(mappedBy = "price")
	private Laptop laptop;
	
	public Price() {
	}
	
	public Price(long id, long rate, String currency) {
		super();
		this.id = id;
		this.rate = rate;
		this.currency = currency;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRate() {
		return rate;
	}

	public void setRate(long rate) {
		this.rate = rate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
