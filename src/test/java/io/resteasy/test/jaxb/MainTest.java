package io.resteasy.test.jaxb;

import io.resteasy.json.JsonObjectMarshaller;
import io.resteasy.json.JsonObjectUnmarshaller;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jboss.resteasy.test.BaseResourceTest;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientFactory;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.jboss.resteasy.test.TestPortProvider.generateBaseUrl;

/**
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
public class MainTest extends BaseResourceTest {

    @BeforeClass
    public static void setUp() throws Exception {
        dispatcher.getRegistry().addPerRequestResource(JAXBService.class);
    }

    @Test
    public void testResourceWithJAXB() throws Exception {
        Client client = ClientFactory.newClient();
        WebTarget target = client.target(generateBaseUrl() + "/jaxb");

        XmlResourceWithJAXB resourceWithJAXB = new XmlResourceWithJAXB();
        resourceWithJAXB.setAttr1("XXX");
        resourceWithJAXB.setAttr2("YYY");

        Response response = target.request().post(Entity.json(resourceWithJAXB));
        XmlResourceWithJAXB respObj = response.readEntity(XmlResourceWithJAXB.class);
        Assert.assertEquals("XXX", respObj.getAttr1());
    }

    @Test
    public void testResourceWithJackson() throws Exception {
        Client client = ClientFactory.newClient();
        WebTarget target = client.target(generateBaseUrl() + "/jaxb/json");

        XmlResourceWithJacksonAnnotation resourceWithJAXB = new XmlResourceWithJacksonAnnotation();
        resourceWithJAXB.setAttr1("XXX");
        resourceWithJAXB.setAttr2("YYY");

        Response response = target.request().post(Entity.json(resourceWithJAXB));
        XmlResourceWithJAXB respObj = response.readEntity(XmlResourceWithJAXB.class);
        Assert.assertEquals("XXX", respObj.getAttr1());
    }

}

