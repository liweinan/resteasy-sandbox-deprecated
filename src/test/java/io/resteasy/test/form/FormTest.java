package io.resteasy.test.form;

import io.resteasy.form.FormResource;
import junit.framework.Assert;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.test.BaseResourceTest;
import org.jboss.resteasy.test.TestPortProvider;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Multiple testings for RESTEASY-796
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
public class FormTest extends BaseResourceTest {

    @Before
    public void setUp() throws Exception {
        addPerRequestResource(FormResource.class);
    }

    @Test
    public void raw() throws Exception {

        HttpClient httpclient = new DefaultHttpClient();
        HttpPost post = new HttpPost(TestPortProvider.generateURL("/form/multipart"));

        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("param1", "value1"));
        formparams.add(new BasicNameValuePair("param2", "value2"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
        post.setEntity(entity);

        HttpResponse response = httpclient.execute(post);
        HttpEntity resp = response.getEntity();
        if (resp != null) {
            InputStream inputStream = resp.getContent();
            try {
                StringWriter writer = new StringWriter();
                copy(inputStream, writer);
                Assert.assertEquals("value1value2", writer.toString());
            } finally {
                inputStream.close();
            }
        }
    }

    @Test
    public void fluent() throws Exception {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8081/form/multipart");
        Form form = new Form().param("param1", "value1")
                .param("param2", "value2");
        Response resp = target.request().post(Entity.form(form));
        Assert.assertEquals("value1value2", resp.readEntity(String.class));
    }

    public static void copy(InputStream input, Writer output) throws IOException {
        InputStreamReader in = new InputStreamReader(input);
        char[] buffer = new char[100];
        int n;
        while (-1 != (n = in.read(buffer))) {
            output.write(buffer, 0, n);
        }
    }
}