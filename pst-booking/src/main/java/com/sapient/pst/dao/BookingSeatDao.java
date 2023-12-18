
package com.sapient.pst.dao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sapient.pst.dto.Booking;
import com.sapient.pst.dto.BookingSeat;

public interface BookingSeatDao {

    public Page<Booking> getAllBookingSeatsByBooking(Long bookingId,Pageable pageable) ;

    public BookingSeat getBookingSeatById(Long id) ;
    public BookingSeat addBookingSeat(BookingSeat bookingSeat) ;

    public BookingSeat updateBookingSeat(Long id, BookingSeat updatedBookingSeat) ;

    public void deleteBookingSeat(Long id) ;
}
