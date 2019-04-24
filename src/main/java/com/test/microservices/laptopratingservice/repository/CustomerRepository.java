package com.test.microservices.laptopratingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.microservices.laptopratingservice.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
