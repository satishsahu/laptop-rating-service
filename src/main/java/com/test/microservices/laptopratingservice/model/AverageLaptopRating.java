package com.test.microservices.laptopratingservice.model;

public class AverageLaptopRating {

	private long laptopId;
	private int averageRating;
	
	public AverageLaptopRating() {
	}
	
	public AverageLaptopRating(long laptopId, int averageRating) {
		super();
		this.laptopId = laptopId;
		this.averageRating = averageRating;
	}
	public long getLaptopId() {
		return laptopId;
	}
	public void setLaptopId(long laptopId) {
		this.laptopId = laptopId;
	}
	public int getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(int averageRating) {
		this.averageRating = averageRating;
	}
	
}
