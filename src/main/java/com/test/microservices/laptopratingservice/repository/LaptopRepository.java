package com.test.microservices.laptopratingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.microservices.laptopratingservice.model.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop, Long>{

	@Query(value = "select avg(rating) from customer_laptop_rating where laptop_id=?1", nativeQuery = true)
	public int getAverageRatingPerLaptop(long id);
}
