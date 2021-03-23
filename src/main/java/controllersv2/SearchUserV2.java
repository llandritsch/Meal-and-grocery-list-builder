package controllersv2;

import entity.Users;
import persistence.UsersDAO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
public class SearchUserV2 {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        // get all users from database
        List<Users> users = new UsersDAO().getAllUsers();
        // build an entity response containing all users
        GenericEntity<List<Users>> myEntity = new GenericEntity<List<Users>>(users) {};
        // server the response as JSON back to the client
        return Response.status(200).entity(myEntity).build();
    }
}
