package io.resteasy.test.integration.json;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientFactory;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.resteasy.json.JsonObjectMarshaller;
import io.resteasy.json.JsonObjectUnmarshaller;
import junit.framework.Assert;
import io.resteasy.json.JsonObject;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.util.GenericType;
import org.junit.Test;

/**
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
public class JsonTest {

    @Test
    public void testHello() throws Exception {
        ClientRequest request = new ClientRequest(
                "http://localhost:8088/resteasy-sandbox/resteasy/json/hello");
        ClientResponse<String> response = request.get();
        Assert.assertEquals(200, response.getStatus());
        String resp = response.getEntity(String.class);
        Assert.assertEquals("hello", resp);
    }

    @Test
    public void testList() throws Exception {
        ClientRequest clientRequest = new ClientRequest(
                "http://localhost:8088/resteasy-sandbox/resteasy/json/list");
        clientRequest.accept(MediaType.APPLICATION_JSON);

        List<JsonObject> reqObj = new ArrayList<JsonObject>();
        JsonObject jsonObj = new JsonObject();
        jsonObj.setKey("color");
        jsonObj.setKey("Purple");
        reqObj.add(jsonObj);

        clientRequest.body(MediaType.APPLICATION_JSON, reqObj);
        clientRequest.getProviderFactory().register(JsonObjectUnmarshaller.class);
        clientRequest.getProviderFactory().register(JsonObjectMarshaller.class);

        ClientResponse response = clientRequest.post();
        List resp = (List) response.getEntity(new GenericType<List<JsonObject>>() {
        });
        Assert.assertEquals(resp.get(0).getClass(), JsonObject.class);
    }

    @Test
    public void testBypassJacksonProvider() {
        JsonObject jsonObj = new JsonObject();
        jsonObj.setKey("favorite");
        jsonObj.setValue("Apple");

        Client client = ClientFactory.newClient();
        client.configuration().register(JsonObjectMarshaller.class);
        client.configuration().register(JsonObjectUnmarshaller.class);

        WebTarget target = client.target("http://localhost:8088/resteasy-sandbox/resteasy/json/obj");
        Response response = target.request().post(Entity.json(jsonObj));
        Assert.assertEquals(200, response.getStatus());
        Assert.assertEquals("favorite", response.readEntity(JsonObject.class).getKey());
    }
}
