
package com.sapient.pst.dao.impl;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.sapient.pst.dao.BookingDao;
import com.sapient.pst.dto.Booking;
import com.sapient.pst.entity.BookingEntity;
import com.sapient.pst.repository.BookingRepository;
import com.sapient.pst.util.mapper.BookingMapper;

@Component
public class BookingDaoImpl implements BookingDao {

    private final BookingRepository bookingRepository;
    private BookingMapper mapper;

    public BookingDaoImpl(BookingRepository bookingRepository,BookingMapper mapper) {
        this.bookingRepository = bookingRepository;
        this.mapper = mapper;
    }
    
    public Page<Booking> getAllBookings(Pageable pageable) {
    	Page<BookingEntity> pagedBookings = bookingRepository.findAll(pageable);
    	return pagedBookings.map(objectEntity -> mapper.convertToDto(objectEntity));
    }

    public Booking getBookingById(Long id) {
        return mapper.convertToDto(bookingRepository .findById(id).orElse(null));
    }

    public Booking addBooking(Booking booking) {
    	BookingEntity entity = mapper.convertToEntity(booking);
        return mapper.convertToDto(bookingRepository.save(entity));
    }

    public Booking updateBooking(Long id, Booking updatedBooking) {
    	Optional<BookingEntity> existing = bookingRepository.findById(id);
    			
		if (existing.isPresent()) {
			updatedBooking.setId(id);
            return mapper.convertToDto(bookingRepository.save(mapper.convertToEntity(updatedBooking)));
        }
        return null;
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
