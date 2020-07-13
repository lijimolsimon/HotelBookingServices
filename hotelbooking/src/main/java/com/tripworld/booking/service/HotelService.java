package com.tripworld.booking.service;

import java.util.List;

import com.tripworld.booking.model.Hotel;


public interface HotelService {
    /* Basic CRUD operations */
    Hotel searchByName(String hotelName);
    Hotel save(Hotel hotel);
    void delete(int hotelId);
	List<Hotel> getAllHotels();
}