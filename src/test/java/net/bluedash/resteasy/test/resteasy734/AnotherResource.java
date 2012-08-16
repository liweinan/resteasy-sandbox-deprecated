package net.bluedash.resteasy.test.resteasy734;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author Weinan Li
 * @date 08 06 2012
 */
@Path("/another")
public interface AnotherResource {
    @GET
    @Path("hello")
    @Produces("text/plain")
    public String sayHello();
}
