package com.sapient.pst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.pst.dto.Show;
import com.sapient.pst.service.ShowService;
import com.sapient.pst.util.http.CustomPage;

@RestController
@RequestMapping("/shows")
public class ShowController {
	
	@Autowired
	private ShowService service;
	 
	@GetMapping
	public CustomPage<Show> getAllShows(Pageable pageable) {
		return new	CustomPage<Show>(service.getAllShows(pageable));
	}
	
	@GetMapping("movie/{movieId}")
	public CustomPage<Show> getAllShowsByMovie(@PathVariable Long movieId, Pageable pageable) {
		return new	CustomPage<Show>(service.getAllShowsByMovie(movieId,pageable));
	}
	
	@GetMapping("theater/{theaterId}")
	public CustomPage<Show> getAllShowsByTheater(@PathVariable Long theaterId, Pageable pageable) {
		return new	CustomPage<Show>(service.getAllShowsByTheater(theaterId,pageable));
	}
}
