package resteasy734;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Weinan Li
 * @date 08 06 2012
 */
public class HttpContextTest {
    private static NettyJaxrsServer httpServer;

    @BeforeClass
    public static void before() throws Exception {
        httpServer = new NettyJaxrsServer();
        httpServer.setPort(8081);
        httpServer.setRootResourcePath("");
        httpServer.setSecurityDomain(null);
        ResteasyDeployment deployment = new ResteasyDeployment();
        deployment.getActualResourceClasses().add(SimpleResource.class);
        deployment.getActualResourceClasses().add(AnotherResourceImpl.class);
        httpServer.setDeployment(deployment);
        httpServer.start();

    }

    @AfterClass
    public static void after() throws Exception {
//        httpServer.stop();
    }

    public static String generateURL(String path) {
        return String.format("http://localhost:%d%s", 8081, path);
    }

    @Test
    public void testRESTEasy734() throws Exception {
        // For RESTEasy-734
        {

            {
                ClientRequest request = new ClientRequest(generateURL("/hello"));
                ClientResponse<String> response = request.get(String.class);
                Assert.assertEquals(200, response.getStatus());
                Assert.assertEquals("Hello!", response.getEntity());
            }


        }

    }

}
