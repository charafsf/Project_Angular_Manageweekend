package fr.istic.taa_gli.service;

import java.util.logging.Logger;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import io.undertow.Undertow;

public class RestService {
	private static final Logger logger = Logger.getLogger(RestService.class.getName());

    public static void main( String[] args ) {

        UndertowJaxrsServer ut = new UndertowJaxrsServer();

        TestApplication ta = new TestApplication();

        ut.deploy(ta); 

        ut.start(
                Undertow.builder()
                        .addHttpListener(8080, "localhost")

        );

        logger.info("JAX-RS based micro-service running!");
    }
}
