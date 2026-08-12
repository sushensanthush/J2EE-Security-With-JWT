package lk.susa.web.resource;


import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lk.susa.web.model.LoginRequest;

@Path( "/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Path("/login")
    @POST
    public Response login(LoginRequest request) {
        System.out.println(request.getUsername()+ ":" +request.getPassword());
        return Response.ok().build();

    }
}
