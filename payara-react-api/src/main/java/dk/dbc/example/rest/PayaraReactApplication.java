package dk.dbc.example.rest;

import dk.dbc.example.PayaraReactService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class PayaraReactApplication extends Application {
    private static final Set<Class<?>> classes = new HashSet<>();

    static {
        classes.add(PayaraReactService.class);
        classes.add(Status.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }

}
