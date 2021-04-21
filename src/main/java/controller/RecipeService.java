package controller;

import entity.Recipes;
import entity.Users;
import persistence.RecipesDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/RecipeService")
public class RecipeService {
    RecipesDAO dao = new RecipesDAO();
    Users user = new Users();

    @GET
    @Path("/recipes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecipes() {
        List<Recipes> recipes = new RecipesDAO().getAllRecipes();
        GenericEntity<List<Recipes>> myEntity = new GenericEntity<List<Recipes>>(recipes) {};
        return Response.status(200).entity(myEntity).build();
    }

    @GET
    @Path("/goals/{recipeid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(
            @PathParam("recipeid") int recipeid
    ) {
        Recipes recipes = new RecipesDAO().getRecipeById(recipeid);
        GenericEntity<Recipes> myEntity = new GenericEntity<Recipes>(recipes) {};
        return Response.status(200).entity(myEntity).build();
    }
}
