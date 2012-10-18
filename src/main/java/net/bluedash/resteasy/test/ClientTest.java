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

    public void test2(URL baseURL) throws Exception {
        /*        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"+
            "<atom:entry xmlns:atom=\"http://www.w3.org/2005/Atom\">"+
            "<atom:title>testCreatePackageFromAtom12</atom:title>" +
            "<atom:summary>desc for testCreatePackageFromAtom</atom:summary>"+
            "<metadata><categories><value>c1</value></categories> <note><value>meta</value> </note></metadata>"+
        "</atom:entry>";*/
        String xml1 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><ns2:entry xmlns:ns2=\"http://www.w3.org/2005/Atom\"><ns2:title>testtitle</ns2:title><ns2:id>resteasy-test</ns2:id><ns2:published>2012-10-18T17:03:02.083+08:00</ns2:published><ns2:author><name>testperson</name></ns2:author><content type=\"application/octet-stream\" src=\"resteasy-test/binary\"/><ns2:summary>testdesc</ns2:summary><metadata><uuid><value>testuuid</value></uuid><archived><value>false</value></archived></metadata></ns2:entry>[Server] newEntry.getAnyOther(): [AtomAssetMetadata{uuid=net.bluedash.resteasy.Uuid@45490eb5, categories=null, note=null, created=null, format=null, disabled=null, state=null, versionNumber=null, checkinComment=null, archived=net.bluedash.resteasy.Archived@3f64b09c}]\n";

        String xml2 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<entry xmlns=\"http://www.w3.org/2005/Atom\">" +
                "<title>testCreatePackageFromAtom7</title>" +
                "<summary>desc for testCreatePackageFromAtom</summary>" +
                "<metadata xmlns=\"\"><categories><value>c1</value></categories> <note><value>meta</value> </note></metadata>" +
                "</entry>";
        URL url = new URL(baseURL, "resteasy/entry6");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Accept", MediaType.APPLICATION_ATOM_XML);
        connection.setRequestProperty("Content-Type", MediaType.APPLICATION_ATOM_XML);
        connection.setRequestProperty("Content-Length", Integer.toString(xml2.getBytes().length));
        connection.setUseCaches(false);
        connection.setDoInput(true);
        connection.setDoOutput(true);

        //Send request
        DataOutputStream wr = new DataOutputStream(
                connection.getOutputStream());
        wr.writeBytes(xml2);
        wr.flush();
        wr.close();

        System.out.println(connection.getResponseCode());

    }


    public static void main(String[] args) throws Exception {
        ClientTest client = new ClientTest();
//        client.test(new URL("http://localhost:8080/try-resteasy/"));
        client.test2(new URL("http://localhost:8080/try-resteasy/"));
    }


}
