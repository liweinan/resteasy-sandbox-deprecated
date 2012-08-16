package net.bluedash.resteasy.test.snippets;

import net.bluedash.resteasy.IllegalArgumentExceptionMapper;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Weinan Li
 * @date 08 09 2012
 */
public class SmokeTest {
    private static NettyJaxrsServer httpServer;

    @Before
    public static void before() throws Exception {
        httpServer = new NettyJaxrsServer();
        httpServer.setPort(9090);
        httpServer.setRootResourcePath("/");
        httpServer.setSecurityDomain(null);
        ResteasyDeployment deployment = new ResteasyDeployment();
        deployment.getActualResourceClasses().add(FormResource.class);
        deployment.getProviderFactory().addExceptionMapper(IllegalArgumentExceptionMapper.class);
        httpServer.setDeployment(deployment);
        httpServer.start();
    }

    @After
    public static void after() throws Exception {
        httpServer.stop();
    }

    @Test
    public void test1() throws Exception {
        Thread.sleep(10000000);
        ClientRequest request = new
                ClientRequest("http://localhost:9090/RESTEASY-737/decoded/form?f=bee bop");
        ClientResponse<String> response = request.get(String.class);
        System.out.println("Received encoded form param [get]: " + response.getEntity());

    }

    @Test
    public void testException() throws Exception {
        ClientRequest request = new ClientRequest("http://localhost:9090/exception");
        ClientResponse response = request.get();
        System.out.println(response.getStatus());
    }
}
