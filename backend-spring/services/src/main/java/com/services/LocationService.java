package com.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.entities.Location;
import com.repositories.LocationRepository;

@Service
public class LocationService {
	
	@Autowired
	private LocationRepository locationRepository;
	
	public ResponseEntity<Object> getLocation() {
		return new ResponseEntity<Object>(this.locationRepository.findAll(),HttpStatus.OK);
	}
	
	public ResponseEntity<Object> getLocation(Long id) {
		return new ResponseEntity<Object>(this.locationRepository.findById(id),HttpStatus.OK);
	}
	
	public ResponseEntity<Object> addLocation(Location location) {
		return new ResponseEntity<Object>(this.locationRepository.save(location),HttpStatus.OK);
	}
	
	public ResponseEntity<Object> deleteLocation(Long id) {
		this.locationRepository.deleteById(id);
		return this.getLocation();
	}
	
	public Location findLocationById(Long idLocation) {
        return this.locationRepository.findById(idLocation).get();
    }
	
	

}

