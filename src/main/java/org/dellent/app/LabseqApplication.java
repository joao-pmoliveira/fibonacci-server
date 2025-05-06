package org.dellent.app;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.ws.rs.core.Application;

@OpenAPIDefinition(tags = {
        @Tag(name = "labseq", description = "Operations related to Labseq sequence calculation")
}, info = @Info(title = "Labseq API", version = "1.0.0", description = "API for calculating Labseq numbers, optimized with caching"))
public class LabseqApplication extends Application {

}
