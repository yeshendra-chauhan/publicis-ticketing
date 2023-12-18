package com.sapient.pst.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sapient.pst.dao.MovieDao;
import com.sapient.pst.dto.Movie;
import com.sapient.pst.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	
	private final MovieDao movieDAO;

    public MovieServiceImpl(MovieDao movieDAO) {
        this.movieDAO = movieDAO;
    }

    @Override
    public Page<Movie> getAllMovies(Pageable pageable) {
        return movieDAO.getAllMovies(pageable);
    }
    
    @Override
    public Movie getMovieById(Long id) {
        return movieDAO.getMovieById(id);
    }
    
    @Override
    public Movie addMovie(Movie movie) {
        return movieDAO.addMovie(movie);
    }

    @Override
    public Movie updateMovie(Long id, Movie updatedMovie) {
        return movieDAO.updateMovie(id, updatedMovie);
    }

    @Override
    public void deleteMovie(Long id) {
        movieDAO.deleteMovie(id);
    }
}
