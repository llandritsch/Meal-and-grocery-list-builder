package controller;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.Objects;

@Path("")
public class StaticFileService {

    @Context
    ServletContext context;

    @GET
    @Path("{path: .*}")
    public Response Get(@PathParam("path") String path) {
        InputStream resource = context.getResourceAsStream(String.format("static/%s", path));
        InputStream indexHtml = context.getResourceAsStream("static/index.html");

        return Objects.isNull(resource)
                // If the resource does not exist, then respond with the index.html page. This should
                // load the user into the Angular application and from there, routing will take over.
                ? Response.ok().entity(indexHtml).build()
                // If the resource DOES exist, then it's likely the index.html page trying to load
                // the JS/CSS files. Serve those up instead, so that the page can load the Angular
                // code.
                : Response.ok().entity(resource).build();
    }

}

