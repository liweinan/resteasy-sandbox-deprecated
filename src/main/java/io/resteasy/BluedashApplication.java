package io.resteasy;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import io.resteasy.json.JsonResource;

/**
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
public class BluedashApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(JsonResource.class);
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return super.getSingletons();
	}
	
}
