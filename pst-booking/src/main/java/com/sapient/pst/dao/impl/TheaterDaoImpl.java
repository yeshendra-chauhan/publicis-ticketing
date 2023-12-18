
package com.sapient.pst.dao.impl;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.sapient.pst.dao.TheaterDao;
import com.sapient.pst.dto.Theater;
import com.sapient.pst.entity.TheaterEntity;
import com.sapient.pst.repository.TheaterRepository;
import com.sapient.pst.util.mapper.TheaterMapper;

@Component
public class TheaterDaoImpl implements TheaterDao {

    private final TheaterRepository theaterRepository;
    private TheaterMapper mapper;

    public TheaterDaoImpl(TheaterRepository theaterRepository,TheaterMapper mapper) {
        this.theaterRepository = theaterRepository;
        this.mapper = mapper;
    }
    
    public Page<Theater> getAllTheaters(Pageable pageable) {
    	Page<TheaterEntity> pagedTheaters = theaterRepository.findAll(pageable);
    	return pagedTheaters.map(objectEntity -> mapper.convertToDto(objectEntity));
    }

    public Theater getTheaterById(Long id) {
        return mapper.convertToDto(theaterRepository.findById(id).orElse(null));
    }

    public Theater addTheater(Theater Theater) {
    	TheaterEntity entity = mapper.convertToEntity(Theater);
        return mapper.convertToDto(theaterRepository.save(entity));
    }

    public Theater updateTheater(Long id, Theater updatedTheater) {
    	Optional<TheaterEntity> existing = theaterRepository.findById(id);
    			
		if (existing.isPresent()) {
			updatedTheater.setId(id);
            return mapper.convertToDto(theaterRepository.save(mapper.convertToEntity(updatedTheater)));
        }
        return null;
    }

    public void deleteTheater(Long id) {
        theaterRepository.deleteById(id);
    }
}
