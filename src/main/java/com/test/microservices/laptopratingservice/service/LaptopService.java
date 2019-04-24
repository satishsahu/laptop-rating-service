package com.test.microservices.laptopratingservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.microservices.laptopratingservice.model.AverageLaptopRating;
import com.test.microservices.laptopratingservice.model.Customer;
import com.test.microservices.laptopratingservice.model.Laptop;
import com.test.microservices.laptopratingservice.repository.LaptopRepository;

@Service
public class LaptopService {

	@Autowired
	LaptopRepository laptopRepository;
	
	public List<Laptop> saveAllLaptops(List<Laptop> laptops){
		return laptopRepository.saveAll(laptops);
	}
	
	public Laptop saveLaptop(Laptop laptop){
		return laptopRepository.save(laptop);
	}
	
	public List<Laptop> getlaptopDetails(){
		return laptopRepository.findAll();
	}
	
	public Optional<Laptop> findLaptopById(long id){
		return laptopRepository.findById(id);
	}
	
	public AverageLaptopRating getAverageRatingPerLaptop(long id){
		return new AverageLaptopRating(id, laptopRepository.getAverageRatingPerLaptop(id));
	}
}
