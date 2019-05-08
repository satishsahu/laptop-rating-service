package com.test.microservices.laptopratingservice.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Laptop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private Processor processor;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private SizeAndMeasure ram;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private SizeAndMeasure hdd;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private SizeAndMeasure display;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private Price price;
	private String vendor;
	private String model;
	private String os;
	private String image;

	@JsonIgnore
	@OneToMany(mappedBy = "laptop", cascade = CascadeType.ALL)
	private Set<CustomerLaptopRating> customerLaptopRatings = new HashSet<>();

	public Laptop() {
	}

	public Laptop(long id, Processor processor, SizeAndMeasure ram, SizeAndMeasure hdd, SizeAndMeasure display,
			Price price, String vendor, String model, String os, Set<CustomerLaptopRating> customerLaptopRatings,
			String image) {
		super();
		this.id = id;
		this.processor = processor;
		this.ram = ram;
		this.hdd = hdd;
		this.display = display;
		this.price = price;
		this.vendor = vendor;
		this.model = model;
		this.os = os;
		this.customerLaptopRatings = customerLaptopRatings;
		this.image = image;
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

	public Processor getProcessor() {
		return processor;
	}

	public void setProcessor(Processor processor) {
		this.processor = processor;
	}

	public SizeAndMeasure getRam() {
		return ram;
	}

	public void setRam(SizeAndMeasure ram) {
		this.ram = ram;
	}

	public SizeAndMeasure getHdd() {
		return hdd;
	}

	public void setHdd(SizeAndMeasure hdd) {
		this.hdd = hdd;
	}

	public SizeAndMeasure getDisplay() {
		return display;
	}

	public void setDisplay(SizeAndMeasure display) {
		this.display = display;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", processor=" + processor + ", ram=" + ram + ", hdd=" + hdd + ", display="
				+ display + ", price=" + price + ", vendor=" + vendor + ", model=" + model + ", os=" + os
				+ ", customerLaptopRatings=" + customerLaptopRatings + "]";
	}

}
