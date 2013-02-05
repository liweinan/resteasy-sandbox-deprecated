package net.bluedash.resteasy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
@Path("/")
public class HelloResource {

    @GET
    public String sayHello() {
        return "hello";
    }
}
