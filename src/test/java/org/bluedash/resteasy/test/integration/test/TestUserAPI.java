package org.bluedash.resteasy.test.integration.test;

import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class TestUserAPI {
    public static final String USER_API = "http://127.0.0.1:8080/try-resteasy/users";

    @Test
    public void testCreateUserAndGetUser() throws IOException {
        URL url = new URL(USER_API);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/xml");
        connection.setDoOutput(true);
        connection.setInstanceFollowRedirects(false);
        connection.setConnectTimeout(1000);

        String userXML = "<user><name>liweinan</name></user>";
        OutputStream os = connection.getOutputStream();
        os.write(userXML.getBytes());
        os.flush();

        assertEquals(HttpURLConnection.HTTP_CREATED,
                connection.getResponseCode());
        connection.disconnect();

    }
}
