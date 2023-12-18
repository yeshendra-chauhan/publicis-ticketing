
package com.sapient.pst.dao.impl;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.sapient.pst.dao.ShowDao;
import com.sapient.pst.dto.Show;
import com.sapient.pst.entity.ShowEntity;
import com.sapient.pst.repository.ShowRepository;
import com.sapient.pst.util.mapper.ShowMapper;

@Component
public class ShowDaoImpl implements ShowDao {

    private final ShowRepository showRepository;
    private ShowMapper mapper;

    public ShowDaoImpl(ShowRepository theaterRepository,ShowMapper mapper) {
        this.showRepository = theaterRepository;
        this.mapper = mapper;
    }
    
    public Page<Show> getAllShows(Pageable pageable) {
    	Page<ShowEntity> pagedShows = showRepository.findAll(pageable);
    	return pagedShows.map(objectEntity -> mapper.convertToDto(objectEntity));
    }

    public Show getShowById(Long id) {
        return mapper.convertToDto(showRepository.findById(id).orElse(null));
    }

    public Show addShow(Show Show) {
    	ShowEntity entity = mapper.convertToEntity(Show);
        return mapper.convertToDto(showRepository.save(entity));
    }

    public Show updateShow(Long id, Show updatedShow) {
    	Optional<ShowEntity> existing = showRepository.findById(id);
    			
		if (existing.isPresent()) {
			updatedShow.setId(id);
            return mapper.convertToDto(showRepository.save(mapper.convertToEntity(updatedShow)));
        }
        return null;
    }

    public void deleteShow(Long id) {
        showRepository.deleteById(id);
    }

	@Override
	public Page<Show> getAllShowsByMovie(Long movieId, Pageable pageable) {
		return showRepository.getAllShowsByMovie(movieId,pageable);
	}

	@Override
	public Page<Show> getAllShowsByTheater(Long theaterId, Pageable pageable) {
		return showRepository.getAllShowsByTheater(theaterId,pageable);
	}
}
