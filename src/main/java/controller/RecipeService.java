package controller;

import entity.Recipes;
import entity.Users;
import persistence.RecipesDAO;

import javax.ws.rs.*;
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
    @Path("/recipes/{recipeid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecipeById(
            @PathParam("recipeid") int recipeid
    ) {
        Recipes recipes = new RecipesDAO().getRecipeById(recipeid);
        GenericEntity<Recipes> myEntity = new GenericEntity<Recipes>(recipes) {};
        return Response.status(200).entity(myEntity).build();
    }

    @GET
    @Path("/recipes/{recipeName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecipeByName(
            @PathParam("recipeName") String recipeName
    ) {
        List<Recipes> recipes = new RecipesDAO().getRecipeByName(recipeName);
        GenericEntity<List<Recipes>> myEntity = new GenericEntity<List<Recipes>>(recipes) {};
        return Response.status(200).entity(myEntity).build();
    }

    @POST
    @Path("/recipes")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createRecipe(Recipes recipe) {
        int id = dao.createRecipe(recipe);
        if(id != 0) {
            recipe.setRecipe_id(id);
            GenericEntity<Recipes> myEntity = new GenericEntity<>(recipe) {};
            return Response.status(200).entity(myEntity).build();
        } else {
            return Response.status(500).build();
        }
    }

}
