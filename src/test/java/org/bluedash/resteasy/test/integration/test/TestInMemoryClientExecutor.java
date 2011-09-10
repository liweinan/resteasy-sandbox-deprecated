package org.bluedash.resteasy.test.integration.test;

import junit.framework.Assert;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.core.executors.InMemoryClientExecutor;
import org.junit.Test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

public class TestInMemoryClientExecutor {

    public static final String HELLO_WORLD = "Hello, world!";
    @Path("/helloworld")
    public static class HelloWorldService {

        @GET
        @Produces("text/plain")
        public String printHelloWorld() {
            return HELLO_WORLD;
        }
    }

    @Test
    public void testHelloWorld() {
        InMemoryClientExecutor executor = new InMemoryClientExecutor();
        executor.getDispatcher().getRegistry().addPerRequestResource(HelloWorldService.class);
        ClientRequest request = new ClientRequest("/helloworld", executor);
        try {
            Assert.assertEquals(HELLO_WORLD, request.getTarget(String.class));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
