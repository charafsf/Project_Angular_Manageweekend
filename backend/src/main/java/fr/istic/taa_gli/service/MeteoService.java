package fr.istic.taa_gli.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.taa_gli.dao.MeteoDao;
import fr.istic.taa_gli.domain.Meteo;


public class MeteoService {
	
private static final Logger logger = Logger.getLogger(PersonneService.class.getName());
	
    MeteoDao daometeo;
    
    public MeteoService () {
    	
    	this.daometeo = new  MeteoDao();
    }
	
    @GET
    @Path("/meteo/{meteoid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Meteo getMeteo(@PathParam("meteoid") Long id) {
    	Meteo Mt = this.daometeo.findById(id);
        return Mt;
    }
    
    @GET
    @Path("/meteo/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Meteo> getallMeteo() {
        return this.daometeo.findAll();
    }
    
    @DELETE
    @Path("/meteo/{meteoid}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteMeteo(@PathParam("meteoid") int meteoid){
    	       daometeo.delete(meteoid);
      }
    

}
