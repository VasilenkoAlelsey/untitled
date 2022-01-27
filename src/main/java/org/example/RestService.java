package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/")
public class RestService {
    private static final AtomicInteger currentId = new AtomicInteger();
    private static final Map<Integer, Client> links = new ConcurrentHashMap<>();

    @POST // add new
    public Response postMessage(final String requestBody) throws IOException {
        final int id = currentId.getAndIncrement();
        StringReader stringReader = new StringReader(requestBody);
        ObjectMapper objectMapper = new ObjectMapper();
        Client client = objectMapper.readValue(stringReader, Client.class);
        links.put(id, client);
        return Response.ok(id).build();
    }

    @GET // get info
    @Path("/{id}")
    public Response getMessage(@PathParam("id") int id) throws IOException {
        Client client = links.get(id);
        StringWriter stringWriter = new StringWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(stringWriter, client);
        return Response.ok(stringWriter.toString()).build();
    }

    @PUT // edit
    @Path("/{id}")
    public Response putMessage(@PathParam("id") int id, final String requestBody) throws IOException {
        Client client = links.get(id);
        StringReader stringReader = new StringReader(requestBody);
        ObjectMapper objectMapperInput = new ObjectMapper();
        client = objectMapperInput.readValue(stringReader, Client.class);
        links.remove(id);
        links.put(id, client);
        StringWriter stringWriter = new StringWriter();
        ObjectMapper objectMapperOutput = new ObjectMapper();
        objectMapperOutput.writeValue(stringWriter, client);
        return Response.ok(stringWriter.toString()).build();
    }

    @DELETE // delete
    @Path("/{id}")
    public Response deleteMessage(@PathParam("id") int id) {
        links.remove(id);
        return Response.ok(id).build();
    }
}
