package com.test.microservices.laptopratingservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.microservices.laptopratingservice.model.AverageLaptopRating;
import com.test.microservices.laptopratingservice.model.Customer;
import com.test.microservices.laptopratingservice.model.Laptop;
import com.test.microservices.laptopratingservice.service.LaptopService;

@RestController
public class LaptopController {

	@Autowired
	LaptopService laptopService;
	
	@GetMapping("/laptops")
	public List<Laptop> getLaptopDetails(){
		return laptopService.getlaptopDetails();
	}
	
	@PostMapping(path="/laptop")
	public Laptop saveLaptop(@RequestBody Laptop laptop){
		System.out.println("laptop:   "+laptop);
		return laptopService.saveLaptop(laptop);
	}
	
	@PostMapping("/laptop/all")
	public List<Laptop> saveAllLaptops(@RequestBody List<Laptop> laptops){
		return laptopService.saveAllLaptops(laptops);
	}
	
	@GetMapping("average/rating/laptop/{laptopId}")
	public AverageLaptopRating getAverageRatingPerLaptop(@PathVariable String laptopId){
		return laptopService.getAverageRatingPerLaptop(Long.parseLong(laptopId));
	}
}
