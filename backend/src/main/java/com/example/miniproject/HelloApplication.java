package com.example.miniproject;

import com.example.miniproject.Utils.CORSFilter;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;

//import static org.graalvm.compiler.nodes.java.RegisterFinalizerNode.register;

@ApplicationPath("/api")
public class HelloApplication extends Application {


    public HelloApplication() {


        final ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(CORSFilter.class);
        resourceConfig.packages("com.example.miniproject");
    }
}
