package net.bluedash.resteasy.test.unit;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyDeployment;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.jboss.resteasy.test.TJWSServletContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class TestTJWSServletContainer {
    private static Class bootstrap;

    @BeforeClass
    public static void setUp() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        bootstrap = TJWSServletContainer.class;
        Method start = bootstrap.getMethod("start", String.class);
        ResteasyDeployment deployment = (ResteasyDeployment) start.invoke(null, "/");
        deployment.getRegistry().addPerRequestResource(HelloWorldServiceImpl.class);
    }

    @AfterClass
    public static void stop() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method stop = bootstrap.getMethod("stop");
        stop.invoke(null);
    }


    @Test
    public void testIt() throws Exception {
        RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
        HelloWorldService client = ProxyFactory.create(HelloWorldService.class, "http://127.0.0.1:8081");
        assertEquals("Hello, world!", client.printHelloWorld());

    }



}
