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
        InputStream resource = context.getResourceAsStream(String.format("%s", path));
        InputStream indexHtml = context.getResourceAsStream("index.html");

        return Objects.isNull(resource)
                ? Response.ok().entity(indexHtml).build()
                : Response.ok().entity(resource).build();
    }

}

