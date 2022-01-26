package org.example;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/")
public class RestService {
    private static final AtomicInteger currentId = new AtomicInteger();
    private static final Map<String, String> links = new ConcurrentHashMap<>();

    public static String getLinks(String id) {
        return links.get(id);
    }

    @POST // add new
    public Response postMessage(final String url) {
        final int id = currentId.getAndIncrement();
        links.put(String.valueOf(id), url.toString());
        return Response.ok(id).build();
    }

    @GET // get info
    @Path("/{id}")
    public Response getMessage(@PathParam("id") String id) {
        if (id == null || id.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        final String url = links.get(id);
        if (url == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(url).build();
    }

    @PUT // edit
    @Path("/{id}")
    public Response putMessage(@PathParam("id") String id, final String url) {
        if (id == null || id.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        links.remove(id);
        links.put(String.valueOf(id), url.toString());
        return Response.ok(id).build();
    }

    @DELETE // delete
    @Path("/{id}")
    public Response deleteMessage(@PathParam("id") String id) {
        if (id == null || id.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        links.remove(id);
        return Response.ok(id).build();
    }
}
