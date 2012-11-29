package net.bluedash.resteasy.form;

import org.jboss.resteasy.annotations.Form;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * 11 29 2012
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
@Path("/form/map")
public class FormMapResource {

    @POST
    public String processForm(@Form MyForm myForm) {
        return myForm.getMyMap().toString();
    }

    @GET
    public String get() {
        return "ok";
    }
}
