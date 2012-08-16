package net.bluedash.resteasy.test.resteasy465;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.plugins.server.tjws.TJWSEmbeddedJaxrsServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static junit.framework.Assert.assertEquals;

/**
 * @author Weinan Li
 * @created_at 08 15 2012
 */
public class RESTEasy465Test {

    private TJWSEmbeddedJaxrsServer tjws;

    @Before
    public void setup() {
        tjws = new TJWSEmbeddedJaxrsServer();
        tjws.setPort(8081);
        tjws.setRootResourcePath("/");
        tjws.start();
        tjws.getDeployment().getDispatcher().getRegistry().addSingletonResource(new EncodingResource());
    }

    @After
    public void down() {
        tjws.stop();
    }

    @Test
    public void testIt() throws Exception {
        ClientRequest request = new
                ClientRequest("http://localhost:8081/hello");
        ClientResponse<String> response = request.get(String.class);
        System.out.println(response.getEntity());
        assertEquals("你好！", new String(response.getEntity().getBytes("UTF-8")));
        String resp = response.getEntity();

    }

    @Path("/")
    public class EncodingResource {

        @GET
        @Path("/hello")
        @Produces("text/html;charset=UTF-8")
        public String hello() {
            return "你好！";
        }
    }

}
