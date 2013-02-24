package io.resteasy.test.integration.json;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import junit.framework.Assert;
import io.resteasy.json.JsonObject;
import io.resteasy.json.JsonObjectArrayMarshaller;
import io.resteasy.json.JsonObjectArrayUnmarshaller;

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
        clientRequest.getProviderFactory().register(JsonObjectArrayUnmarshaller.class);
        clientRequest.getProviderFactory().register(JsonObjectArrayMarshaller.class);
		
		ClientResponse response = clientRequest.post();
		List resp = (List) response.getEntity(new GenericType<List<JsonObject>>() {});
        Assert.assertEquals(resp.get(0).getClass(), JsonObject.class);
	}
}
