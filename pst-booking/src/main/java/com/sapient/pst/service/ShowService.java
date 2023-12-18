package com.sapient.pst.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sapient.pst.dto.Show;

public interface ShowService {

	Page<Show> getAllShows(Pageable pageable);
	
	Page<Show> getAllShowsByMovie(Long movieId,Pageable pageable);
	
	Page<Show> getAllShowsByTheater(Long theaterId,Pageable pageable);
	
	Show getShowById(Long id);

	Show addShow(Show theater);

	Show updateShow(Long id, Show updatedShow);

	void deleteShow(Long id);
	
}
