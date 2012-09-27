package net.bluedash.resteasy.test.tjws;

import org.drools.guvnor.server.jaxrs.providers.atom.Entry;
import org.junit.Test;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 09 27 2012
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
public class GunvorResourceTest {

    @Path("/")
    public static class GuvnorAtomResource {

        @GET
        @Path("/entry")
        @Consumes("application/xml")
        @Produces("application/xml")
        public Response createAssetFromAtom(Entry entry) {
            try {
                return Response.ok(entry).build();
            } catch (Exception e) {
                e.printStackTrace();
                throw new WebApplicationException(e);
            }
        }

    }

    @Test
    public void test() throws Exception {
        String entryVal = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><atom:entry xmlns:atom=\"http://www.w3.org/2005/Atom\"><atom:title>testCreatePackageFromAtom1</atom:title><atom:summary>desc for testCreatePackageFromAtom</atom:summary></atom:entry>\n";

        URL postUrl = new URL("http://127.0.0.1:8080/try-resteasy/store/entry");
        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
        connection.setDoOutput(true);
        connection.setInstanceFollowRedirects(false);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/xml");
        OutputStream os = connection.getOutputStream();

        os.write(entryVal.getBytes());
        os.flush();

        BufferedReader reader = new BufferedReader(new
                InputStreamReader(connection.getInputStream()));

        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }

        connection.disconnect();


    }


}
