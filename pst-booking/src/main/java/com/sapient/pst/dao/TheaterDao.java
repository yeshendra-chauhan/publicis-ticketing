
package com.sapient.pst.dao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sapient.pst.dto.Theater;

public interface TheaterDao {

    public Page<Theater> getAllTheaters(Pageable pageable) ;

    public Theater getTheaterById(Long id) ;
    public Theater addTheater(Theater Theater) ;

    public Theater updateTheater(Long id, Theater updatedTheater) ;

    public void deleteTheater(Long id) ;
}
