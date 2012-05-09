package net.bluedash.resteasy;

import net.bluedash.resteasy.subresources.ShoppingStore;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class BluedashResteasyApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	public BluedashResteasyApplication() {
		classes.add(ShoppingStore.class);
		singletons.add(new UserServlet());
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
