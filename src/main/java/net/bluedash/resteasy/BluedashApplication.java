package net.bluedash.resteasy;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * 11 01 2012
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
public class BluedashApplication extends Application {

    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> classes = new HashSet<Class<?>>();

    public BluedashApplication() {
        classes.add(AddImpl.class);
        classes.add(MinusImpl.class);
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
