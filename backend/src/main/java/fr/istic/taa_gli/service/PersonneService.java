package fr.istic.taa_gli.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import fr.istic.taa_gli.dao.PersonneDao;
import fr.istic.taa_gli.domain.Authentification;
import fr.istic.taa_gli.domain.Liste_lieux;
import fr.istic.taa_gli.domain.Personne;

@Path("/rest")
public class PersonneService {

	private static final Logger logger = Logger.getLogger(PersonneService.class);
	
    PersonneDao daopersone;
    
    public PersonneService() {
    	
    	this.daopersone = new PersonneDao();
    }
    
    @GET
    @Path("/personne/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Personne getpersonne(@PathParam("id") Long id) {
        Personne u = this.daopersone.findById(id);
        System.out.println(u);
        return u;
    }
     
    @GET
    @Path("/personne/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Personne> getallPersonne() {
        return this.daopersone.findAll();
    }
    
    
    
    @POST
    @Path("/personne/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Personne createPersonneLog(Personne u, Authentification log) {

        return this.daopersone.save(u,log);

    }
    
    @POST
    @Path("/personne/adresse")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Personne createPersonne(Personne u, Liste_lieux adresse) {

        return this.daopersone.save(u,adresse); 

    }
    
    @POST
    @Path("/personne")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Personne createPersonne(Personne u) {

        return this.daopersone.save(u);

    }
    
    
    @DELETE
    @Path("/personne/{persid}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deletePersonne(@PathParam("persid") int persid){
                   daopersone.delete(persid);
      }

}