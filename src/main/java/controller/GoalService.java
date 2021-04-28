package controller;

import entity.AuthenticationToken;
import entity.UserGoals;
import entity.Users;
import persistence.AuthenticationTokenDAO;
import persistence.UserGoalsDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/GoalService")
public class GoalService {
    UserGoalsDAO goalsDAO = new UserGoalsDAO();
    Users user = new Users();
    AuthenticationTokenDAO authDAO = new AuthenticationTokenDAO();

    @GET
    @Path("/goals")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGoals(
            // The caller will need to supply a header called "userToken"
            // this will be the string token/guid
            @HeaderParam("userToken") String userToken
    ) {
        // Look up the token in the database.
        AuthenticationToken token = authDAO.getByToken(userToken);
        // If there is no token, OR the existing token is expired,
        // then tell the user they are not authorized to access this
        // resource (401 means Unauthorized).
        if (token == null || token.isExpired()) {
            return Response.status(401).build();
        }
        // If we get here, then the user must have a valid auth token.
        List<UserGoals> goals = new UserGoalsDAO().getGoalsByUserid(token.getUserId());
        GenericEntity<List<UserGoals>> myEntity = new GenericEntity<List<UserGoals>>(goals) {};
        return Response.status(200).entity(myEntity).build();
    }

    @GET
    @Path("/goals/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(
            @PathParam("userid") int userid
    ) {
        List<UserGoals> userGoals = new UserGoalsDAO().getGoalsByUserid(userid);
        UserGoals goals = userGoals.get(0);
        GenericEntity<UserGoals> myEntity = new GenericEntity<UserGoals>(goals) {};
        return Response.status(200).entity(myEntity).build();
    }

    /*
    @POST
    @Path("/goals")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createUserGoals(
            @FormParam("calorieGoal") int calorieGoal,
            @FormParam("proteinGoal") int proteinGoal,
            @FormParam("carbGoal") int carbGoal,
            @FormParam("fatGoal") int fatGoal
    ) {
        UserGoals goals = new UserGoals();
        goals.setUser(this.user);
        goals.setCalorieGoal(calorieGoal);
        goals.setProteinGoal(proteinGoal);
        goals.setFatGoal(fatGoal);
        goals.setCarbGoal(carbGoal);
        // create the user
        // return the user entity back from this call
        int id = goalsDAO.createGoals(goals);
        if(id != 0) {
            goals.setId(id);
            GenericEntity<UserGoals> myEntity = new GenericEntity<UserGoals>(goals) {};
            return Response.status(200).entity(myEntity).build();
        } else {
            return Response.status(500).build();
        }
    }
    */

    @POST
    @Path("/goals")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUserGoal(UserGoals goals) {
        int id = goalsDAO.createGoals(goals);
        if(id != 0) {
            goals.setId(id);
            GenericEntity<UserGoals> myEntity = new GenericEntity<>(goals) {};
            return Response.status(201).entity(myEntity).build();
        } else {
            return Response.status(500).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteGoals(@PathParam("id") int id) {
        List<UserGoals> goals = goalsDAO.getGoalsByUserid(this.user.getId());
        UserGoals goalsToDelete = goals.get(0);
        goalsDAO.deleteGoal(goalsToDelete);
        return Response.status(204).build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") int id, UserGoals goalsData) {
        List<UserGoals> goals = goalsDAO.getGoalsByUserid(this.user.getId());
        UserGoals goalsToUpdate = goals.get(0);

        if (goalsData.getCalorieGoal() > 0) {
            goalsToUpdate.setCalorieGoal(goalsData.getCalorieGoal());
        }

        if (goalsData.getCarbGoal() > 0) {
            goalsToUpdate.setCarbGoal(goalsData.getCarbGoal());
        }

        if (goalsData.getProteinGoal() > 0) {
            goalsToUpdate.setProteinGoal(goalsData.getProteinGoal());
        }
        if (goalsData.getFatGoal() > 0) {
            goalsToUpdate.setFatGoal(goalsData.getFatGoal());
        }
        goalsDAO.saveOrUpdate(goalsToUpdate);
        GenericEntity<UserGoals> myEntity = new GenericEntity<UserGoals>(goalsToUpdate) {};
        return Response.status(200).entity(myEntity).build();
    }
}

