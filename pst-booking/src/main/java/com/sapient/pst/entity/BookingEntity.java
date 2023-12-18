package com.sapient.pst.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "booking")
@Getter
@Setter
public class BookingEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long showId;
    
    private Date bookingDate;
    
    private Integer ticketCnt;
    
    private Float totalAmount;
    
    private String status;
    
    private Date showDate;
    
    private Integer showTimeFrom;
    
    private Integer showTimeTo;
    
}
