package org.dellent.app;

import java.math.BigInteger;
import java.util.Map;

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
    public Response labseq(@RestPath Long id) {
        BigInteger result = service.getSequenceResult(id);
        JsonObject response = Json.createObjectBuilder()
                .add("n", result.toString()) // gets mapped to 'Infinity' otherwise
                .build();
        return Response.ok(response).build();
    }

    class Result {
        BigInteger n;

        public Result(BigInteger n) {
            this.n = n;
        }
    }

}
