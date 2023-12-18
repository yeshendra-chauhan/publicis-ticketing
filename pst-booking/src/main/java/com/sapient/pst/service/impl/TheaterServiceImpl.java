package com.sapient.pst.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sapient.pst.dao.TheaterDao;
import com.sapient.pst.dto.Theater;
import com.sapient.pst.service.TheaterService;

@Service
public class TheaterServiceImpl implements TheaterService {
	
	private final TheaterDao theaterDAO;

    public TheaterServiceImpl(TheaterDao theaterDAO) {
        this.theaterDAO = theaterDAO;
    }

    @Override
    public Page<Theater> getAllTheaters(Pageable pageable) {
        return theaterDAO.getAllTheaters(pageable);
    }
    
    @Override
    public Theater getTheaterById(Long id) {
        return theaterDAO.getTheaterById(id);
    }
    
    @Override
    public Theater addTheater(Theater movie) {
        return theaterDAO.addTheater(movie);
    }

    @Override
    public Theater updateTheater(Long id, Theater updatedTheater) {
        return theaterDAO.updateTheater(id, updatedTheater);
    }

    @Override
    public void deleteTheater(Long id) {
        theaterDAO.deleteTheater(id);
    }
}
