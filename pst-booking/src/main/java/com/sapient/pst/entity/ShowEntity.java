package com.sapient.pst.entity;

import java.sql.Date;

import com.sapient.pst.dto.Show;

import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "shows")
@NamedNativeQuery(
    name = "getAllShowsByMovie",
    query =  ShowEntity.COMMON_SELECT_SHOW 
    		+ " WHERE s.movie_id= :movieId ",
    resultSetMapping = "mapping_show_dto"
)
@NamedNativeQuery(
	    name = "getAllShowsByTheater",
	    query =  ShowEntity.COMMON_SELECT_SHOW 
	    		+ " WHERE s.theater_id= :theaterId ",
	    resultSetMapping = "mapping_show_dto"
	)
@SqlResultSetMapping(
    name = "mapping_show_dto",
    classes = @ConstructorResult(
        targetClass = Show.class,
        columns = {
            @ColumnResult(name = "id", type = Long.class),
            @ColumnResult(name = "theaterId", type = Long.class),
            @ColumnResult(name = "theaterName", type = String.class),
            @ColumnResult(name = "movieId", type = Long.class),
            @ColumnResult(name = "movieTitle", type = String.class),
            @ColumnResult(name = "status", type = String.class),
            @ColumnResult(name = "showType", type = String.class),
            @ColumnResult(name = "screenType", type = String.class),
            @ColumnResult(name = "timeFrom", type = Integer.class),
            @ColumnResult(name = "timeTo", type = Integer.class),
            @ColumnResult(name = "dateFrom", type = Date.class),
            @ColumnResult(name = "dateTo", type = Date.class)
        }
    )
)
public class ShowEntity {
	public static final String COMMON_SELECT_SHOW = "select s.id,s.theater_id as theaterId,t.theater_name as theaterName,s.movie_id as movieId,m.title as movieTitle,"
    		+ "s.screen_type screenType,s.show_time_from timeFrom,s.show_time_to timeTo,"
    		+ "s.show_date_from as dateFrom,s.show_date_to as dateTo,s.show_type as showType,s.status as status "
    		+ " from shows s join movie m on m.id=s.movie_id "
    		+ " inner join theater t on t.id=s.theater_id ";
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long theaterId;
    
    private Long movieId;
    
    private String screenType;
    
    @Column(name = "show_time_from",nullable = false)
    private Integer timeFrom;
    
    @Column(name = "show_time_to",nullable = false)
    private Integer timeTo;
    
    @Column(name = "show_date_from",nullable = false)
    private Date dateFrom;
    
    @Column(name = "show_date_to",nullable = false)
    private Date dateTo;
    
    private String showType;
    
    private String status;
}
