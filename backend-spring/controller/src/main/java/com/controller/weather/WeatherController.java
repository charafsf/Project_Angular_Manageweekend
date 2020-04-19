package com.controller.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Weather;
import com.services.WeatherService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/meteo")
@Api(value = "Méteo  ", description = " Opérations relatives à la météo enregistrer sur l'api   ")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@ApiOperation(value = "Retourner toutes les infotmation de météo sur l'api ", notes = " Renvoie format JSON ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "récupérée avec succès"),
			@ApiResponse(code = 404, message = "La ressource que vous tentiez d'atteindre est introuvable") })
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<Object> getWeather() {
		return this.weatherService.getWeather();
	}

	@ApiOperation(value = "Ajouter un objet météo sur l'api de l'application  ", notes = " Renvoie un code http ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ajout avec succé "),
			@ApiResponse(code = 400, message = "La syntaxe de la requête est erronée "),
			@ApiResponse(code = 500, message = "Erreur interne du serveur  ") })
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = " application/json ")
	public ResponseEntity<Object> addWeather(@RequestBody Weather weather) {
		return this.weatherService.addWeather(weather);
	}

	@ApiOperation(value = "Supprimer un objet météo avec son id passer en paramétre ", notes = "Renvois un code http ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "suppression avec succée "),
			@ApiResponse(code = 400, message = "La syntaxe de la requête est erronée "),
			@ApiResponse(code = 500, message = "Erreur interne du serveur  ") })
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteWeather(
			@ApiParam(value = "identifiant d'une personne ", required = true) @PathVariable @RequestParam(name = "idMeteo", defaultValue = "") String id) {
		return this.weatherService.deleteWeather(new Long(id));
	}
}
