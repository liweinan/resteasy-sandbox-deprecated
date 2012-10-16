package net.bluedash.resteasy.test;

import net.bluedash.resteasy.AtomAssetMetadata;
import net.bluedash.resteasy.Entry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringBufferInputStream;

/**
 * 10 17 2012
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
public class TestJAXB {

    public static void main(String[] args) throws Exception {
        Class[] classes = new Class[]{AtomAssetMetadata.class, Entry.class};
        JAXBContext jaxbContext = JAXBContext.newInstance(classes);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        Entry newEntry = (Entry) unmarshaller.unmarshal(new StringBufferInputStream("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><atom:entry xmlns:atom=\"http://www.w3.org/2005/Atom\"><atom:title>testCreatePackageFromAtom1</atom:title><atom:summary>desc for testCreatePackageFromAtom</atom:summary><metadata><categories><value>AssetPackageResourceTestCategory</value></categories><note><value>meta</value></note></metadata></atom:entry>\n"));
        System.out.println("[Server] newEntry.getAnyOther(): " + newEntry.getAnyOther());
        System.out.println("[Server] newEntry.getAnyOtherJAXBObject(): " + newEntry.getAnyOtherJAXBObject(AtomAssetMetadata.class));

    }
}
