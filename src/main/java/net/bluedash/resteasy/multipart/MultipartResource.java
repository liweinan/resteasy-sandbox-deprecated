package net.bluedash.resteasy.multipart;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
@Path("/multi")
public class MultipartResource {

    @GET
    @Path("/ok")
    public String ok() {
        return "ok";
    }

    @PUT
    @Path("/upload")
    @Consumes("multipart/form-data")
    @Produces(MediaType.TEXT_PLAIN)
    public Response add(@MultipartForm FileUploadForm form) {
        System.out.println("MULTIPART: " + form.getUser());
        System.out.println("MULTIPART: " + String.valueOf(form.getData()));
        return Response.status(200).build();
    }
}
