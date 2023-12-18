
package com.sapient.pst.dao.impl;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.sapient.pst.dao.BookingSeatDao;
import com.sapient.pst.dto.Booking;
import com.sapient.pst.dto.BookingSeat;
import com.sapient.pst.entity.BookingSeatEntity;
import com.sapient.pst.repository.BookingSeatRepository;
import com.sapient.pst.util.mapper.BookingSeatMapper;

@Component
public class BookingSeatDaoImpl implements BookingSeatDao {

    private final BookingSeatRepository bookingSeatRepository;
    private BookingSeatMapper mapper;

    public BookingSeatDaoImpl(BookingSeatRepository bookingSeatRepository,BookingSeatMapper mapper) {
        this.bookingSeatRepository = bookingSeatRepository;
        this.mapper = mapper;
    }
    
    public Page<BookingSeat> getAllBookingSeats(Pageable pageable) {
    	Page<BookingSeatEntity> pagedBookingSeats = bookingSeatRepository.findAll(pageable);
    	return pagedBookingSeats.map(objectEntity -> mapper.convertToDto(objectEntity));
    }

    public BookingSeat getBookingSeatById(Long id) {
        return mapper.convertToDto(bookingSeatRepository .findById(id).orElse(null));
    }

    public BookingSeat addBookingSeat(BookingSeat bookingSeat) {
    	BookingSeatEntity entity = mapper.convertToEntity(bookingSeat);
        return mapper.convertToDto(bookingSeatRepository.save(entity));
    }

    public BookingSeat updateBookingSeat(Long id, BookingSeat updatedBookingSeat) {
    	Optional<BookingSeatEntity> existing = bookingSeatRepository.findById(id);
    			
		if (existing.isPresent()) {
			updatedBookingSeat.setId(id);
            return mapper.convertToDto(bookingSeatRepository.save(mapper.convertToEntity(updatedBookingSeat)));
        }
        return null;
    }

    public void deleteBookingSeat(Long id) {
        bookingSeatRepository.deleteById(id);
    }

	@Override
	public Page<Booking> getAllBookingSeatsByBooking(Long bookingId, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
}
