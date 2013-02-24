package net.bluedash.resteasy.test;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import junit.framework.Assert;
import net.bluedash.resteasy.json.JsonObject;
import net.bluedash.resteasy.json.JsonObjectArrayMarshaller;
import net.bluedash.resteasy.json.JsonObjectArrayUnmarshaller;

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
				"http://localhost:8088/try-resteasy/resteasy/json/hello");
		ClientResponse<String> response = request.get();
		Assert.assertEquals(response.getStatus(), 200);
		String resp = response.getEntity(String.class);
		Assert.assertEquals("hello", resp);
	}

	@Test
	public void testList() throws Exception {
		ClientRequest clientRequest = new ClientRequest(
				"http://localhost:8088/try-resteasy/resteasy/json/list");
		clientRequest.accept(MediaType.APPLICATION_JSON);

		List<JsonObject> reqObj = new ArrayList<JsonObject>();
        JsonObject jsonObj = new JsonObject();
        jsonObj.setKey("color");
        jsonObj.setKey("Purple");
        reqObj.add(jsonObj);

		clientRequest.body(MediaType.APPLICATION_JSON, reqObj);
		clientRequest.getProviderFactory().addMessageBodyReader(JsonObjectArrayUnmarshaller.class);
		clientRequest.getProviderFactory().addMessageBodyWriter(JsonObjectArrayMarshaller.class);
		
		ClientResponse response = clientRequest.post();
		List resp = (List) response.getEntity(new GenericType<List<JsonObject>>() {});
        Assert.assertEquals(resp.get(0).getClass(), JsonObject.class);
	}
}
