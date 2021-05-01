package controller;

import entity.AuthenticationToken;
import entity.Menu;
import persistence.AuthenticationTokenDAO;
import persistence.MenuDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/MenuService")
public class MenuService {
    MenuDAO dao = new MenuDAO();
    AuthenticationTokenDAO authDAO = new AuthenticationTokenDAO();

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
        GenericEntity<Menu> myEntity = new GenericEntity<>(menu) {};
        return Response.status(200).entity(myEntity).build();
    }

    @POST
    @Path("/menu")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMenu(
            @HeaderParam("userToken") String userToken
    ) {
        AuthenticationToken token = authDAO.getByToken(userToken);
        if (token == null || token.isExpired()) {
            return Response.status(401).build();
        }
        Menu menu = dao.create(token.getUserId());
        if(menu != null) {
            GenericEntity<Menu> myEntity = new GenericEntity<>(menu) {};
            return Response.status(201).entity(myEntity).build();
        } else {
            return Response.status(500).build();
        }
    }

    @DELETE
    @Path("/menu")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteGoals(
            @HeaderParam("userToken") String userToken
    ) {
        AuthenticationToken token = authDAO.getByToken(userToken);
        if (token == null || token.isExpired()) {
            return Response.status(401).build();
        }
        Menu menu = dao.getByUserId(token.getUserId());
        dao.delete(menu);
        return Response.status(204).build();
    }
}

