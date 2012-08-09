package resteasy737;

import javax.ws.rs.Encoded;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;

/**
 * @author Weinan Li
 * @date 08 06 2012
 */
@Path("/")
public class Blah {

    @GET
    @Path("/encoded/{seg}")
    public Response encoded(@PathParam("seg") @Encoded PathSegment seg) {
        System.out.println("***encoded");
        System.out.println(seg.getPath());
        System.out.println(seg.getMatrixParameters().getFirst("param"));
        return Response.ok().build();
    }

    @GET
    @Path("/plain/{seg}")
    public Response plain(@PathParam("seg") PathSegment seg) {
        System.out.println("***plain");
        System.out.println(seg.getPath());
        System.out.println(seg.getMatrixParameters().getFirst("param"));
        return Response.ok().build();
    }


}
