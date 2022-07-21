import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.*;

import java.io.IOException;

import static org.apache.http.entity.ContentType.getOrDefault;
import static org.testng.Assert.assertEquals;

public class WebServiceTestWithSetup {
    CloseableHttpClient client;
    CloseableHttpResponse response;

    @BeforeClass
    public void setup() throws IOException {
        System.out.println("Runs once per class");
        client = HttpClientBuilder.create().build();
        response = client.execute(new HttpGet("https://api.github.com/"));
    }

    @BeforeMethod
    public void setupMethod() {
        System.out.println("Runs before each @Test");
    }

    @AfterClass
    public void cleanup() throws IOException {
        client.close();
        response.close();
    }

    @Test
    public void statusIs200() {
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test
    public void typeIsJson() {
        assertEquals(getOrDefault(response.getEntity()).getMimeType(), "application/json");
    }

    @Test
    public void charsetIsUtf8() {
        assertEquals(getOrDefault(response.getEntity()).getCharset().toString(), "UTF-8");
    }
}
