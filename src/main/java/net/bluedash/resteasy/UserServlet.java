package net.bluedash.resteasy;

import com.restfully.shop.services.NotFoundException;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/users")
public class UserServlet {

    private Map<Integer, UserType> userStore = new ConcurrentHashMap<Integer, UserType>();
    private AtomicInteger idGenerator = new AtomicInteger();

    @POST
    @Consumes("application/xml")
    public Response createUser(UserType user) {
        user.setId(idGenerator.incrementAndGet());
        userStore.put(user.getId(), user);
        System.out.println(user.getName() + " created: " + user.getId());
        return Response.created(URI.create("/users/" + user.getId())).build();
    }

//	@GET
//	@Path("{id}")
//	@Produces("application/xml")
//	public UserType getUser(@PathParam("id") int id) {
//		UserType u = userStore.get(id);
//		if (u == null) {
//			throw new WebApplicationException(Response.Status.NOT_FOUND);
//		}
//		return u;
//	}

//    @POST
//    @Consumes("application/xml")
//    public void putStuff(String abc, String efg) {
//        System.out.println("abc: " + abc);
//    }

    @GET
    @Path("/getstuff/{id}")
    public String getStuff(@PathParam("id") String id, String defg, String hijk) {
        System.out.println(id);
        if (Integer.valueOf(id) > 100) throw new NotFoundException("Could not find customer " + id);
        return id;
    }

}
