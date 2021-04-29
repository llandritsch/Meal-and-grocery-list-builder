package controller;

import entity.AuthenticationToken;
import entity.Users;
import persistence.AuthenticationTokenDAO;
import persistence.UsersDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

class AuthenticationRequest {
    private String username;
    private String password;

    public AuthenticationRequest() { }
    public AuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return this.username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return this.password; }
    public void setPassword(String password) { this.password = password; }
}

@Path("/auth")
public class AuthenticationController {
    AuthenticationTokenDAO authenticationTokenDAO = new AuthenticationTokenDAO();
    UsersDAO usersDAO = new UsersDAO();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(AuthenticationRequest authRequest) {
        Users user = usersDAO.getUserByUsernameAndPassword(authRequest.getUsername(), authRequest.getPassword());
        if (user == null) {
            return Response.status(401).build();
        }

        AuthenticationToken token = authenticationTokenDAO.create(user.getId());
        GenericEntity<AuthenticationToken> myEntity = new GenericEntity<>(token) {};
        return Response.status(201).entity(myEntity).build();
    }

    @DELETE
    @Path("{token}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("token") String token) {
        AuthenticationToken authToken = authenticationTokenDAO.getByToken(token);
        if (authToken == null) { return Response.status(204).build(); }

        authenticationTokenDAO.delete(authToken);
        return Response.status(204).build();
    }
}

