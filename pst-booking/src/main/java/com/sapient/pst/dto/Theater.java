package com.sapient.pst.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Theater {
	
    private Long id;
    
    private String name;
    
    private Integer cityId;
    
    private Boolean online;
}
