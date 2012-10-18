package net.bluedash.resteasy.test;

import net.bluedash.resteasy.Content;
import net.bluedash.resteasy.Entry;
import net.bluedash.resteasy.Person;
import xyz.org.AtomAssetMetadata;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URI;
import java.util.Date;

/**
 * 10 18 2012
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
public class TestComplex {

    public static void main(String args[]) throws Exception {

        URI baseUri = new URI("resteasy-test");

        Entry entry = new Entry();
        entry.setTitle("testtitle");
        entry.setSummary("testdesc");
        entry.setPublished(new Date());
        entry.getAuthors().add(new Person("testperson"));
        entry.setId(baseUri);

        AtomAssetMetadata atomAssetMetadata = entry.getAnyOtherJAXBObject(AtomAssetMetadata.class);
        if (atomAssetMetadata == null) {
            atomAssetMetadata = new AtomAssetMetadata();
        }
        atomAssetMetadata.setArchived(false);
        atomAssetMetadata.setUuid("testuuid");

        entry.setAnyOtherJAXBObject(atomAssetMetadata);

        Content content = new Content();
        content.setSrc(UriBuilder.fromUri(baseUri).path("binary").build());
        content.setType(MediaType.APPLICATION_OCTET_STREAM_TYPE);
        entry.setContent(content);


        Class[] classes = new Class[]{AtomAssetMetadata.class, Entry.class};
        JAXBContext jaxbContext = JAXBContext.newInstance(classes);


        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Output the generated XML:
        marshaller.marshal(entry, System.out);

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
        marshaller.marshal(entry, System.out);


        Writer xmlWriter = new StringWriter();
        marshaller.marshal(entry, xmlWriter);
        String xmlOut = xmlWriter.toString();


        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader xmlReader = new StringReader(xmlOut);

        Entry newEntry = (Entry) unmarshaller.unmarshal(xmlReader);
        System.out.println("[Server] newEntry.getAnyOther(): " + newEntry.getAnyOther());
        System.out.println("[Server] newEntry.getAnyOtherJAXBObject(): " + newEntry.getAnyOtherJAXBObject(AtomAssetMetadata.class));


    }

}
