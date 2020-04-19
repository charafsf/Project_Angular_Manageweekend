package com.controller.authentification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Authentification;
import com.services.AuthentificationService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/login")
public class AuthentificationController {

	@Autowired
	private AuthentificationService authService;

	@ApiOperation(value = "Retourner tous les logins existant sur l'api  ", notes = " Renvoie format JSON ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = " Liste des logins "),
		@ApiResponse(code = 404, message = " Login non trouvé ") })
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<Object> getAuths() {
		return this.authService.getAuths();
	}

	@ApiOperation(value = "Retourne un login dont on passe son id sur l'url ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = " le login qui correspond a l'id  "),
			@ApiResponse(code = 404, message = " Login non trouvé ") })
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<Object> getLogin(
			@ApiParam(value = "identifiant du login ", required = true) 
			@RequestParam(name = "login", defaultValue = "") String login) {
		return this.authService.getLogin(login);
	}

	@ApiOperation(value = " Ajouter un nouveau utilistateur ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = " le login est ajouté avec succés "),
			@ApiResponse(code = 400, message = " Syntaxe de la requéte est erroné ") })
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Object> addLogin(@RequestBody Authentification auth) {
		return this.authService.addLogin(auth);
	}

	@ApiOperation(value = " Supprimer un login avec son id  ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = " le login est supprime avec succés "),
			@ApiResponse(code = 404, message = " Login non trouvé ") })
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteLogin(
			@ApiParam(value = "identifiant du login ", required = true) 
			@RequestParam(name = "login", defaultValue = "") String login) {
		return this.authService.deleteLogin(login);
	}

}
