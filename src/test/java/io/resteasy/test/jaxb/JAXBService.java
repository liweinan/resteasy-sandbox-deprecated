package io.resteasy.test.jaxb;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
@Path("/jaxb")
public class JAXBService {
    @GET
    @Produces("application/json")
    public XmlResourceWithJAXB getJAXBResource() {
        XmlResourceWithJAXB resourceWithJAXB = new XmlResourceWithJAXB();
        resourceWithJAXB.setAttr1("XXX");
        resourceWithJAXB.setAttr2("YYY");
        return resourceWithJAXB;
    }

    @GET
    @Path(("/json"))
    @Produces("application/json")
    public XmlResourceWithJacksonAnnotation getJacksonAnnotatedResource() {
        XmlResourceWithJacksonAnnotation resource = new XmlResourceWithJacksonAnnotation();
        resource.setAttr1("XXX");
        resource.setAttr2("YYY");
        return resource;
    }
}
