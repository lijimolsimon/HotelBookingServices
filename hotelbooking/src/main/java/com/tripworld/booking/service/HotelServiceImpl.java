package com.tripworld.booking.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tripworld.booking.model.Hotel;
import com.tripworld.booking.model.HotelRepository;

/**
 * Created by Oleg Volkov (AxiomSL) on 12.06.2016.
 *
 * Hotel Service implementation
 */
@Service("hotelService")
@Repository
@Transactional
public class HotelServiceImpl implements HotelService {
    private HotelRepository hotelRepository;


    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public Hotel searchByName(String name) {
        return hotelRepository.findByName(name);
    }

    @Override
    public Hotel save(Hotel hotel) {
    	 this.sessionFactory.getCurrentSession().save(hotel);
		return hotel;
    }


	@Override
	public void delete(int hotelId) {
	        Hotel hotel = (Hotel) sessionFactory.getCurrentSession().load(
	                Hotel.class, hotelId);
	        if (hotel != null) {
	            this.sessionFactory.getCurrentSession().delete(hotel);
	        }
		
	}
	
	    @Override
	    public List<Hotel> getAllHotels() {
	        return this.sessionFactory.getCurrentSession().createQuery("from Hotel").list();
	    }
	   
}