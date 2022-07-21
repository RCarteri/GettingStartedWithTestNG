package api;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.Closeable;
import java.io.IOException;

import static org.apache.http.entity.ContentType.getOrDefault;
import static org.testng.Assert.assertEquals;

public class WebServiceTestSoftAssert {

    @Test
    public void hardAssertsStopImediately() throws IOException {
//        Arrange
        CloseableHttpClient client = HttpClientBuilder.create().build();

//        Act
        CloseableHttpResponse response = client.execute(new HttpGet("https://api.github.com/"));

//        Assert
        System.out.println("First assert");
        assertEquals(response.getStatusLine().getStatusCode(), 404);

        System.out.println("Second assert");
        assertEquals(getOrDefault(response.getEntity()).getMimeType(), "application/xml");

        System.out.println("Third assert");
        assertEquals(getOrDefault(response.getEntity()).getCharset().toString(), "UTF-8");

        client.close();
        response.close();
    }

    @Test
    public void softAssertConinuesToTheEnd() throws IOException {
//        Arrange
        CloseableHttpClient client = HttpClientBuilder.create().build();
        SoftAssert sa = new SoftAssert();

//        Act
        CloseableHttpResponse response = client.execute(new HttpGet("https://api.github.com/"));

//        Assert
        System.out.println("First assert");
        sa.assertEquals(response.getStatusLine().getStatusCode(), 404);

        System.out.println("Second assert");
        sa.assertEquals(getOrDefault(response.getEntity()).getMimeType(), "application/xml");

        System.out.println("Third assert");
        sa.assertEquals(getOrDefault(response.getEntity()).getCharset().toString(), "UTF-8");

        client.close();
        response.close();

        sa.assertAll();
    }
}
