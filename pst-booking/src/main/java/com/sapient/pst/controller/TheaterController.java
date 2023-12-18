package com.sapient.pst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.pst.dto.Show;
import com.sapient.pst.dto.Theater;
import com.sapient.pst.service.ShowService;
import com.sapient.pst.service.TheaterService;
import com.sapient.pst.util.http.CustomPage;

@RestController
@RequestMapping("/theaters")
public class TheaterController {
	
	@Autowired
	private TheaterService service;
	
	@Autowired
	private ShowService showService;
	
	
	@GetMapping
	public CustomPage<Theater> getAllTheaters(Pageable pageable) {
		return new	CustomPage<Theater>(service.getAllTheaters(pageable));
	}
	
	@GetMapping("{theaterId}/shows")
	public CustomPage<Show> getAllShowsByMovie(@PathVariable Long theaterId, Pageable pageable) {
		return new	CustomPage<Show>(showService.getAllShowsByTheater(theaterId,pageable));
	}
}
