package net.bluedash.resteasy.jackson;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/**
 * 10 30 2012
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
public class TestXmlResource {

    public static void main(String[] args) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(XmlResourceWithJAXB.class);

        XmlResourceWithJAXB resourceWithJAXB = new XmlResourceWithJAXB();
        resourceWithJAXB.setAttr1("XXX");
        resourceWithJAXB.setAttr2("YYY");

        {
            Marshaller marshaller = jaxbContext.createMarshaller();
            System.out.println("# JAXB:");
            marshaller.marshal(resourceWithJAXB, System.out);
        }

        {
            System.out.println("\n\n# JACKSON:");
            ObjectMapper mapper = new ObjectMapper();
            OutputStream outputStream = new ByteArrayOutputStream();
            mapper.writeValue(outputStream, resourceWithJAXB);
            System.out.print(outputStream.toString());
        }

        {
            System.out.println("\n\n# JACKSON JAXB:");
            ObjectMapper mapper = new ObjectMapper();
            mapper.setAnnotationIntrospector(new JaxbAnnotationIntrospector());
            OutputStream outputStream = new ByteArrayOutputStream();
            mapper.writeValue(outputStream, resourceWithJAXB);
            System.out.print(outputStream.toString());
        }


        XmlResourceWithoutJAXB resourceWithoutJAXB = new XmlResourceWithoutJAXB();
        resourceWithoutJAXB.setAttr1("XXX");
        resourceWithoutJAXB.setAttr2("YYY");

        {
            System.out.println("\n\n# JACKSON without JAXB:");
            ObjectMapper mapper = new ObjectMapper();
            mapper.setAnnotationIntrospector(new JaxbAnnotationIntrospector());
            OutputStream outputStream = new ByteArrayOutputStream();
            mapper.writeValue(outputStream, resourceWithoutJAXB);
            System.out.print(outputStream.toString());
        }

        {
            System.out.println("\n\n# JACKSON JAXB without JAXB:");
            ObjectMapper mapper = new ObjectMapper();
            mapper.setAnnotationIntrospector(new JaxbAnnotationIntrospector());
            OutputStream outputStream = new ByteArrayOutputStream();
            mapper.writeValue(outputStream, resourceWithoutJAXB);
            System.out.print(outputStream.toString());
        }

    }
}
