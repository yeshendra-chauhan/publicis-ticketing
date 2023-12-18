
package com.sapient.pst.dao.impl;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.sapient.pst.dao.MovieDao;
import com.sapient.pst.dto.Movie;
import com.sapient.pst.entity.MovieEntity;
import com.sapient.pst.repository.MovieRepository;
import com.sapient.pst.util.mapper.MovieMapper;

@Component
public class MovieDaoImpl implements MovieDao {

    private final MovieRepository movieRepository;
    private MovieMapper mapper;

    public MovieDaoImpl(MovieRepository movieRepository,MovieMapper mapper) {
        this.movieRepository = movieRepository;
        this.mapper = mapper;
    }
    
    public Page<Movie> getAllMovies(Pageable pageable) {
    	Page<MovieEntity> pagedMovies = movieRepository.findAll(pageable);
    	return pagedMovies.map(objectEntity -> mapper.convertToDto(objectEntity));
    }

    public Movie getMovieById(Long id) {
        return mapper.convertToDto(movieRepository .findById(id).orElse(null));
    }

    public Movie addMovie(Movie movie) {
    	MovieEntity entity = mapper.convertToEntity(movie);
        return mapper.convertToDto(movieRepository.save(entity));
    }

    public Movie updateMovie(Long id, Movie updatedMovie) {
    	Optional<MovieEntity> existing = movieRepository.findById(id);
    			
		if (existing.isPresent()) {
			updatedMovie.setId(id);
            return mapper.convertToDto(movieRepository.save(mapper.convertToEntity(updatedMovie)));
        }
        return null;
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
