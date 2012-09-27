package net.bluedash.resteasy.test.tjws;

import org.drools.guvnor.server.jaxrs.providers.atom.Entry;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * 09 27 2012
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
@Path("/")
public class GuvnorAtomResource {

    @GET
    @Path("/entry")
    @Consumes("application/xml")
    @Produces("application/xml")
    public Response createAssetFromAtom(Entry entry) {
        try {
            return Response.ok(entry).build();
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e);
        }
    }

}
