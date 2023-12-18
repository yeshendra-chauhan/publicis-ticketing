package com.sapient.pst.util.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.sapient.pst.dto.Movie;
import com.sapient.pst.entity.MovieEntity;

@Component
public class MovieMapper {
	
	private ModelMapper mapper;
	
	public MovieMapper(ModelMapper modelMapper) {
		this.mapper = modelMapper;
	}
	
	public MovieEntity convertToEntity(Movie movie) {
		if(Objects.isNull(movie)) return null;
		
		return mapper.map(movie, MovieEntity.class);
	}
	
	public Movie convertToDto(MovieEntity entity) {
		if(Objects.isNull(entity)) return null;

		return mapper.map(entity, Movie.class);
	}
	
	public List<Movie> convertToDto(List<MovieEntity> entities){
		return entities.stream()
			.map(entity -> convertToDto(entity))
			.collect(Collectors.toList());
	}
	
	public List<MovieEntity> convertToEntity(List<Movie> movies){
		return movies.stream()
			.map(movie -> convertToEntity(movie))
			.collect(Collectors.toList());
	}
}