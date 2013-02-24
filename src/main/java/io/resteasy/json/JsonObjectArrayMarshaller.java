package io.resteasy.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;


// resteasy-jackson-provider must be excluded from dependency for this to work
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JsonObjectArrayMarshaller implements MessageBodyWriter {

    @Override
    public long getSize(Object target, Class type, Type genericType,
                        Annotation[] annotations, MediaType mediaType) {
        return -1; //let container calculate it for us
    }

    @Override
    public boolean isWriteable(Class clazz, Type type,
                               Annotation[] annotations, MediaType mediaType) {
        for (Class intf : clazz.getInterfaces()) {
            if (Collection.class.isAssignableFrom(intf)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void writeTo(Object target, Class type, Type genericType,
                        Annotation[] annotations, MediaType mediaType,
                        MultivaluedMap httpHeaders, OutputStream out) throws IOException,
            WebApplicationException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out, target);

        StringOutputStream out2 = new StringOutputStream();
        mapper.writeValue(out2, target);
    }
}
