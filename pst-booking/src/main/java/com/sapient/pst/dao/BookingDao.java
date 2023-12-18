
package com.sapient.pst.dao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sapient.pst.dto.Booking;

public interface BookingDao {

    public Page<Booking> getAllBookings(Pageable pageable) ;

    public Booking getBookingById(Long id) ;
    public Booking addBooking(Booking movie) ;

    public Booking updateBooking(Long id, Booking updatedBooking) ;

    public void deleteBooking(Long id) ;
}
