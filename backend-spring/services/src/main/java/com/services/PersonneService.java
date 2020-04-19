package com.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.context.PersonneContext;
import com.dto.LocationDTO;
import com.dto.PersonneDTO;
import com.entities.AdressType;
import com.entities.Authentification;
import com.entities.Location;
import com.entities.Personne;
import com.entities.PersonneWith;
import com.entities.Sport;
import com.repositories.PersonneRepository;

@Service
public class PersonneService {
	
	private static Logger logger = Logger.getLogger(PersonneService.class.getName());


	@Autowired
	private PersonneRepository personneRepository;
	@Autowired
	private LocationService locationService;
	@Autowired
	private AuthentificationService authentificationService;
	@Autowired
	private SportService sportService;
	
	public ResponseEntity<Object> getPersonne() {
		List<Personne> listPersonne = this.personneRepository.findAll();
		List<PersonneDTO> result = new ArrayList<PersonneDTO>();
		for(Personne personne: listPersonne) {
			result.add(this.createPersonneDTO(personne));
		}
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}

	public ResponseEntity<Object> addPersonne(Personne personne) {
		return new ResponseEntity<Object>(this.personneRepository.save(personne), HttpStatus.OK);
	}

	public ResponseEntity<Object> deletePersonne(Long id) {
		this.personneRepository.deleteById(id);
		return new ResponseEntity<Object>(this.getPersonne(), HttpStatus.OK);
	}

	public ResponseEntity<Object> addPersonneContext(PersonneContext personneContext,PersonneWith personneWith) {
		return this.addPersonne(this.createPersonneWithLogin(personneContext,personneWith));
	}

	public Personne createPersonneWithLogin(PersonneContext peronneContext,PersonneWith personneWith) {
		Personne personne= new Personne();
		switch(personneWith) {
			case LOGIN:
				String login = peronneContext.getLogin();
				String email = peronneContext.getEmail();
				String firstName = peronneContext.getFirstName();
				String lastName = peronneContext.getLastName();
				Authentification authentification = this.authentificationService.findAuthentificationByLogin(login);
				personne.setEmail(email);
				personne.setFirstName(firstName);
				personne.setLastName(lastName);
				personne.setAuthentification(authentification);
				break;
			case SPORT:
				Long idPersonne = peronneContext.getIdPersonne();
				Optional<Personne> optPersonne= this.personneRepository.findById(idPersonne);
				if(!optPersonne.isPresent()) {
					logger.info("User with id "+idPersonne+ "does not exist");
				}else {
					personne = optPersonne.get();
					List<Sport> actualSport = personne.getSports();
					for(String sportName: peronneContext.getSportsName()) {
						Sport tmp = this.sportService.getSportByName(sportName);
						actualSport.add(tmp);
					}
				}
				break;
			case LOCATION:
				break;
			default:
				break;
		}
		
		return personne;
	}
	
	public PersonneDTO createPersonneDTO(Personne personne) {
		PersonneDTO result = new PersonneDTO();
		result.setAuthentification(personne.getAuthentification());;
		result.setEmail(personne.getEmail());
		result.setId(personne.getId());
		result.setFirstName(personne.getFirstName());
		result.setLastName(personne.getLastName());
		
		LocationDTO locationDTO = createLocationDTO(personne.getLocation());
		result.setLocationDTO(locationDTO);
		result.setSportsName(getSportName(personne.getSports()));
		return result;
	}
	
	public List<String> getSportName(List<Sport> sports){
		if(sports == null) {
			return null;
		}
		List<String> result = new ArrayList<String>();
		for(Sport sport: sports) {
			result.add(sport.getName());
		}
		return result;
	}
	
	public LocationDTO createLocationDTO(Location location) {
		if(location == null) {
			return null;
		}
		LocationDTO result = new LocationDTO();
		result.setId(location.getId());
		result.setId_parent(location.getId_parent());
		result.setName(location.getName());
		result.setType(AdressType.CITY);
		return result;
	}

}
