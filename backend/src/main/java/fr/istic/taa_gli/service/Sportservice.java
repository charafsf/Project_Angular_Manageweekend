package fr.istic.taa_gli.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.taa_gli.dao.AuthentificationDao;
import fr.istic.taa_gli.dao.SportDao;
import fr.istic.taa_gli.domain.Meteo;
import fr.istic.taa_gli.domain.Sport;

public class Sportservice {
	
private static final Logger logger = Logger.getLogger(PersonneService.class.getName());
	
    SportDao daosport;
    
    public Sportservice () {
    	
    	this.daosport = new   SportDao();
    	
    }
    
    @GET
    @Path("/sport/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Sport getSport(@PathParam("id") Long id) {
    	Sport Sp = this.daosport.findById(id);
        return Sp;
    }
    
    @GET
    @Path("/sport/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sport> getallsport() {
        return this.daosport.findAll();
    }
    
    @DELETE
    @Path("/sport/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteMeteo(@PathParam("id") int id){
    	daosport.delete(id);
      }
    

    
    
}
