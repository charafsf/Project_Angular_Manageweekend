package fr.istic.taa_gli.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.taa_gli.dao.Liste_lieuxDao;
import fr.istic.taa_gli.domain.Liste_lieux;
import fr.istic.taa_gli.domain.Personne;


public class Liste_lieux_Service {
	
	
private static final Logger logger = Logger.getLogger(PersonneService.class.getName());
	
    Liste_lieuxDao daoLieux;
    
    public Liste_lieux_Service() {
    	
    	this.daoLieux = new Liste_lieuxDao();
    	
    }
 
    @GET
    @Path("/Liste_lieux/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Liste_lieux> getListelieux() {
        return this.daoLieux.findAll();
    }
    
    @DELETE
    @Path("/Liste_lieux/{lieuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deletelieux(@PathParam("lieuid") int lieuid){
                   daoLieux.delete(lieuid);
      }
    

    @GET
    @Path("/Liste_lieux/{lieuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Liste_lieux getlieux(@PathParam("lieuid") Long id) {
        Liste_lieux Lisl = this.daoLieux.findById(id);
        return Lisl;
    }
    

}
