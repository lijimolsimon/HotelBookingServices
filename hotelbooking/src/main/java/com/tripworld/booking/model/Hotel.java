package com.tripworld.booking.model;


import javax.persistence.*;

@Entity
@Table(name = "hotels")
public class Hotel {
    private int hotel_id;
    private String hotel_name;
    private String description;
    private Long city_code;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    public int getId() {
        return hotel_id;
    }

    public void setId(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    @Column(name = "hotel_name")
    public String getHotelName() {
        return hotel_name;
    }

    public void setHotelName(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    @Column(name = "description")
    public String getDesc() {
        return description;
    }

    public void setDesc(String description) {
        this.description = description;
    }

    @Column(name = "city_code")
    public Long getCode() {
        return city_code;
    }

    public void setCode(Long city_code) {
        this.city_code = city_code;
    }


    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + hotel_id +
                ", name='" + hotel_name + '\'' +
                ", desc='" + description + '\'' +
                ", cityCode='" + city_code + '\'' +
                '}';
    }
}