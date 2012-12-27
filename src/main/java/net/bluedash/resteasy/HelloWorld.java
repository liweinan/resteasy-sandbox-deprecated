package net.bluedash.resteasy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * 12 27 2012
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
@Path("/hello")
public class HelloWorld {

    @GET
    public String sayHello() {
        return "Hello, world!";
    }
}
