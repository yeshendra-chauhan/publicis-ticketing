package com.sapient.pst.util.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.sapient.pst.dto.Theater;
import com.sapient.pst.entity.TheaterEntity;

@Component
public class TheaterMapper {
	
	private ModelMapper mapper;
	
	public TheaterMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}
	
	public TheaterEntity convertToEntity(Theater movie) {
		if(Objects.isNull(movie)) return null;
		
		return mapper.map(movie, TheaterEntity.class);
	}
	
	public Theater convertToDto(TheaterEntity entity) {
		if(Objects.isNull(entity)) return null;

		return mapper.map(entity, Theater.class);
	}
	
	public List<Theater> convertToDto(List<TheaterEntity> entities){
		return entities.stream()
			.map(entity -> convertToDto(entity))
			.collect(Collectors.toList());
	}
	
	public List<TheaterEntity> convertToEntity(List<Theater> movies){
		return movies.stream()
			.map(movie -> convertToEntity(movie))
			.collect(Collectors.toList());
	}
}