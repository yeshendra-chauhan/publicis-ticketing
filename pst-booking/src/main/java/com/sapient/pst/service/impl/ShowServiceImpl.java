package com.sapient.pst.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sapient.pst.dao.ShowDao;
import com.sapient.pst.dto.Show;
import com.sapient.pst.service.ShowService;

@Service
public class ShowServiceImpl implements ShowService {
	
	private final ShowDao showDAO;

    public ShowServiceImpl(ShowDao showDAO) {
        this.showDAO = showDAO;
    }

    @Override
    public Page<Show> getAllShows(Pageable pageable) {
        return showDAO.getAllShows(pageable);
    }
    
    @Override
    public Show getShowById(Long id) {
        return showDAO.getShowById(id);
    }
    
    @Override
    public Show addShow(Show movie) {
        return showDAO.addShow(movie);
    }

    @Override
    public Show updateShow(Long id, Show updatedShow) {
        return showDAO.updateShow(id, updatedShow);
    }

    @Override
    public void deleteShow(Long id) {
        showDAO.deleteShow(id);
    }

	@Override
	public Page<Show> getAllShowsByMovie(Long movieId, Pageable pageable) {
		return showDAO.getAllShowsByMovie(movieId, pageable);
	}

	@Override
	public Page<Show> getAllShowsByTheater(Long theaterId, Pageable pageable) {
		return showDAO.getAllShowsByTheater(theaterId, pageable);
	}
}
