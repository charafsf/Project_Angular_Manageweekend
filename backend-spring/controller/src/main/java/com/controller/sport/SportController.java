package com.controller.sport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Sport;
import com.services.SportService;

@RestController
@RequestMapping("/sport") 
public class SportController {
	
	@Autowired
	private SportService sportService;

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<Object> getSports() {
		return this.sportService.getSports();
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Object> addSport(@RequestBody Sport sport) {
		return this.sportService.addSport(sport);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteSport(@RequestParam(name = "sportName", defaultValue = "") String sportName)
	{
		return this.sportService.deleteSport(sportName);
	}
	
	/*
	@RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
	public void deleteSport() {
		this.sportService.deleteSport();
	}
	*/
}
