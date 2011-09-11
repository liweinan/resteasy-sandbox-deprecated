package net.bluedash.resteasy.test.unit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/helloworld")
public class HelloWorldService {

    public static final String HELLO_WORLD = "Hello, world!";

    @GET
    @Produces("text/plain")
    public String printHelloWorld() {
        return HELLO_WORLD;
    }
}

