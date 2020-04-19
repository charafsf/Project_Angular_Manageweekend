package com.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.context.SportContext;
import com.context.WeatherContext;
import com.entities.AdressType;
import com.entities.ApiError;
import com.entities.Authentification;
import com.entities.EMessages;
import com.entities.Location;
import com.entities.Personne;
import com.entities.Sport;
import com.entities.WeatherType;
import com.repositories.AuthentificationRepository;
import com.trash.SignupDATA;

@Service
public class GlobalService {
	
	private static Logger logger = Logger.getLogger(GlobalService.class.getName());

	@Autowired
	private AuthentificationService authentificationService;
	@Autowired
	private AuthentificationRepository authentificationRepository;
	@Autowired
	private PersonneService personneService;
	@Autowired
	private SportService sportService;

	public ResponseEntity<Object> singup(SignupDATA signupDATA) {
		
		if(authentificationRepository.findByLogin(signupDATA.getLogin()) != null){
			return new ResponseEntity<Object>(new ApiError(HttpStatus.OK, EMessages.LOGIN_EXIST.getName()),
                    HttpStatus.OK);
		}
		
		
		Personne personne = createPersonneFrom(signupDATA);
		
		return new ResponseEntity<Object>(this.personneService.addPersonne(personne),HttpStatus.OK);
	}
	
	public Authentification getAuthFromResponseEntity(ResponseEntity<Object> authObj) {
		Authentification result = null;
		Optional<Authentification> authOpt = (Optional<Authentification>) authObj.getBody();
		if(authOpt.isPresent()) {
			result = authOpt.get();
		}
		return result;
	}
	
	public Location createLocationFrom(SignupDATA signupDATA) {
		Location location = new Location();
		location.setName(signupDATA.getAdress());
		location.setType(AdressType.CITY);
		location.setId_parent(0);
		return location;
	}
	
	public WeatherContext createWeatherContextFrom(SignupDATA signupDATA) {
		WeatherContext weatherContext = new WeatherContext();
		weatherContext.setTemperature((long) 20);
		switch (signupDATA.getWeather()) {
			case "SUN":
				weatherContext.setWeatherType(WeatherType.SUN);
				break;
			case "RAIN":
				weatherContext.setWeatherType(WeatherType.RAIN);
				break;
			case "WIND":
				weatherContext.setWeatherType(WeatherType.WIND);
				break;
			default:
				break;
		}
		return weatherContext;
	}
	
	public void addSportWithWeather(SportContext sportContext) {
		//SportService
	}
	public Personne createPersonneFrom(SignupDATA signupDATA) {
		Authentification authentification = new Authentification(signupDATA.getLogin(),signupDATA.getPassword());
		Location location = createLocationFrom(signupDATA);
		WeatherContext weatherContext = createWeatherContextFrom(signupDATA);
		SportContext sport = new SportContext(signupDATA.getSport(),weatherContext);
		
		List<Sport> list_sports = new ArrayList<Sport>();
		//list_sports.add(arg0);
		
		Personne personne = new Personne();
		personne.setEmail(signupDATA.getEmail());
		personne.setFirstName(signupDATA.getFirstName());
		personne.setLastName(signupDATA.getLastName());
		personne.setAuthentification(authentification);
		personne.setLocation(location);
		//personne.setSports(sports);
		return personne;
	}
}
