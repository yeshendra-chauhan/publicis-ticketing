package com.sapient.pst.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Movie {
	private Long id;
	private String title;
	private String genre;
	private String language;
	private Date releaseDate;
	private int duration;
	
}
