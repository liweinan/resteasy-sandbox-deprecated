package resteasy737;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import resteasy734.HttpContextTest;

import javax.ws.rs.core.Response;

/**
 * @author Weinan Li
 * @date 08 06 2012
 */
public class EncoderTest extends HttpContextTest {
    private static NettyJaxrsServer httpServer;

    @BeforeClass
    public static void before() throws Exception {
        httpServer = new NettyJaxrsServer();
        httpServer.setPort(8081);
        httpServer.setRootResourcePath("");
        httpServer.setSecurityDomain(null);
        ResteasyDeployment deployment = new ResteasyDeployment();
        deployment.getActualResourceClasses().add(Blah.class);
        httpServer.setDeployment(deployment);
        httpServer.start();

    }

    @AfterClass
    public static void after() throws Exception {
        httpServer.stop();
    }


    @Test
    public void test737encoded() throws Exception {
        {
            ClientRequest request = new ClientRequest("http://127.0.0.1:8081/encoded/%20blah;param=A%20B");
            request.get(Response.class);
        }

    }

    @Test
    public void test747plain() throws Exception {
        {
            ClientRequest request = new ClientRequest("http://127.0.0.1:8081/plain/%20blah;param=A%20B");
            request.get(Response.class);
        }

    }

}
