//package fr.istic.taa_gli.service;
//
//@Path("/status")
//public class StatusEndpoint {
//
//    private static final Logger logger = Logger.getLogger(StatusEndpoint.class.getName());
//
//    @GET
//    public Response getStatus() {
//
//        return Response.status(Response.Status.OK).entity("JO").build();
//    }
//    
//    @GET
//    @Path("/test")
//    public String helloWorld() {
//
//        return "hello";
//    }
//
//    @GET
//    @Path("/person")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Person getPerson() {
//    	Person p = new Person();
//    	p.setName("test");
//    	p.setFirstName("t");
//        return p;
//    }
//
//    @POST
//    @Path("/person")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void addPerson(Person p) {
//    	System.err.println(p.getName());
//    }
//    
//
//}
