package com.example.miniproject;

import com.example.miniproject.Utils.SessionUtil;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.hibernate.Session;

@Path("/create")
public class populate {
    @GET
    @Produces("text/plain")
    public String hello() {
        Session session = SessionUtil.getSession();
        return "Database created!";
    }
}