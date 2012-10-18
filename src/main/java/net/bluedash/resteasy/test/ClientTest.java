package net.bluedash.resteasy.test;

import javax.ws.rs.core.MediaType;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 10 18 2012
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
public class ClientTest {

    public void test(URL baseURL) throws Exception {
        /*        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"+
            "<atom:entry xmlns:atom=\"http://www.w3.org/2005/Atom\">"+
            "<atom:title>testCreatePackageFromAtom12</atom:title>" +
            "<atom:summary>desc for testCreatePackageFromAtom</atom:summary>"+
            "<metadata><categories><value>c1</value></categories> <note><value>meta</value> </note></metadata>"+
        "</atom:entry>";*/
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<entry xmlns=\"http://www.w3.org/2005/Atom\">" +
                "<title>testCreatePackageFromAtom7</title>" +
                "<summary>desc for testCreatePackageFromAtom</summary>" +
                "<metadata xmlns=\"\"><categories><value>c1</value></categories> <note><value>meta</value> </note></metadata>" +
                "</entry>";
        URL url = new URL(baseURL, "resteasy/entry5");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Accept", MediaType.APPLICATION_ATOM_XML);
        connection.setRequestProperty("Content-Type", MediaType.APPLICATION_ATOM_XML);
        connection.setRequestProperty("Content-Length", Integer.toString(xml.getBytes().length));
        connection.setUseCaches(false);
        connection.setDoInput(true);
        connection.setDoOutput(true);

        //Send request
        DataOutputStream wr = new DataOutputStream(
                connection.getOutputStream());
        wr.writeBytes(xml);
        wr.flush();
        wr.close();

        System.out.println(connection.getResponseCode());

    }

    public static void main(String[] args) throws Exception {
        ClientTest client = new ClientTest();
        client.test(new URL("http://localhost:8080/try-resteasy/"));

    }


}
