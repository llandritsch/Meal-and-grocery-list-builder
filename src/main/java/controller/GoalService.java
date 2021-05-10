package controller;

import entity.AuthenticationToken;
import entity.UserGoals;
import persistence.AuthenticationTokenDAO;
import persistence.UserGoalsDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Goal Service is responsible for anything related to user goals.
 */
@Path("/api/GoalService")
public class GoalService {
    UserGoalsDAO goalsDAO = new UserGoalsDAO();
    AuthenticationTokenDAO authDAO = new AuthenticationTokenDAO();

    /**
     * Checks if user is authenicated and gets the goal from the userid associated with that token
     * @param userToken
     * @return
     */
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
        UserGoals goal = new UserGoalsDAO().getGoalsByUserid(token.getUserId());
        GenericEntity<UserGoals> myEntity = new GenericEntity<>(goal) {};
        return Response.status(200).entity(myEntity).build();
    }

    /**
     * Checks for auth and creates a new goal for the user
     * @param goals
     * @param userToken
     * @return response status
     */
    @POST
    @Path("/goals")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUserGoal(
            UserGoals goals,
            @HeaderParam("userToken") String userToken
    ) {
        AuthenticationToken token = authDAO.getByToken(userToken);
        if (token == null || token.isExpired()) {
            return Response.status(401).build();
        }

        goals.setUserid(token.getUserId());
        int id = goalsDAO.createGoals(goals);

        if(id != 0) {
            goals.setId(id);
            GenericEntity<UserGoals> myEntity = new GenericEntity<>(goals) {};
            return Response.status(201).entity(myEntity).build();
        } else {
            return Response.status(500).build();
        }
    }

    /**
     * Checks for authentication and deletes the goal associated with the id of that token
     * @param id
     * @param userToken
     * @return response status
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteGoals(
            @PathParam("id") int id,
            @HeaderParam("userToken") String userToken
    ) {
        AuthenticationToken token = authDAO.getByToken(userToken);
        if (token == null || token.isExpired()) {
            return Response.status(401).build();
        }
        UserGoals goals = goalsDAO.getGoalsByUserid(token.getUserId());
        goalsDAO.deleteGoal(goals);
        return Response.status(204).build();
    }

    /**
     * updates goal of authenticated user
     * @param id
     * @param goalsData
     * @param userToken
     * @return repsonse status
     */
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(
            @PathParam("id") int id,
            UserGoals goalsData,
            @HeaderParam("userToken") String userToken
    ) {
        AuthenticationToken token = authDAO.getByToken(userToken);
        if (token == null || token.isExpired()) {
            return Response.status(401).build();
        }

        UserGoals goalsToUpdate = goalsDAO.getGoalsByUserid(token.getUserId());

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

