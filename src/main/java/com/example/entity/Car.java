package com.example.entity;

import java.util.List;

public class Car {
	private int id;
	private String name;
	private int passengers;

	private Driver driver;

	private List<Customer> customers;

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getPassengers() {
		return this.passengers;
	}
	public void setPssengrs(int passengers) {
		this.passengers = passengers;
	}

	public Driver getDriver() {
		return this.driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}
	public void setCustomer(List<Customer> customers) {
		this.customers = customers;
	}

}
