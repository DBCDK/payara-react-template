package dk.dbc.example;

import dk.dbc.util.StopwatchInterceptor;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Interceptors(StopwatchInterceptor.class)
@Stateless
@Path("")
public class PayaraReactService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PayaraReactService.class);

    @Inject
    @ConfigProperty(name = "INSTANCE", defaultValue = "")
    private String INSTANCE;

    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("v1/config")
    public Response getConfig() {
        return Response.ok(INSTANCE).build();
    }
}
