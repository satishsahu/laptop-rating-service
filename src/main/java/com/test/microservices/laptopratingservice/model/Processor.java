package com.test.microservices.laptopratingservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Processor {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String type;
	private String generation;

	public Processor() {
	}

	public Processor(long id, String type, String generation) {
		super();
		this.id = id;
		this.type = type;
		this.generation = generation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGeneration() {
		return generation;
	}

	public void setGeneration(String generation) {
		this.generation = generation;
	}

}
