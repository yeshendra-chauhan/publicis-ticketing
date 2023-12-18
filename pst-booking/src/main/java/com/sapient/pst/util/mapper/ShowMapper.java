package com.sapient.pst.util.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.sapient.pst.dto.Show;
import com.sapient.pst.entity.ShowEntity;

@Component
public class ShowMapper {
	
	private ModelMapper mapper;
	
	public ShowMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}
	
	public ShowEntity convertToEntity(Show movie) {
		if(Objects.isNull(movie)) return null;
		
		return mapper.map(movie, ShowEntity.class);
	}
	
	public Show convertToDto(ShowEntity entity) {
		if(Objects.isNull(entity)) return null;

		return mapper.map(entity, Show.class);
	}
	
	public List<Show> convertToDto(List<ShowEntity> entities){
		return entities.stream()
			.map(entity -> convertToDto(entity))
			.collect(Collectors.toList());
	}
	
	public List<ShowEntity> convertToEntity(List<Show> movies){
		return movies.stream()
			.map(movie -> convertToEntity(movie))
			.collect(Collectors.toList());
	}
}