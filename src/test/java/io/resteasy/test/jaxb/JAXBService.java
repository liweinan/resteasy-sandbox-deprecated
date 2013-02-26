package io.resteasy.test.jaxb;

import javax.ws.rs.*;

/**
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
@Path("/jaxb")
public class JAXBService {
    @POST
    @Produces("application/json")
    public XmlResourceWithJAXB getJAXBResource(XmlResourceWithJAXB in) {
        return in;
    }

    @POST
    @Path(("/json"))
    @Produces("application/json")
    @Consumes("application/json")
    public XmlResourceWithJacksonAnnotation getJacksonAnnotatedResource(XmlResourceWithJacksonAnnotation in) {
        return in;
    }
}
