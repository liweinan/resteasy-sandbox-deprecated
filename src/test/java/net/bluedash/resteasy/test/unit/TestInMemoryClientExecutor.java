package net.bluedash.resteasy.test.unit;

import junit.framework.Assert;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.core.executors.InMemoryClientExecutor;
import org.junit.Test;

public class TestInMemoryClientExecutor {

    @Test
    public void testHelloWorld() {
        InMemoryClientExecutor executor = new InMemoryClientExecutor();
        executor.getDispatcher().getRegistry().addPerRequestResource(HelloWorldService.class);
        ClientRequest request = new ClientRequest("/helloworld", executor);
        try {
            Assert.assertEquals(HelloWorldService.HELLO_WORLD, request.getTarget(String.class));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
