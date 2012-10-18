package net.bluedash.resteasy;

import xyz.org.AtomAssetMetadata;

import javax.ws.rs.*;
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
            AtomAssetMetadata assetMetadata = (AtomAssetMetadata) assetMetadatas.get(0);
            System.out.println("[Server] : assetMetadata : " + assetMetadata);
            System.out.println("[Server] : categories : " +
                    assetMetadata.getCategories());
            return assetMetadata;
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

    @GET
    @Path("entry3")
    @Produces(MediaType.APPLICATION_XML)
    public AtomAssetMetadata createAssetFromAtom3() {
        try {
            Class[] classes = new Class[]{AtomAssetMetadata.class, Entry.class};
            JAXBContext jaxbContext = JAXBContext.newInstance(classes);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            Entry newEntry = (Entry) unmarshaller.unmarshal(new StringBufferInputStream("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><atom:entry xmlns:atom=\"http://www.w3.org/2005/Atom\"><atom:title>testCreatePackageFromAtom1</atom:title><atom:summary>desc for testCreatePackageFromAtom</atom:summary><metadata><categories><value>AssetPackageResourceTestCategory</value></categories><note><value>meta</value></note></metadata></atom:entry>\n"));
            System.out.println("[Server] newEntry.getAnyOtherJAXBObject(AtomAssetMetadata.class): " + newEntry.getAnyOtherJAXBObject(AtomAssetMetadata.class));
            return newEntry.getAnyOtherJAXBObject(AtomAssetMetadata.class);
        } catch (Exception e) {
            throw new WebApplicationException(e);
        }

    }

    @GET
    @Path("entry4")
    @Produces(MediaType.APPLICATION_XML)
    public AtomAssetMetadata createAssetFromAtom4() {
        try {
            Class[] classes = new Class[]{AtomAssetMetadata.class, Entry.class};
            JAXBContext jaxbContext = JAXBContext.newInstance(classes);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            Entry newEntry = (Entry) unmarshaller.unmarshal(new StringBufferInputStream("<entry xmlns=\"http://www.w3.org/2005/Atom\"><title type=\"text\">testCreatePackageFromAtom1</title><summary type=\"text\">desc for testCreatePackageFromAtom</summary><metadata xmlns=\"\"><categories><value>AssetPackageResourceTestCategory</value></categories></metadata></entry>"));
            System.out.println("[Server] newEntry.getAnyOtherJAXBObject(AtomAssetMetadata.class): " + newEntry.getAnyOtherJAXBObject(AtomAssetMetadata.class));
            return newEntry.getAnyOtherJAXBObject(AtomAssetMetadata.class);
        } catch (Exception e) {
            throw new WebApplicationException(e);
        }


    }


    @POST
    @Path("entry5")
    @Consumes(MediaType.APPLICATION_ATOM_XML)
    @Produces(MediaType.APPLICATION_ATOM_XML)
    public AtomAssetMetadata createAssetFromAtom5(Entry entry) {
        try {
            String[] categories = null;
            AtomAssetMetadata assetMetadata = entry.getAnyOtherJAXBObject(AtomAssetMetadata.class);
            categories = assetMetadata.getCategories();
            System.out.println(assetMetadata);
            System.out.println(categories);
            return assetMetadata;
        } catch (Exception e) {
            throw new WebApplicationException(e);
        }
    }

}

