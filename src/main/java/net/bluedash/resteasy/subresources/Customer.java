package net.bluedash.resteasy.subresources;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

public class Customer {

	private String name;
	private String address;
	
	public Customer(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	@GET
    @PUT
	public String get() {
		return name;
	}

	@GET
    @PUT
	@Path("/address")
	public String getAddress() {
		return address;
	}

    @GET
    @Path("/ggg")
    private void ggg() {

    }

}
