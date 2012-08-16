package net.bluedash.resteasy.test.snippets;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author Weinan Li
 * @date 08 09 2012
 */
@Path("/")
public class FormResource {

    @GET
    @Produces("text/plain")
    @Path("decoded/form")
    public String getDecodedFormParamGet(@FormParam("f") String formParam) {
        System.out.println("getDecodedFormParamGet(): decoded: " + formParam);
        return formParam;
    }

    @GET
    @Path("exception")
    public void throwException() throws IllegalArgumentException {
        throw new IllegalArgumentException();
    }

}
