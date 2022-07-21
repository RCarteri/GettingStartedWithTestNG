package api;

import baseclasses.WebServiceBaseClass;
import org.testng.annotations.Test;

import static org.apache.http.entity.ContentType.getOrDefault;
import static org.testng.Assert.assertEquals;

public class WebServiceTestWithSetup extends WebServiceBaseClass {
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
