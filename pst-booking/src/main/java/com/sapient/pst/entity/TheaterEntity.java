package com.sapient.pst.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "theater")
@Getter
@Setter
public class TheaterEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "theater_name",nullable = false)
    private String name;
    
    private Integer cityId;
    
    @Column(name = "is_online",nullable = false)
    private Boolean online;
}
