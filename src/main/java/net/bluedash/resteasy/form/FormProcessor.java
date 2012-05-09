package net.bluedash.resteasy.form;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/form")
public class FormProcessor {

    @Path("/process")
    @POST
    public void addName(@FormParam("firstname") String first, @FormParam("lastname") String last) {
    }

}
