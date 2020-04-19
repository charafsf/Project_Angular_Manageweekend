package com.context;



import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SportContext implements Serializable {

	private static final long serialVersionUID = 1L;

	private String sportName;
	private WeatherContext weatherContext;
}
