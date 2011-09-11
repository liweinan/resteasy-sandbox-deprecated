package net.bluedash.resteasy.test.unit;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

public class HelloWorldServiceImpl implements HelloWorldService {
    public static final String HELLO_WORLD = "Hello, world!";

    @GET
    @Produces("text/plain")
    public String printHelloWorld() {
        return HELLO_WORLD;
    }
}

