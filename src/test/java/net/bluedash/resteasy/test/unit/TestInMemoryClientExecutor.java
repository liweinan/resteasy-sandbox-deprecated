package net.bluedash.resteasy.test.unit;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.core.executors.InMemoryClientExecutor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestInMemoryClientExecutor {

    @Test
    public void testHelloWorld() throws Exception {
        InMemoryClientExecutor executor = new InMemoryClientExecutor();
        executor.getDispatcher().getRegistry().addPerRequestResource(HelloWorldServiceImpl.class);
        ClientRequest request = new ClientRequest("/helloworld", executor);
        assertEquals(HelloWorldServiceImpl.HELLO_WORLD, request.getTarget(String.class));
    }
}
