package fr.istic.taa_gli.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class TestApplication extends Application{
	@Override
    public Set<Class<?>> getClasses() {

        final Set<Class<?>> clazzes = new HashSet<Class<?>>();

        clazzes.add(PersonneService.class);
        clazzes.add(MeteoService.class);
        clazzes.add(Liste_lieux_Service.class);
        clazzes.add(Authentification_service.class);

        return clazzes;
    }
}
