package fr.istic.taa_gli.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import fr.istic.taa_gli.dao.AuthentificationDao;
import fr.istic.taa_gli.domain.Authentification;

@Path("/login")
public class Authentification_service {
	
private static final Logger logger = Logger.getLogger(PersonneService.class.getName());
	
    AuthentificationDao daoAuthentif;
    
    public Authentification_service () {
    	
    	this.daoAuthentif = new  AuthentificationDao();
    	
    }
    @GET
    @Path("/authentification/{login}")
    @Produces(MediaType.APPLICATION_JSON)
    public Authentification getAuthentif(@PathParam("login") String login) {
    	Authentification auto = this.daoAuthentif.findByName(login);
        return auto;
    }
    
    @POST
    @Path("/authentification/createAccount")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Authentification createAccount(Authentification name) {
        return this.daoAuthentif.save(name);
    }
    
    @DELETE
    @Path("/authentification/{login}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteAuthentif(@PathParam("login") String login){
    	daoAuthentif.delete(login);
      }
    
    @GET
    @Path("/authentification/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Authentification> getallAuthentif() {
        return this.daoAuthentif.findAll();
    }
    
    
}
