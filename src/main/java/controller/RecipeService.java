package controller;

import entity.Ingredients;
import entity.Recipes;
import persistence.IngredientsDAO;
import persistence.RecipesDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/RecipeService")
public class RecipeService {
    RecipesDAO dao = new RecipesDAO();
    IngredientsDAO ingredientsDAO = new IngredientsDAO();

    @GET
    @Path("/recipes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecipes() {
        List<Recipes> recipes = new RecipesDAO().getAllRecipes();
        GenericEntity<List<Recipes>> myEntity = new GenericEntity<List<Recipes>>(recipes) {};
        return Response.status(200).entity(myEntity).build();
    }

    @GET
    @Path("/ingredients")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIngredients() {
        List<Ingredients> ingredients = ingredientsDAO.getAllIngredients();
        GenericEntity<List<Ingredients>> myEntity = new GenericEntity<>(ingredients) {};
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

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteRecipe(@PathParam("id") int id) {
        Recipes recipeToDelete = dao.getRecipeById(id);
        dao.deleteRecipe(recipeToDelete);
        return Response.status(204).build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateRecipe(@PathParam("id") int id, Recipes recipeData) {
         Recipes recipe = dao.getRecipeById(id);

         if(recipeData.getRecipe_name() != null) {
             recipe.setRecipe_name(recipeData.getRecipe_name());
         }
         dao.saveOrUpdate(recipe);
         GenericEntity<Recipes> myEntity = new GenericEntity<Recipes>(recipe) {};
         return Response.status(200).entity(myEntity).build();
    }
}
