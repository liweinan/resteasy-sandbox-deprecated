package net.bluedash.resteasy;

import org.jboss.resteasy.annotations.GZIP;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * 10 02 2012
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
@Path("cached")
public class CachedResource {

    @GET
    @GZIP
    public Response get(@Context HttpServletRequest servletRequest, @Context Request request) throws Exception {

        File f = new File("/tmp/resteasy-test.txt");

        Date lastModified = new Date(f.lastModified());

        System.out.println("***If-Modified-Since: " + servletRequest.getHeader("If-Modified-Since"));
        System.out.println("***Last Modified: " + lastModified);

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        String content = reader.readLine();
        reader.close();

        System.out.println("***Content hash: " + Math.abs(content.hashCode()));
        EntityTag tag = new EntityTag(Integer.toString(Math.abs(content.hashCode())));

        Response.ResponseBuilder builder = request.evaluatePreconditions(lastModified, tag);

        System.out.println("***evaluatePreconditions: " + builder);

        if (builder != null) {
            return builder.build();
        } else {
            builder = Response.ok(content, MediaType.TEXT_PLAIN);
            builder.lastModified(lastModified);
            builder.tag(tag);
            return builder.build();
        }
    }
}
