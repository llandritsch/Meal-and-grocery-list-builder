package controller;

import entity.Users;
import persistence.UsersDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/UserService")
public class UsersService {
    UsersDAO usersDAO = new UsersDAO();

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        // get all users from database
        List<Users> users = new UsersDAO().getAllUsers();
        // build an entity response containing all users
        GenericEntity<List<Users>> myEntity = new GenericEntity<List<Users>>(users) {};
        // server the response as JSON back to the client
        return Response.status(200).entity(myEntity).build();
    }

    @GET
    @Path("/users/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(
        @PathParam("userid") int userid
    ) {
        Users user = new UsersDAO().getUserById(userid);
        GenericEntity<Users> myEntity = new GenericEntity<Users>(user) {};
        return Response.status(200).entity(myEntity).build();
    }

    @POST
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createUser(
        @FormParam("userName") String userName,
        @FormParam("password") String password
    ) {
        Users user = new Users();
        user.setUserName(userName);
        user.setPassword(password);
        // create the user
        // return the user entity back from this call
        int id = usersDAO.createUser(user);
        if(id != 0) {
            user.setId(id);
            GenericEntity<Users> myEntity = new GenericEntity<Users>(user) {};
            return Response.status(200).entity(myEntity).build();
        } else {
            return Response.status(500).build();
        }
    }
}
