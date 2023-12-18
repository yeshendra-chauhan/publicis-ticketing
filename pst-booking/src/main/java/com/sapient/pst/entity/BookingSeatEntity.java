package com.sapient.pst.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "booking_seat")
@Data
public class BookingSeatEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookingId;
    private Long screenSeatId;
    private Float price;
    private Float discount;
    private Float netPrice;
    private String discountCode;
    
}
