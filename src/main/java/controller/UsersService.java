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
/*
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
*/

    @POST
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(Users user) {
        int id = usersDAO.createUser(user);
        if (id != 0) {
            user.setId(id);
            GenericEntity<Users> myEntity = new GenericEntity<Users> (user) {};
            return Response.status(201).entity(myEntity).build();
        } else {
            return Response.status(500).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("id") int id) {
        Users userToDelete = usersDAO.getUserById(id);
        usersDAO.deleteUser(userToDelete);
        return Response.status(204).build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") int id, Users userData) {
        Users user = usersDAO.getUserById(id);

        if (userData.getUserName() != null) {
            user.setUserName(userData.getUserName());
        }

        if (userData.getPassword() != null) {
            user.setPassword(userData.getPassword());
        }

        usersDAO.saveOrUpdate(user);
        GenericEntity<Users> myEntity = new GenericEntity<>(user) {};
        return Response.status(200).entity(myEntity).build();
    }
}
