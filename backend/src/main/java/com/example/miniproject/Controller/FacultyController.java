package com.example.miniproject.Controller;
import com.example.miniproject.Bean.Faculty;
import com.example.miniproject.Service.FacultyService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URISyntaxException;

@Path("faculty")
public class FacultyController {
    FacultyService facultyService = new FacultyService();

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response verifyFaculty(Faculty faculty) throws URISyntaxException {
        int facultyId = facultyService.loginFaculty(faculty);
        if(facultyId != -1){

            return Response.ok(facultyId).build();
        }else{
            return Response.status(203).build();
        }
    }

}
