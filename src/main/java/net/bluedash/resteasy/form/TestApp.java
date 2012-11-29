package net.bluedash.resteasy.form;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;
import org.jboss.resteasy.test.TestPortProvider;

import java.util.HashMap;
import java.util.Map;

/**
 * 11 29 2012
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
public class TestApp {
    public static void main(String args[]) throws Exception {
        final NettyJaxrsServer netty = new NettyJaxrsServer();
        Thread t = new Thread() {
            public void run() {
                ResteasyDeployment deployment = new ResteasyDeployment();
                deployment.getResourceClasses().add(FormMapResource.class.getName());

                netty.setDeployment(deployment);
                netty.setPort(TestPortProvider.getPort());
                netty.setRootResourcePath("");
                netty.setSecurityDomain(null);
                netty.start();
            }
        };
        t.start();

        Thread.sleep(500); // wait for server to start

        FormMapResource client = ProxyFactory.create(FormMapResource.class, "http://127.0.0.1:8081/");
        MyForm form = new MyForm();
        Map<String, Foo> map = new HashMap<String, Foo>();

        Foo foo1 = new Foo();
        foo1.setBar("bar1");

        Foo foo2 = new Foo();
        foo2.setBar("bar2");

        map.put("A", foo1);
        map.put("B", foo2);

        form.setMyMap(map);

        System.out.println(client.processForm(form));
//        netty.stop();
    }

}
