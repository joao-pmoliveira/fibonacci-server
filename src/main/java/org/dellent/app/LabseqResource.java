package org.dellent.app;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.resteasy.reactive.RestPath;

import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/labseq")
public class LabseqResource {

    @Inject
    LabseqService service;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Calculate Labseq", description = "Return the Labseq number at the given index")
    @Parameter(name = "id", description = "Index of the sequence", required = true)
    @APIResponse(responseCode = "200", description = "Successful labseq calculation, result returned in response body")
    @APIResponse(responseCode = "400", description = "Invalid input, index can't be a negative number")
    @APIResponse(responseCode = "500", description = "Internal server error")
    public Response labseq(@RestPath Long id) {
        try {
            BigInteger result = service.getSequenceResult(id);
            JsonObject response = Json.createObjectBuilder()
                    .add("n", result.toString()) // gets mapped to 'Infinity' otherwise
                    .build();
            return Response.ok(response).build();
        } catch (IllegalArgumentException exception) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Map.of("error", exception.getMessage()))
                    .build();
        }
    }

    class Result {
        BigInteger n;

        public Result(BigInteger n) {
            this.n = n;
        }
    }

}
