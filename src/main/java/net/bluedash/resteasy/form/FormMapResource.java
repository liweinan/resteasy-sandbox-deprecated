package net.bluedash.resteasy.form;

import org.jboss.resteasy.annotations.Form;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * 11 29 2012
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
@Path("/form/map")
public class FormMapResource {

    @POST
    public String processForm(@Form MyForm myForm) {
        return myForm.getMyMap().toString();
    }

//    weli@power:~$ http -f POST http://127.0.0.1:8080/try-resteasy/resteasy/form/map myMap[A]=1
//    HTTP/1.1 200 OK
//    Content-Length: 43
//    Content-Type: */*
//    Server: Jetty(6.1.15)
//
//    {A=net.bluedash.resteasy.form.Foo@49020230}
    @GET
    public String get() {
        return "ok";
    }
}
