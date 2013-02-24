package io.resteasy.form;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

/**
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
@Path("/form")
public class FormResource {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/multipart")
    public String multipart(MultivaluedMap<String, String> formParams) {
        StringBuilder ret = new StringBuilder();
        for (String key : formParams.keySet()) {
            for (String val : formParams.get(key)) {
                ret.append(val);
            }
        }
        return ret.toString();
    }

}
