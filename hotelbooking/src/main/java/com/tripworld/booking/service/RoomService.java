package com.tripworld.booking.service;

import java.util.List;

import com.tripworld.booking.model.Room;

/**
 * Created by Oleg Volkov (AxiomSL) on 12.06.2016.
 *
 * Room Service interface
 */
public interface RoomService {
    /* Basic CRUD operations */
    Room save(Room room);
    void delete(int roomId);
}
