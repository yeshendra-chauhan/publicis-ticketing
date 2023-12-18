package com.sapient.pst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.pst.dto.Movie;
import com.sapient.pst.dto.Show;
import com.sapient.pst.service.MovieService;
import com.sapient.pst.service.ShowService;
import com.sapient.pst.util.http.CustomPage;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@Autowired
	private ShowService showService;
	
	@GetMapping("")
	public CustomPage<Movie> getAllMovies(Pageable pageable) {
		return new	CustomPage<Movie>(service.getAllMovies(pageable));
	}
	
	
	@GetMapping("{movieId}/shows")
	public CustomPage<Show> getAllShowsByMovie(@PathVariable Long movieId, Pageable pageable) {
		return new	CustomPage<Show>(showService.getAllShowsByMovie(movieId,pageable));
	}
	
	 
}
