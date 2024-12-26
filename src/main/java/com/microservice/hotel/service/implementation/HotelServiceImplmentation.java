package com.microservice.hotel.service.implementation;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.hotel.model.Hotel;
import com.microservice.hotel.repository.HotelRepository;
import com.microservice.hotel.service.HotelService;
import com.microservice.hotel.exception.ResourseNotFoundException;

@Service
public class HotelServiceImplmentation implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel saveHotel(Hotel hotel) {
		hotel.setHotelId(UUID.randomUUID().toString()); // Generate unique ID for the hotel
		hotel.setActive(1);
		hotel.setIsdelete(0);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll().stream().filter(hotel -> hotel.getActive() == 1 && hotel.getIsdelete() == 0)
				.toList();
	}

	@Override
	public Hotel getHotelById(String hotelId) {
		return hotelRepository.findById(hotelId).filter(hotel -> hotel.getActive() == 1 && hotel.getIsdelete() == 0)
				.orElseThrow(() -> new ResourseNotFoundException(2001, "Hotel with ID " + hotelId + " not found"));
	}

	@Override
	public String deleteHotelById(String hotelId) {
		Hotel hotel = hotelRepository.findById(hotelId)
				.orElseThrow(() -> new ResourseNotFoundException(2001, "Hotel with ID " + hotelId + " not found"));
		hotel.setActive(0);
		hotel.setIsdelete(1);
		hotelRepository.save(hotel);
		return "Hotel with ID " + hotelId + " deleted successfully";
	}

	@Override
	public Hotel updateHotel(Hotel updatedHotel) {
		Hotel existingHotel = hotelRepository.findById(updatedHotel.getHotelId())
				.filter(hotel -> hotel.getActive() == 1 && hotel.getIsdelete() == 0)
				.orElseThrow(() -> new ResourseNotFoundException(2001,
						"Hotel with ID " + updatedHotel.getHotelId() + " not found"));

		existingHotel.setName(updatedHotel.getName());
		existingHotel.setLocation(updatedHotel.getLocation());
		existingHotel.setAbout(updatedHotel.getAbout());

		return hotelRepository.save(existingHotel);
	}
}
