package com.sapient.pst.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Show {
	
    private Long id;
    
    private Long theaterId;
    private String theaterName;
    
    
    private Long movieId;
    private String movieTitle;
    
    private String screenType;
    
    private Integer timeFrom;
    
    private Integer timeTo;
    
    private Date dateFrom;
    
    private Date dateTo;
    
    private String showType;
    
    private String status;
}
