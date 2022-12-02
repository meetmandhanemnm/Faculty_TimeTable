package com.example.miniproject.Service;

import com.example.miniproject.Bean.Course;
import com.example.miniproject.Bean.CourseSchedule;
import com.example.miniproject.Bean.Specialisation;
import com.example.miniproject.Bean.StudentCourse;
import com.example.miniproject.DAO.CourseDAO;
import com.example.miniproject.DAO.FacultyDAO;
import com.example.miniproject.DAO.implementation.CourseDAOImpl;
import com.example.miniproject.DAO.implementation.FacultyDAOImpl;

import java.sql.Time;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

public class CourseService {
    CourseDAO courseDAO = new CourseDAOImpl();
    FacultyDAO facultyDAO = new FacultyDAOImpl();

    public List<Course> getCoursesByFaculty(int facultyId) {
        return courseDAO.getCoursesByFaculty(facultyId);
    }

    public List<StudentCourse> getStudentsByCourse(int courseId){
        return courseDAO.getStudentByCourse(courseId);
    }

    public JSONArray getCourseSchedule(int facultyId, int year, int term){

        List<Course> courses = facultyDAO.getCoursesByFaculty(facultyId);
        String[][] schedule = new String[4][6];
        //Arrays.fill(schedule,"");
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Monday",0);
        hashMap.put("Tuesday",1);
        hashMap.put("Wednesday",2);
        hashMap.put("Thursday",3);
        hashMap.put("Friday",4);
        hashMap.put("Saturday",5);

        for(int i=0;i<4;i++){
            for(int j=0;j<6;j++){
                schedule[i][j]="-";
            }
        }

        System.out.println("*********************************************COURSES***************************"+courses);
        for(Course course:courses){
            Set<String> S= new HashSet<>();
            for(Specialisation sp: course.getSpecialisations()) {
                S.add(sp.getName());
            }
            if(course.getTerm() == term && course.getYear() == year){
                List<CourseSchedule> courseSchedules = course.getCourseSchedules();
                System.out.println("*********************************************COURSEShedule***************************"+courseSchedules);
                for(CourseSchedule courseSchedule : courseSchedules){
                    Time time = courseSchedule.getTime();
                    String timeStr = time.toString();
                    System.out.println("*********************************************timestr***************************"+timeStr);
                    switch(timeStr) {
                        case "09:00:00":
                            schedule[0][hashMap.get(courseSchedule.getDay())] = course.getName()+"("+S+")"+"("+courseSchedule.getBuilding()+","+courseSchedule.getRoom()+")"+"/"+course.getCourse_id();
                            break;
                        case "11:30:00":
                            schedule[1][hashMap.get(courseSchedule.getDay())] = course.getName()+"("+S+")"+"("+courseSchedule.getBuilding()+","+courseSchedule.getRoom()+")"+"/"+course.getCourse_id();
                            break;
                        case "14:00:00":
                            schedule[2][hashMap.get(courseSchedule.getDay())] = course.getName()+"("+S+")"+"("+courseSchedule.getBuilding()+","+courseSchedule.getRoom()+")"+"/"+course.getCourse_id();
                            break;
                        case "16:00:00":
                            schedule[3][hashMap.get(courseSchedule.getDay())] = course.getName()+"("+S+")"+"("+courseSchedule.getBuilding()+","+courseSchedule.getRoom()+")"+"/"+course.getCourse_id();
                            break;
                    }
                }
            }

        }

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject;
        for(int i=0;i<4;i++){
            jsonObject = new JSONObject();
            jsonObject.put("Monday",schedule[i][0]);
            jsonObject.put("Tuesday",schedule[i][1]);
            jsonObject.put("Wednesday",schedule[i][2]);
            jsonObject.put("Thursday",schedule[i][3]);
            jsonObject.put("Friday",schedule[i][4]);
            jsonObject.put("Saturday",schedule[i][5]);
            jsonArray.put(jsonObject);
        }
        return jsonArray;

    }


}
