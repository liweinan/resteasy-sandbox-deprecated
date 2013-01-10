package net.bluedash.resteasy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

/**
 * 01 10 2013
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
@Path("/users")
public interface UserEndpoint {

    @GET
    @Path("/list")
    public List<User> list();
}
