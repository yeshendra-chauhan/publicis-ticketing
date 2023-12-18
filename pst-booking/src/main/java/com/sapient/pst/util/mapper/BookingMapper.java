package com.sapient.pst.util.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.sapient.pst.dto.Booking;
import com.sapient.pst.entity.BookingEntity;

@Component
public class BookingMapper {
	
	private ModelMapper mapper;
	
	public BookingMapper(ModelMapper modelMapper) {
		this.mapper = modelMapper;
	}
	
	public BookingEntity convertToEntity(Booking movie) {
		if(Objects.isNull(movie)) return null;
		
		return mapper.map(movie, BookingEntity.class);
	}
	
	public Booking convertToDto(BookingEntity entity) {
		if(Objects.isNull(entity)) return null;

		return mapper.map(entity, Booking.class);
	}
	
	public List<Booking> convertToDto(List<BookingEntity> entities){
		return entities.stream()
			.map(entity -> convertToDto(entity))
			.collect(Collectors.toList());
	}
	
	public List<BookingEntity> convertToEntity(List<Booking> movies){
		return movies.stream()
			.map(movie -> convertToEntity(movie))
			.collect(Collectors.toList());
	}
}