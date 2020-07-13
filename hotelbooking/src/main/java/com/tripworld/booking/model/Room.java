package com.tripworld.booking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {

	private int roomId;
    private String desc;
    private int hotel_id;
	public int getRoomId() {
		return roomId;
	}
	
	@Id
	@Column(name = "room_id")
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	
	@Column(name = "description")
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Column(name = "hotel_id")
	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", desc=" + desc + ", hotel_id=" + hotel_id + "]";
	}
	

    
}
