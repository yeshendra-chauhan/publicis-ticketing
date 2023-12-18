package com.sapient.pst.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.pst.entity.BookingSeatEntity;

@Repository
public interface BookingSeatRepository extends JpaRepository<BookingSeatEntity, Long> {
}