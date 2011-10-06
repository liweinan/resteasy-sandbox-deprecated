package net.bluedash.resteasy.subresources;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/store")
public class ShoppingStore {

   @Path("/customers/{id}")
   public Customer getCustomer(@PathParam("id") int id) {
      Customer cust = new Customer("Tom", "Example Street.");
      return cust;
   }
}

