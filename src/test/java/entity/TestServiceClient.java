package entity;

import org.junit.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceClient {

    @Test
    public void testEdamamJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://api.edamam.com/search?q=chicken&app_id=a71d35bc&app_key=0f73ce60d58cd61558e515c6cd06c390&from=0&to=3&calories=591-722&health=alcohol-free"
                );
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        assertEquals("???", response);
    }
}
