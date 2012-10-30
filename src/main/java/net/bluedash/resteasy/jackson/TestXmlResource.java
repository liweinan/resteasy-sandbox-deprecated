package net.bluedash.resteasy.jackson;

import org.codehaus.jackson.map.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 * 10 30 2012
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
public class TestXmlResource {

    public static void main(String[] args) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(XmlResource.class);

        XmlResource resource = new XmlResource();
        resource.setAttr1("XXX");
        resource.setAttr2("YYY");

        Marshaller marshaller = jaxbContext.createMarshaller();
        System.out.println("# JAXB:");
        marshaller.marshal(resource, System.out);

        ObjectMapper mapper = new ObjectMapper();
        System.out.println("\n\n# JACKSON:");
        mapper.writeValue(System.out, resource);

    }
}
