package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.entities.Weather;
import com.repositories.WeatherRepository;

@Service
public class WeatherService {
	@Autowired
	private WeatherRepository weatherRepository;
	
	public ResponseEntity<Object> getWeather() {
		return new ResponseEntity<Object>(this.weatherRepository.findAll(),HttpStatus.OK);
	}
	
	public ResponseEntity<Object> addWeather(Weather weather) {
		return new ResponseEntity<Object>(weatherRepository.save(weather),HttpStatus.OK);
	}
	
	public ResponseEntity<Object> deleteWeather(Long id) {
		this.weatherRepository.deleteById(id);
		return this.getWeather();
	}

}

