package net.bluedash.resteasy.netty;

import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;
import org.jboss.resteasy.test.TestPortProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

public class PlayNettyServer {

    @Path("/")
    public static class HelloResource {

        @GET
        @Path("hello")
        public String sayHello() {
            return "Hello";
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        NettyJaxrsServer netty = new NettyJaxrsServer();
        ResteasyDeployment deployment = new ResteasyDeployment();
//		deployment.getActualProviderClasses().add(HelloResource.class);
//        deployment.setResourceClasses(Collections.singletonList(HelloResource.class.getName()));
        deployment.getResourceClasses().add(HelloResource.class.getName());

        netty.setDeployment(deployment);
        netty.setPort(TestPortProvider.getPort());
        netty.setRootResourcePath("");
        netty.setSecurityDomain(null);
        netty.start();

        Thread.sleep(1000);

        try {
            netty.stop();
        } catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class))
                System.out.println("caught");
        }

    }

}
