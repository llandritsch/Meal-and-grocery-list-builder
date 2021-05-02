package controller;

import entity.AuthenticationToken;
import entity.Ingredients;
import entity.Recipes;
import persistence.AuthenticationTokenDAO;
import persistence.IngredientsDAO;
import persistence.RecipesDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

class AddIngredientsRequest {
    private Ingredients[] ingredients;
    public AddIngredientsRequest() {}

    public Ingredients[] getIngredients() { return this.ingredients; }
    public void setIngredients(Ingredients[] ingredients) {
        this.ingredients = ingredients;
    }
}

@Path("/RecipeService")
public class RecipeService {
    RecipesDAO dao = new RecipesDAO();
    IngredientsDAO ingredientsDAO = new IngredientsDAO();
    AuthenticationTokenDAO authDAO = new AuthenticationTokenDAO();

    @GET
    @Path("/recipes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecipes(
            @HeaderParam("userToken") String userToken
    ) {
        AuthenticationToken token = authDAO.getByToken(userToken);
        if (token == null || token.isExpired()) {
            return Response.status(401).build();
        }
        List<Recipes> recipes = dao.getAllRecipes();
        GenericEntity<List<Recipes>> myEntity = new GenericEntity<List<Recipes>>(recipes) {};
        return Response.status(200).entity(myEntity).build();
    }

    @GET
    @Path("/recipes/{recipeid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecipeById(
            @PathParam("recipeid") int recipeid,
            @HeaderParam("userToken") String userToken
    ) {
        AuthenticationToken token = authDAO.getByToken(userToken);
        if (token == null || token.isExpired()) {
            return Response.status(401).build();
        }
        Recipes recipes = new RecipesDAO().getRecipeById(recipeid);
        GenericEntity<Recipes> myEntity = new GenericEntity<Recipes>(recipes) {};
        return Response.status(200).entity(myEntity).build();
    }

    @GET
    @Path("/recipes/{recipeName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecipeByName(
            @PathParam("recipeName") String recipeName,
            @HeaderParam("userToken") String userToken
    ) {
        AuthenticationToken token = authDAO.getByToken(userToken);
        if (token == null || token.isExpired()) {
            return Response.status(401).build();
        }
        List<Recipes> recipes = new RecipesDAO().getRecipeByName(recipeName);
        GenericEntity<List<Recipes>> myEntity = new GenericEntity<List<Recipes>>(recipes) {};
        return Response.status(200).entity(myEntity).build();
    }

    @POST
    @Path("/recipes")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createRecipe(
            Recipes recipe,
            @HeaderParam("userToken") String userToken
    ) {
        AuthenticationToken token = authDAO.getByToken(userToken);
        if (token == null || token.isExpired()) {
            return Response.status(401).build();
        }
        recipe.setUserId(token.getUserId());
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
    public Response deleteRecipe(
            @PathParam("id") int id,
            @HeaderParam("userToken") String userToken
    ) {
        AuthenticationToken token = authDAO.getByToken(userToken);
        if (token == null || token.isExpired()) {
            return Response.status(401).build();
        }
        Recipes recipeToDelete = dao.getRecipeById(id);
        dao.deleteRecipe(recipeToDelete);
        return Response.status(204).build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateRecipe(
            @PathParam("id") int id,
            Recipes recipeData,
            @HeaderParam("userToken") String userToken
    ) {
        AuthenticationToken token = authDAO.getByToken(userToken);
        if (token == null || token.isExpired()) {
            return Response.status(401).build();
        }

        Recipes recipe = dao.getRecipeById(id);

        if(recipeData.getRecipe_name() != null) {
            recipe.setRecipe_name(recipeData.getRecipe_name());
        }
        dao.saveOrUpdate(recipe);
        GenericEntity<Recipes> myEntity = new GenericEntity<Recipes>(recipe) {};
        return Response.status(200).entity(myEntity).build();
    }

    @POST
    @Path("/recipes/{recipeId}/ingredients")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addIngredientsToRecipe(
            @PathParam("recipeId") int recipeId,
            @HeaderParam("userToken") String userToken,
            AddIngredientsRequest ingredientsRequest
    ) {
        AuthenticationToken token = authDAO.getByToken(userToken);
        if (token == null || token.isExpired()) {
            return Response.status(401).build();
        }
        Recipes recipe = dao.getRecipeById(recipeId);
        // Return a 404 (Not Found) if the recipe does not exist
        if (recipe == null) {
            return Response.status(404).build();
        }
        // Add ingredients to the recipe
        Ingredients[] ingredients = ingredientsRequest.getIngredients();
        ingredientsDAO.createRecipeIngredients(recipeId, ingredients);
        // Re-render the recipe with its new ingredients
        recipe = dao.getRecipeById(recipeId);
        GenericEntity<Recipes> myEntity = new GenericEntity<>(recipe) {};
        return Response.status(200).entity(myEntity).build();
    }
}
