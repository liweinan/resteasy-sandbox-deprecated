package org.bluedash.resteasy;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class BluedashResteasyApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	public BluedashResteasyApplication() {
		// classes.add(UserServlet.class);
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
