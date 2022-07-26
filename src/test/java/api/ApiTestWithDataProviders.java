package api;

import app.CommonApiDataProviders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class ApiTestWithDataProviders {

    private CloseableHttpClient client;
    private CloseableHttpResponse response;

    @BeforeMethod
    public void buildClient(){
        // Arrange
        client = HttpClientBuilder.create().build();
    }
    @DataProvider
    protected Object[][] invalidEmailProvider() {
        return new Object[][]{
                {""},
                {"johnemail.com"},
                {"john@emailcom"}
        };
    }

    @Test(dataProvider = "endpointsRequiringAuthentication", dataProviderClass = CommonApiDataProviders.class)
    public void userEndpointReturns401(String endpoint) throws IOException {
        // Act
        response = client.execute(new HttpGet("https://api.github.com/" + endpoint));
        int actualStatusCode = response.getStatusLine().getStatusCode();

        // Assert
        assertEquals(actualStatusCode, 401);
    }

    @AfterMethod
    public void cleanup() throws IOException {
        client.close();
        response.close();
    }
}
