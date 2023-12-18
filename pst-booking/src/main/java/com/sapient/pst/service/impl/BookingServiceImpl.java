package com.sapient.pst.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sapient.pst.dao.BookingDao;
import com.sapient.pst.dto.Booking;
import com.sapient.pst.dto.BookingSeat;
import com.sapient.pst.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {
	
	private final BookingDao bookingDAO;

    public BookingServiceImpl(BookingDao bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    @Override
    public Page<Booking> getAllBookings(Pageable pageable) {
        return bookingDAO.getAllBookings(pageable);
    }
    
    @Override
    public Booking getBookingById(Long id) {
        return bookingDAO.getBookingById(id);
    }
    
    @Override
    public Booking addBooking(Booking movie) {
        return bookingDAO.addBooking(movie);
    }

    @Override
    public Booking updateBooking(Long id, Booking updatedBooking) {
        return bookingDAO.updateBooking(id, updatedBooking);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingDAO.deleteBooking(id);
    }

	@Override
	public Page<BookingSeat> getAllSeatsByBooking(Long bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BookingSeat> getAllSeats(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
}
