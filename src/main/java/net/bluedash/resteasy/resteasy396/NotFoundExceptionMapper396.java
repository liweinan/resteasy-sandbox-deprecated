package net.bluedash.resteasy.resteasy396;

import org.apache.http.HttpStatus;
import org.jboss.resteasy.logging.Logger;
import com.restfully.shop.services.NotFoundException;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper396 implements ExceptionMapper<NotFoundException> {
    private static final Logger LOG = Logger.getLogger(NotFoundExceptionMapper396.class);

    @Context
    HttpHeaders httpHeaders;

    @Override
    public Response toResponse(final NotFoundException exception) {
        System.out.printf("***mediaType: %s\n", httpHeaders.getMediaType());
        return Response.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).type(httpHeaders.getMediaType().toString()).build();
    }
}
