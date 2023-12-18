package com.sapient.pst.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sapient.pst.dto.Booking;
import com.sapient.pst.dto.BookingSeat;

public interface BookingService {

	Page<Booking> getAllBookings(Pageable pageable);
	
	Booking getBookingById(Long id);

	Booking addBooking(Booking movie);

	Booking updateBooking(Long id, Booking updatedBooking);

	void deleteBooking(Long id);
	
	Page<BookingSeat> getAllSeatsByBooking(Long bookingId);
	
	Page<BookingSeat> getAllSeats(Pageable pageable);
}
