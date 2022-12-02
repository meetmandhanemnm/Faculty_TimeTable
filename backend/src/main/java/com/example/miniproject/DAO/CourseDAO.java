package com.example.miniproject.DAO;

import com.example.miniproject.Bean.Course;
import com.example.miniproject.Bean.StudentCourse;

import java.util.List;

public interface CourseDAO {
    List<Course> getCoursesByFaculty(int facultyId);
    List<StudentCourse> getStudentByCourse(int courseId);
}
