
package com.sapient.pst.dao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sapient.pst.dto.Show;

public interface ShowDao {

    public Page<Show> getAllShows(Pageable pageable) ;

    public Show getShowById(Long id) ;
    public Show addShow(Show Show) ;

    public Show updateShow(Long id, Show updatedShow) ;

	public void deleteShow(Long id);

	Page<Show> getAllShowsByMovie(Long movieId, Pageable pageable);

	Page<Show> getAllShowsByTheater(Long theaterId, Pageable pageable);

}
