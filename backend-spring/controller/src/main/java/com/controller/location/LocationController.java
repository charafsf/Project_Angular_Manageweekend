package com.controller.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Location;
import com.services.LocationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/location") 
@Api ( value = "Personne " , description = " Opérations relatives aux personnes qui sont enregistré sur l'application  ")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@ApiOperation(value = "Retourner toutes les adresses qui sont enregisté sur l'api " , notes=" Renvoie format JSON ")  
	@ApiResponses ( value = {
	        @ApiResponse ( code = 200 , message = "récupérée avec succès" ) ,
	        @ApiResponse ( code = 404 , message = "La ressource que vous tentiez d'atteindre est introuvable" )
	}
	)
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<Object> getLocation() {
		return this.locationService.getLocation();
	}
	
	@ApiOperation(value = "Ajouter un objet adresse sur l'api  " , notes=" Renvoie un code http ")  
	@ApiResponses ( value = {
	        @ApiResponse ( code = 200 , message = "Ajout avec succé " ) ,
	        @ApiResponse ( code = 400, message = "La syntaxe de la requête est erronée "),
	        @ApiResponse ( code = 500, message = "Erreur interne du serveur  ")
	}
	)
	@RequestMapping(value = "/save", method = RequestMethod.POST , consumes = "application/json")
	public ResponseEntity<Object> addLocation(@RequestBody Location location) {
		return this.locationService.addLocation(location);
	}
	
	@ApiOperation(value = "Supprimer une adresse avec son id passer en paramétre " , notes ="Renvois un code http ")  
	@ApiResponses ( value = {
	        @ApiResponse ( code = 200 , message = "suppression avec succée " ) ,
	        @ApiResponse ( code = 400, message = "La syntaxe de la requête est erronée "),
	        @ApiResponse ( code = 500, message = "Erreur interne du serveur  ")
	}
	)
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteLocation(
			@ApiParam (value = "identifiant d'une adresse  ", required = true)
			@PathVariable @RequestParam(name = "idLocation", defaultValue = "") String id) {
		return this.locationService.deleteLocation(new Long(id));
	}
}

