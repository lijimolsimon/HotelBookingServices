package com.tripworld.booking.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tripworld.booking.model.Room;

/**
 * Created by Oleg Volkov (AxiomSL) on 12.06.2016.
 *
 * Room Service implementation
 */
@Repository
@Transactional
@Service("roomService")
public class RoomServiceImpl implements RoomService {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Room save(Room room) {
    	 this.sessionFactory.getCurrentSession().save(room);
		return room;
    }


	@Override
	public void delete(int roomId) {
	        Room room = (Room) sessionFactory.getCurrentSession().load(
	        		Room.class, roomId);
	        if (room != null) {
	            this.sessionFactory.getCurrentSession().delete(room);
	        }
		
	}


}
