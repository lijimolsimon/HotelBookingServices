package com.tripworld.booking.service;
import org.springframework.stereotype.Service;
 
@Service("tripBookingService")
public class TripBookingService {
 
	private String name;
 
	public void setName(String name) {
		this.name = name;
	}
 
	public String sayHello() {
		return "Hello! " + name;
	}
}