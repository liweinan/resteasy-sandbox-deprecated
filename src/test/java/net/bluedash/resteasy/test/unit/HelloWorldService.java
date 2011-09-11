package net.bluedash.resteasy.test.unit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/helloworld")
public interface HelloWorldService {

    @GET
    @Produces("text/plain")
    public String printHelloWorld();
}

