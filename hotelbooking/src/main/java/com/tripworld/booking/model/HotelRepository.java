package com.tripworld.booking.model;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Oleg Volkov (AxiomSL) on 12.06.2016.
 *
 * Hotel Repository extension interface
 */
public interface HotelRepository extends CrudRepository<Hotel, Long>, JpaSpecificationExecutor<Hotel> {
    /* Custom query with join */
    Hotel findByName(String name);
}