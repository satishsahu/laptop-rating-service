package com.test.microservices.laptopratingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.microservices.laptopratingservice.model.CustomerLaptopRating;
import com.test.microservices.laptopratingservice.model.CustomerLaptopRatingKey;

public interface CustomerLaptopRatingRepository extends JpaRepository<CustomerLaptopRating, CustomerLaptopRatingKey>{

	@Query(value = "select * from customer_laptop_rating where laptop_id=?1", nativeQuery = true)
	public List<CustomerLaptopRating> getLaptopRatingPerLaptop(long id);
}
