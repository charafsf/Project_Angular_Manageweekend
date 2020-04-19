package com.context;
import java.io.Serializable;

import com.entities.WeatherType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherContext implements Serializable {

	private static final long serialVersionUID = 1L;
	private WeatherType weatherType;
	private Long temperature;
}
