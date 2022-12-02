package com.example.miniproject.Controller;

import com.example.miniproject.Bean.Course;
import com.example.miniproject.Bean.StudentCourse;
import com.example.miniproject.Service.CourseService;
import com.example.miniproject.Service.JSONBuilder;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@Path("courses")
public class CourseController {
    CourseService courseService = new CourseService();
    JSONBuilder builder = new JSONBuilder();

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoursesByFaculty(@PathParam("id") String id) throws URISyntaxException {
        List<Course> courses = courseService.getCoursesByFaculty(Integer.parseInt(id));
        if(courses != null){
            for(Course course:courses){
                System.out.println("controller : "+course.getName());
            }
            JSONArray jsonNames = new JSONArray();

            for(Course course : courses){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id",course.getCourse_id());
                jsonObject.put("name",course.getName());
                jsonNames.put(jsonObject);
            }


            System.out.println(jsonNames.toString());
            //System.out.println("controller : "+Arrays.toString(courseArray));
            return Response.ok().entity(jsonNames.toString()).build();
        }else{
            return Response.status(203).build();
        }
    }

    @GET
    @Path("/getstudents/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentsByCourse(@PathParam("id") String id) throws URISyntaxException {
        List<StudentCourse> studentCourses = courseService.getStudentsByCourse(Integer.parseInt(id));
        if(studentCourses != null){
            for(StudentCourse studentCourse:studentCourses){
                System.out.println("controller : "+studentCourse.getStudent().getFirstName());
            }
            JSONArray jsonArray = builder.getStudentJsonArray(studentCourses);
            System.out.println(jsonArray.toString());
            return Response.ok().entity(jsonArray.toString()).build();
        }else{
            return Response.status(203).build();
        }
    }

    @GET
    @Path("/getschedule/{id}/values")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourseSchedule(@PathParam("id") int id, @QueryParam("year") int year, @QueryParam("term") int term) throws URISyntaxException {
        System.out.println("Controller facultyId : "+id);
        System.out.println("Controller year : "+year);
        System.out.println("Controller term : "+term);
        JSONArray jsonArray = courseService.getCourseSchedule(id,year,term);
        if(jsonArray != null){

            System.out.println(jsonArray.toString());
            return Response.ok().entity(jsonArray.toString()).build();
        }else{
            return Response.status(203).build();
        }
    }
}
