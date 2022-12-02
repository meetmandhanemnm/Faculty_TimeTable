package com.example.miniproject.DAO;

import com.example.miniproject.Bean.Course;
import com.example.miniproject.Bean.Faculty;

import java.util.List;

public interface FacultyDAO {
    int loginFaculty(Faculty faculty);
    List<Course> getCoursesByFaculty(int facultyId);
}
