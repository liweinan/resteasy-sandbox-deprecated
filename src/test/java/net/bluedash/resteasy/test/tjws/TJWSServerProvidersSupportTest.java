package net.bluedash.resteasy.test.tjws;

import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.server.tjws.TJWSEmbeddedJaxrsServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.HttpURLConnection;

/**
 * @author Weinan Li
 * @created_at 08 14 2012
 */
public class TJWSServerProvidersSupportTest {

    @XmlRootElement
    public class Customer {

        @XmlElement
        private String name;

        public Customer(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Path("/customers")
    @Produces("application/xml")
    public class MyService {

        @GET
        @Path("/{name}")
        public Response getCustomer(@PathParam("name") String name) {
            return Response.ok(new Customer(name)).build();
        }
    }

    private TJWSEmbeddedJaxrsServer tjws;

    @Before
    public void setup() {
        tjws = new TJWSEmbeddedJaxrsServer();
        tjws.setPort(8081);
        tjws.setRootResourcePath("/");
        tjws.start();
        tjws.getDeployment().getDispatcher().getRegistry().addSingletonResource(new MyService());
    }

    @Test
    public void test1() throws Exception {
//        RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
        MyService proxy = ProxyFactory.create(MyService.class, "http://127.0.0.1:8081");
        ClientResponse<?> response = (ClientResponse<?>) proxy.getCustomer("xx");
        Assert.assertEquals(response.getStatus(), HttpURLConnection.HTTP_OK);
        Customer cred = response.getEntity(Customer.class);

    }

    @After
    public void down() {
        tjws.stop();
    }
}
