package controller;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class ApplicationController extends Application {

    /**
     * router class for API. This directs the paths for the API
     * @return h (API route set)
     */
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(StaticFileService.class);
        h.add(SearchUser.class);
        h.add(UsersService.class);
        h.add(GoalService.class);
        h.add(RecipeService.class);
        h.add(AuthenticationController.class);
        h.add(MenuService.class);
        return h;
    }
}

