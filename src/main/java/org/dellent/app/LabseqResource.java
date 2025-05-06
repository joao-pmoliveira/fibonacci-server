package org.dellent.app;

import java.math.BigInteger;

import org.jboss.resteasy.reactive.RestPath;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/labseq")
public class LabseqResource {

    @Inject
    LabseqService service;

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public BigInteger labseq(@RestPath Long id) {
        return service.calculate(id);
    }

}
