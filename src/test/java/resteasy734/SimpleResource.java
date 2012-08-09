package resteasy734;

import org.jboss.resteasy.client.ProxyFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * @author Weinan Li
 * @date 08 06 2012
 */
@Path("/")
public class SimpleResource {
    @GET
    @Path("basic")
    @Produces("text/plain")
    public String getBasic() {
        System.out.println("getBasic()");
        return "basic";
    }

    @PUT
    @Path("basic")
    @Consumes("text/plain")
    public void putBasic(String body) {
        System.out.println(body);
    }

    @GET
    @Path("queryParam")
    @Produces("text/plain")
    public String getQueryParam(@QueryParam("param") String param) {
        System.out.println("query param: " + param);
        return param;
    }

    @GET
    @Path("matrixParam")
    @Produces("text/plain")
    public String getMatrixParam(@MatrixParam("param") String param) {
        return param;
    }

    @GET
    @Path("uriParam/{param}")
    @Produces("text/plain")
    public int getUriParam(@PathParam("param") int param) {
        return param;
    }

    @GET
    @Path("header")
    public Response getHeader() {
        return Response.ok().header("header", "headervalue").build();
    }

    @GET
    @Path("hello")
    public String sayHello() {

        AnotherResource proxy = ProxyFactory.create(AnotherResource.class, "http://127.0.0.1:8081");
        return proxy.sayHello();
    }
}
