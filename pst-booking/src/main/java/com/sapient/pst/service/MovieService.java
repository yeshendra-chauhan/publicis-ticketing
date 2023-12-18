package com.sapient.pst.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sapient.pst.dto.Movie;

public interface MovieService {

	Page<Movie> getAllMovies(Pageable pageable);

	Movie getMovieById(Long id);

	Movie addMovie(Movie movie);

	Movie updateMovie(Long id, Movie updatedMovie);

	void deleteMovie(Long id);
	
}
