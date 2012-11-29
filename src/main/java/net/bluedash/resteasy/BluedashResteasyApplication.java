package net.bluedash.resteasy;

import net.bluedash.resteasy.form.FormMapResource;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class BluedashResteasyApplication extends Application {
    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> classes = new HashSet<Class<?>>();

    public BluedashResteasyApplication() {
        classes.add(EntryResource.class);
        classes.add(FormMapResource.class);
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
