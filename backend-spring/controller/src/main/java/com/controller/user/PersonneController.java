package com.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.context.PersonneContext;
import com.entities.Personne;
import com.entities.PersonneWith;
import com.services.PersonneService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/personne") 
@Api ( value = "Personne " , description = " Opérations relatives aux personnes qui sont enregistré sur l'application  ")
public class PersonneController {
	
	@Autowired
	private PersonneService personneService;
	

	@ApiOperation(value = "Retourner toutes les peronnes sur l'api " , notes=" Renvoie format JSON ")  
	@ApiResponses ( value = {
	        @ApiResponse ( code = 200 , message = "récupérée avec succès" ) ,
	        @ApiResponse ( code = 404 , message = "La ressource que vous tentiez d'atteindre est introuvable" )
	}
	)
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<Object> getPersonne() {
		return this.personneService.getPersonne();
	}

	@ApiOperation(value = "Ajouter une personnes sur l'api de l'application  " , notes=" Renvoie un code http ")  
	@ApiResponses ( value = {
	        @ApiResponse ( code = 200 , message = "Ajout avec succé " ) ,
	        @ApiResponse ( code = 400, message = "La syntaxe de la requête est erronée "),
	        @ApiResponse ( code = 500, message = "Erreur interne du serveur  ")
	}
	)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Object> addPersonne(@RequestBody Personne personne) {
		return this.personneService.addPersonne(personne);
	}
	
	@ApiOperation(value = "Supprimer une application avec son id passer en paramétre " , notes ="Renvois un code http ")  
	@ApiResponses ( value = {
	        @ApiResponse ( code = 200 , message = "suppression avec succée " ) ,
	        @ApiResponse ( code = 400, message = "La syntaxe de la requête est erronée "),
	        @ApiResponse ( code = 500, message = "Erreur interne du serveur  ")
	}
	)
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void deletePersonne(
			@ApiParam(value = "identifiant d'une personne ", required = true)
			@PathVariable
			@RequestParam(name = "idPersonne", defaultValue = "") String id) {
		this.personneService.deletePersonne(new Long(id));
	}
	
	@ApiOperation(value = "Ajouter une personnes sur l'api de l'application  " , notes=" Renvoie un code http ")  
	@ApiResponses ( value = {
	        @ApiResponse ( code = 200 , message = "Ajout avec succé " ) ,
	        @ApiResponse ( code = 400, message = "La syntaxe de la requête est erronée "),
	        @ApiResponse ( code = 500, message = "Erreur interne du serveur  ")
	}
	)
	@RequestMapping(value = "/saveLogin", method = RequestMethod.POST)
	public ResponseEntity<Object> addPersonneContext(@RequestBody PersonneContext personneContext) {
		return this.personneService.addPersonneContext(personneContext, PersonneWith.LOGIN);
	}
	
	@ApiOperation(value = "Ajouter une personnes sur l'api de l'application  " , notes=" Renvoie un code http ")  
	@ApiResponses ( value = {
	        @ApiResponse ( code = 200 , message = "Ajout avec succé " ) ,
	        @ApiResponse ( code = 400, message = "La syntaxe de la requête est erronée "),
	        @ApiResponse ( code = 500, message = "Erreur interne du serveur  ")
	}
	)
	@RequestMapping(value = "/saveSport", method = RequestMethod.POST)
	public ResponseEntity<Object> addPersonneSport(@RequestBody PersonneContext personneContext) {
		return this.personneService.addPersonneContext(personneContext, PersonneWith.SPORT);
	}
	
}
