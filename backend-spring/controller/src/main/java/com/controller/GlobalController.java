package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.services.GlobalService;
import com.trash.SignupDATA;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api") 
@Api ( value = "api" , description = " Opérations relatives à l'api qui sont enregistré sur l'application  ")
public class GlobalController {

	@Autowired
	private GlobalService globalService;

	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ResponseEntity<Object> singup(@RequestBody SignupDATA singnupData) {
		System.out.println(singnupData);
		return this.globalService.singup(singnupData);
	}
}
