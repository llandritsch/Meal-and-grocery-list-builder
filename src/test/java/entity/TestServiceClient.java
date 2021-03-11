package entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceClient {

    @Test
    public void testEdamamJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://api.edamam.com/search?from=1&app_id=a71d35bc&app_key=0f73ce60d58cd61558e515c6cd06c390&calories=591-722&q=chicken");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Recipe recipe = mapper.readValue(response, Recipe.class);
        String label = recipe.getHits().get(0).getRecipe().getLabel();
        assertEquals("Chicken Marsala", label);

        //assertEquals("Citrus Roasted Chicken", response);
    }
}
