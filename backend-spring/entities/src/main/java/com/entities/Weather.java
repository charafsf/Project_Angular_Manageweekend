package com.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Weather implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@Id  @GeneratedValue
	private Long id ;
    private WeatherType weatherType;
	private Long temperature;
	
	@ManyToMany (mappedBy ="weathers")
	private List<Sport> sports;
	
}
