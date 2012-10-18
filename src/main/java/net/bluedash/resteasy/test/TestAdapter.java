package net.bluedash.resteasy.test;

import net.bluedash.resteasy.MediaType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 10 18 2012
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
public class TestAdapter {

    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(MediaType.class);


        Map m = new HashMap();

        m.put("1", "One");
        m.put("2", "Two");
        m.put("3", "Three");

        MediaType foo = new MediaType(MediaType.MEDIA_TYPE_WILDCARD, MediaType.MEDIA_TYPE_WILDCARD, null, m);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Output the generated XML:
        marshaller.marshal(foo, System.out);

        // Save the output to a foo.xml
        File xmlFile = new File("foo.xml");
        marshaller.marshal(foo, xmlFile);

        // Restore the Foo class from xml file
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        MediaType createdFoo = (MediaType) unmarshaller.unmarshal(xmlFile);

        // See the result
        System.out.println(createdFoo.getParameters());
    }

}
