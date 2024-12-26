package com.microservice.hotel.service;

import java.util.List;

import com.microservice.hotel.model.Hotel;

public interface HotelService {

	public Hotel saveHotel(Hotel hotel);

	public List<Hotel> getAllHotels();

	public Hotel getHotelById(String hotelId);

	public String deleteHotelById(String hotelId);

	public Hotel updateHotel(Hotel updatedHotel);
}
