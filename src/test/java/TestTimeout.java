import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.apache.http.impl.client.HttpClientBuilder.*;
import static org.testng.Assert.*;

public class TestTimeout {
    CloseableHttpClient client;
    CloseableHttpResponse response;

    @BeforeMethod(timeOut = 800) // enough time - will pass
    public void setup(){
//        Arrange
        client = HttpClientBuilder.create().build();
    }

    @Test(timeOut = 400) // not enough time - will fail
    public void testIsTooSlow() throws IOException {
//        Act
        CloseableHttpResponse response = client.execute(new HttpGet("http://api.github.com/"));
//        Assert
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }
}
