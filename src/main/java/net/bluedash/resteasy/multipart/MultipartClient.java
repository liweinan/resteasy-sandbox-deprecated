package net.bluedash.resteasy.multipart;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.*;

/**
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
public class MultipartClient {

    public static void main(String[] args) throws Exception {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPut put = new HttpPut("http://localhost:8080/try-resteasy/multi/upload");


        FileBody file = new FileBody(new File("/tmp/in.txt"));
        StringBody user = new StringBody("Bob");

        MultipartEntity request = new MultipartEntity();
        request.addPart("user", user);
        request.addPart("file", file);


        put.setEntity(request);

        HttpResponse response = httpclient.execute(put);
        HttpEntity resp = response.getEntity();
        if (resp != null) {
            InputStream inputStream = resp.getContent();
            try {
                StringWriter writer = new StringWriter();
                copy(inputStream, writer);
                System.out.println(writer.toString());
            } finally {
                inputStream.close();
            }
        }

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
