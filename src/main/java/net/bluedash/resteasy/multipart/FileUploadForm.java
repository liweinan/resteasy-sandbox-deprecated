package net.bluedash.resteasy.multipart;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

/**
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
public class FileUploadForm {
    @FormParam("file")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    private byte[] data;

    @FormParam("user")
    @PartType(MediaType.TEXT_PLAIN)
    private String user;

    @FormParam("password")
    @PartType(MediaType.TEXT_PLAIN)
    private String password;

    @FormParam("filename")
    @PartType(MediaType.TEXT_PLAIN)
    private String filename;

    public FileUploadForm() {
    }

    public byte[] getData() {
        return data;
    }

    public void setData(final byte[] data) {
        this.data = data;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }



}
