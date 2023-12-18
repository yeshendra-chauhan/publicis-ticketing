package com.sapient.pst.util.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.sapient.pst.dto.BookingSeat;
import com.sapient.pst.entity.BookingSeatEntity;

@Component
public class BookingSeatMapper {
	
	private ModelMapper mapper;
	
	public BookingSeatMapper(ModelMapper modelMapper) {
		this.mapper = modelMapper;
	}
	
	public BookingSeatEntity convertToEntity(BookingSeat movie) {
		if(Objects.isNull(movie)) return null;
		
		return mapper.map(movie, BookingSeatEntity.class);
	}
	
	public BookingSeat convertToDto(BookingSeatEntity entity) {
		if(Objects.isNull(entity)) return null;

		return mapper.map(entity, BookingSeat.class);
	}
	
	public List<BookingSeat> convertToDto(List<BookingSeatEntity> entities){
		return entities.stream()
			.map(entity -> convertToDto(entity))
			.collect(Collectors.toList());
	}
	
	public List<BookingSeatEntity> convertToEntity(List<BookingSeat> movies){
		return movies.stream()
			.map(movie -> convertToEntity(movie))
			.collect(Collectors.toList());
	}
}