package controller;

import entity.AuthenticationToken;
import entity.Ingredients;
import persistence.AuthenticationTokenDAO;
import persistence.IngredientsDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/IngredientService")
public class IngredientService {
    IngredientsDAO ingredientsDAO = new IngredientsDAO();
    AuthenticationTokenDAO authDAO = new AuthenticationTokenDAO();

    @POST
    @Path("/ingredients")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createRecipe(
            Ingredients ingredient,
            @HeaderParam("userToken") String userToken
    ) {
        AuthenticationToken token = authDAO.getByToken(userToken);
        if (token == null || token.isExpired()) {
            return Response.status(401).build();
        }
        int id = ingredientsDAO.createRecipeIngredient(ingredient);
        if(id != 0) {
            ingredient.setId(id);
            GenericEntity<Ingredients> myEntity = new GenericEntity<>(ingredient) {};
            return Response.status(200).entity(myEntity).build();
        } else {
            return Response.status(500).build();
        }
    }
}
