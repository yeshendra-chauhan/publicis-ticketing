
package com.sapient.pst.dao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sapient.pst.dto.Movie;

public interface MovieDao {

    public Page<Movie> getAllMovies(Pageable pageable) ;

    public Movie getMovieById(Long id) ;
    public Movie addMovie(Movie movie) ;

    public Movie updateMovie(Long id, Movie updatedMovie) ;

    public void deleteMovie(Long id) ;
}
