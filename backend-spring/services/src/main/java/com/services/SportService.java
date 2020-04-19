package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.entities.Location;
import com.entities.Sport;
import com.entities.Weather;
import com.repositories.SportRepository;

@Service
public class SportService {
	
	@Autowired
	private SportRepository sportRepository;
	@Autowired
	private WeatherService weatherService;
	@Autowired
	private LocationService locationService;

	public ResponseEntity<Object> getSports() {
		return new ResponseEntity(this.sportRepository.findAll(),HttpStatus.OK);
	}
	
	
	public ResponseEntity<Object> addSport(Sport sport) {
		Sport checkSport = getSportByName(sport.getName());
		if(checkSport != null) {
			return new ResponseEntity(sportRepository.save(sport),HttpStatus.OK);
		}
		return new ResponseEntity(checkSport,HttpStatus.OK);
	}
	
	
	public ResponseEntity<Object> deleteSport(String name)
	{
		this.sportRepository.deleteByName(name);
        return this.getSports();
	}
	
	public Sport getSportByName(String name) {
		return this.sportRepository.findByName(name);
	}
	
	/*
	public void deleteSport() {
		this.sportRepository.deleteAll();
	}
	*/
	
	public void createSportForPersonne(Sport sport, Weather weather, Location location) {
		addSport(sport);
		this.weatherService.addWeather(weather);
		this.locationService.addLocation(location);
	}
}
