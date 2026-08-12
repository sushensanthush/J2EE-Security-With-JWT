package lk.susa.web.resource;

import jakarta.inject.Inject;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStoreHandler;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lk.susa.web.model.LoginRequest;
import lk.susa.web.util.JwtUtil;

import java.util.Map;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    private IdentityStoreHandler identityStoreHandler;

    public record LoginRequest(String username, String password) {
    } // JDK 16 above

    @Path("/login")
    @POST
    public Response login(LoginRequest request) {
        if (request == null || request.username == null || request.password == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Map.of(
                            "error", "Missing username and password"
                    )).build();
        }

        UsernamePasswordCredential credential =
                new UsernamePasswordCredential(request.username(), request.password());

        CredentialValidationResult result = identityStoreHandler.validate(credential);

        if (result.getStatus() == CredentialValidationResult.Status.VALID) {
            String token = JwtUtil.generateToken(
                    result.getCallerPrincipal().getName(),
                    result.getCallerGroups()
            );

            return Response.status(Response.Status.OK).entity(
                    Map.of(
                            "token", token,
                            "username", result.getCallerPrincipal().getName(),
                            "roles", result.getCallerGroups()
                    )
            ).build();
        }

        return Response.status(Response.Status.UNAUTHORIZED)
                .entity(
                        Map.of("error", "Invalid username or password")
                ).build();

    }
}
