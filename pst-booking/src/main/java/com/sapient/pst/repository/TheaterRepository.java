package com.sapient.pst.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.pst.entity.TheaterEntity;

@Repository
public interface TheaterRepository extends JpaRepository<TheaterEntity, Long> {
}