package net.bluedash.resteasy.subresources;

import org.drools.guvnor.server.jaxrs.providers.atom.Entry;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/store")
public class ShoppingStore {

    private UriInfo ui;
    private String i;
    private String str;
//    public ShoppingStore() {
//
//    }


//    public ShoppingStore(@HeaderParam("str") String str, @PathParam("p") String i) {
//        this.ui = ui;
//        this.i = i;
//    }

    public ShoppingStore(@Context UriInfo ui, @QueryParam("p") String str) {
        this.ui = ui;
        this.str = str;

    }
//
//     public ShoppingStore(@HeaderParam("str") String str, @HeaderParam("str") String str1, @PathParam("p") String i) {
//        this.ui = ui;
//        this.i = i;
//    }

    @Path("/customers/{id}")
    public Customer getCustomer(@PathParam("id") int id) {
        Customer cust = new Customer("Tom", "Example Street.");
        return cust;
    }

    @GET
    @Path("/exception")
    public String throwException() throws IllegalArgumentException {
        throw new IllegalArgumentException();
    }

//    @Path("/p1")
//    @GET
//    private String privateMethod1() {
//        return "p1";
//    }
//
//    @Path("/p2")
//    @GET
//    public String privateMethod2() {
//        return "p2";
//    }

    @POST
    @Path("/entry")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Entry createAssetFromAtom(Entry entry) {
        try {
            return entry;
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e);
        }
    }


}

