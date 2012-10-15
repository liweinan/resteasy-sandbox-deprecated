package net.bluedash.resteasy;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class BluedashResteasyApplication extends Application {
    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> classes = new HashSet<Class<?>>();

    public BluedashResteasyApplication() {
        classes.add(EntryResource.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
