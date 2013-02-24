package net.bluedash.resteasy.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

// resteasy-jackson-provider must be excluded from dependency for this to work
@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class JsonObjectArrayUnmarshaller implements MessageBodyReader {

    @Override
    public boolean isReadable(Class type, Type genericType,
                              Annotation[] annotations, MediaType mediayType) {
        for (Class intf : type.getInterfaces()) {
            if (Collection.class.isAssignableFrom(intf)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object readFrom(Class type, Type genericType,
                           Annotation[] annotations, MediaType mediaType,
                           MultivaluedMap httpHeaders, InputStream in) throws IOException,
            WebApplicationException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(in,
                new TypeReference<List<JsonObject>>() {
                });
    }

}
