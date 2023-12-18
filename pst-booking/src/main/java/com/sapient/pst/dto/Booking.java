package com.sapient.pst.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class Booking {
	
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
