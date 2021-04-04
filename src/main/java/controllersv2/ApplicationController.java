package controllersv2;

import controller.UsersService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api/v2")
public class ApplicationController extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(SearchUserV2.class);
        h.add(UsersService.class);
        return h;
    }
}
