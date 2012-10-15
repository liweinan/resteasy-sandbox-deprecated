package net.bluedash.resteasy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringBufferInputStream;
import java.util.List;


/**
 * 10 16 2012
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
@Path("/")
public class EntryResource {

    @GET
    @Path("entry")
    @Produces(MediaType.APPLICATION_XML)
    public AtomAssetMetadata createAssetFromAtom() {
        try {
            Class[] classes = new Class[]{AtomAssetMetadata.class, Entry.class};
            JAXBContext jaxbContext = JAXBContext.newInstance(classes);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            Entry newEntry = (Entry) unmarshaller.unmarshal(new StringBufferInputStream("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><atom:entry xmlns:atom=\"http://www.w3.org/2005/Atom\"><atom:title>testCreatePackageFromAtom1</atom:title><atom:summary>desc for testCreatePackageFromAtom</atom:summary><metadata><categories><value>AssetPackageResourceTestCategory</value></categories><note><value>meta</value></note></metadata></atom:entry>\n"));
            System.out.println("[Server] newEntry.getAnyOther(): " + newEntry.getAnyOther());
            List assetMetadatas = (List) newEntry.getAnyOther();
            System.out.println("[Server] : assetMetadata : " + assetMetadatas.get(0));
            return (AtomAssetMetadata) assetMetadatas.get(0);
        } catch (Exception e) {
            throw new WebApplicationException(e);
        }
    }


    @GET
    @Path("entry2")
    @Produces(MediaType.APPLICATION_XML)
    public AtomAssetMetadata createAssetFromAtom2() {
        try {
            Class[] classes = new Class[]{AtomAssetMetadata.class, Entry.class};
            JAXBContext jaxbContext = JAXBContext.newInstance(classes);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            Entry newEntry = (Entry) unmarshaller.unmarshal(new StringBufferInputStream("<entry xmlns=\"http://www.w3.org/2005/Atom\"><title type=\"text\">testCreatePackageFromAtom1</title><summary type=\"text\">desc for testCreatePackageFromAtom</summary><metadata xmlns=\"\"><categories><value>AssetPackageResourceTestCategory</value></categories></metadata></entry>"));
            System.out.println("[Server] newEntry.getAnyOther(): " + newEntry.getAnyOther());
            List assetMetadatas = (List) newEntry.getAnyOther();
            System.out.println("[Server] : assetMetadata : " + assetMetadatas.get(0));
            return (AtomAssetMetadata) assetMetadatas.get(0);
        } catch (Exception e) {
            throw new WebApplicationException(e);
        }
    }

}
