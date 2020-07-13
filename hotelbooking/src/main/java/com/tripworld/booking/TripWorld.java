package com.tripworld.booking;
 
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tripworld.booking.service.TripBookingService;
 
public class TripWorld{
 
	@SuppressWarnings("resource")
	public static void main(String[] args) {
 
		// loading the definitions from the given XML file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
 
		TripBookingService service = context.getBean("tripBookingService", TripBookingService.class);
		String message = service.sayHello();
		System.out.println(message);
 
		//set a new name
		service.setName("Spring");
		message = service.sayHello();
		System.out.println(message);
	}
}