package controller;

import entity.AuthenticationToken;
import entity.Menu;
import entity.MenuRecipe;
import persistence.AuthenticationTokenDAO;
import persistence.MenuDAO;
import persistence.MenuRecipeDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/MenuService")
public class MenuService {
    MenuDAO dao = new MenuDAO();
    AuthenticationTokenDAO authDAO = new AuthenticationTokenDAO();
    MenuRecipeDAO menuRecipeDAO = new MenuRecipeDAO();

    @GET
    @Path("/menu")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMenu(
            @HeaderParam("userToken") String userToken
    ) {
        AuthenticationToken token = authDAO.getByToken(userToken);
        if (token == null || token.isExpired()) {
            return Response.status(401).build();
        }

        Menu menu = dao.getByUserId(token.getUserId());
        // The user has no menu. Return "No Content (204) response"
        if (menu == null) {
            return Response.status(204).build();
        }
        GenericEntity<Menu> myEntity = new GenericEntity<>(menu) {};
        return Response.status(200).entity(myEntity).build();
    }

    @POST
    @Path("/menu/{recipeId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMenuRecipe(
            @HeaderParam("userToken") String userToken,
            @PathParam("recipeId") int recipeId
    ) {
        AuthenticationToken token = authDAO.getByToken(userToken);
        if (token == null || token.isExpired()) {
            return Response.status(401).build();
        }

        // Get the user's existing menu
        Menu menu = dao.getByUserId(token.getUserId());

        // If they don't have one yet, first create them a menu
        if (menu == null) {
            menu = dao.create(token.getUserId());
        }

        // Add the recipe to the menu
        MenuRecipe menuRecipe = menuRecipeDAO.create(menu.getId(), recipeId);
        GenericEntity<MenuRecipe> myEntity = new GenericEntity<>(menuRecipe) {};
        return Response.status(201).entity(myEntity).build();
    }

    @DELETE
    @Path("/menu/{recipeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteMenuRecipe(
            @HeaderParam("userToken") String userToken,
            @PathParam("recipeId") int recipeId
    ) {
        AuthenticationToken token = authDAO.getByToken(userToken);
        if (token == null || token.isExpired()) {
            return Response.status(401).build();
        }
        // Get the user's menu.
        Menu menu = dao.getByUserId(token.getUserId());
        // If they don't have one, then do nothing.
        if (menu == null) {
            return Response.status(204).build();
        }
        // Delete the MenuRecipe, if it exists
        MenuRecipe menuRecipe = menuRecipeDAO.getByMenuAndRecipeId(menu.getId(), recipeId);
        if (menuRecipe != null) {
            menuRecipeDAO.delete(menuRecipe);
        }
        return Response.status(204).build();
    }
}

