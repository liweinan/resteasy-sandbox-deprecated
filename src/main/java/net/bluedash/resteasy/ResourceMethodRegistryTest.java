package net.bluedash.resteasy;

import org.jboss.resteasy.core.ResourceInvoker;
import org.jboss.resteasy.core.ResourceMethod;
import org.jboss.resteasy.core.ResourceMethodRegistry;
import org.jboss.resteasy.jsapi.ServiceRegistry;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import java.util.List;
import java.util.Map;

/**
 * 11 01 2012
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
public class ResourceMethodRegistryTest {

    public static void main(String[] args) {

        ResteasyProviderFactory factory = ResteasyProviderFactory.getInstance();

        ResourceMethodRegistry registry = new ResourceMethodRegistry(factory);

        registry.addPerRequestResource(AddImpl.class);
        registry.addPerRequestResource(MinusImpl.class);

        ServiceRegistry jsRegistry = new ServiceRegistry(null, registry, factory, null);

        for (Map.Entry<String, List<ResourceInvoker>> entry : registry.getRoot()
                .getBounded().entrySet()) {
            List<ResourceInvoker> invokers = entry.getValue();
            for (ResourceInvoker invoker : invokers)
                if (invoker instanceof ResourceMethod) {
                    ResourceMethod method = (ResourceMethod) invoker;
                    System.out.println(method.getResourceClass());
                    System.out.println(method.getMethod());

                }

        }

    }
}
