package com.sapient.pst.dto;

import lombok.Data;

@Data
public class BookingSeat {
	
    private Long id;

    private Long bookingId;
    private Long screenSeatId;
    private Float price;
    private Float discount;
    private Float netPrice;
    private String discountCode;
    
}
