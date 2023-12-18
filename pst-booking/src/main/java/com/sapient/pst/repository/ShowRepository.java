package com.sapient.pst.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sapient.pst.dto.Show;
import com.sapient.pst.entity.ShowEntity;

@Repository
public interface ShowRepository extends JpaRepository<ShowEntity, Long> {

	@Query(value = "select new com.sapient.pst.dto.Show(s.id,s.theater_id,s.screen_type,s.movie_id,s.screen_type,s.screen_type,"
			+ "s.show_time_from,s.show_time_to,s.show_date_from,s.show_date_to,s.show_type,s.status "
			+ " from shows s join movie m on m.id=s.movie_id "
			+ " inner join theater t on t.id=s.theater_id ", 
			countQuery = "select count(s.id) from shows s", nativeQuery = true)
	public Page<Show> getAllShows(String movieId,Pageable pageable);
	
	@Query(name = "getAllShowsByMovie", 
			countQuery = "select count(s.id) from shows s WHERE s.movie_id=:movieId", nativeQuery = true)
	public Page<Show> getAllShowsByMovie(Long movieId,Pageable pageable);

	@Query(name =  "getAllShowsByTheater", 
			countQuery = "select count(s.id) from shows s WHERE s.theater_id=:theaterId", nativeQuery = true)
	public Page<Show> getAllShowsByTheater(Long theaterId,Pageable pageable);
	
	
}