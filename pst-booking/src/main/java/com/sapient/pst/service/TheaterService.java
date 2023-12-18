package com.sapient.pst.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sapient.pst.dto.Theater;

public interface TheaterService {

	Page<Theater> getAllTheaters(Pageable pageable);

	Theater getTheaterById(Long id);

	Theater addTheater(Theater theater);

	Theater updateTheater(Long id, Theater updatedTheater);

	void deleteTheater(Long id);
	
}
