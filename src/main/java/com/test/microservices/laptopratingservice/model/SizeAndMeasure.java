package com.test.microservices.laptopratingservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class SizeAndMeasure {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long size;
	private String measure;

	/*@OneToOne(mappedBy = "ram")
	private Laptop ramLaptop;*/
	
	/*@OneToOne(mappedBy = "hdd")
	private Laptop hddLaptop;*/
	
	@OneToOne(mappedBy = "display")
	private Laptop displayLaptop;
	
	public SizeAndMeasure() {
	}

	public SizeAndMeasure(long id, long size, String measure) {
		super();
		this.id = id;
		this.size = size;
		this.measure = measure;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

}
