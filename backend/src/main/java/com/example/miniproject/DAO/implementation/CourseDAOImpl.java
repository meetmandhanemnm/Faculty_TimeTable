package com.example.miniproject.DAO.implementation;

import com.example.miniproject.Bean.Course;
import com.example.miniproject.Bean.Faculty;
import com.example.miniproject.Bean.StudentCourse;
import com.example.miniproject.DAO.CourseDAO;
import com.example.miniproject.Utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    @Override
    @Deprecated
    public List<Course> getCoursesByFaculty(int facultyId) {
        Session session = SessionUtil.getSession();
        try {
            System.out.println("facultyId: "+facultyId);
            Query query = session.createQuery("from Faculty where emp_id=:id");
            query.setParameter("id",facultyId);

            if(query.getResultList().size()==1){
                Faculty faculty1 = (Faculty)query.getResultList().get(0);
                List<Course> courses = faculty1.getCourses();
                for(Course course: courses){
                    System.out.println(course.getName());
                }
                return courses;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            session.close();
        }
        return null;
    }

    @Override
    @Deprecated
    public List<StudentCourse> getStudentByCourse(int courseId) {
        Session session = SessionUtil.getSession();
        try {
            System.out.println(courseId);
            Query query = session.createQuery("from Course where course_id=:id");
            query.setParameter("id", courseId);

            if (query.getResultList().size() == 1) {
                Course course = (Course) query.getResultList().get(0);

                List<StudentCourse> studentCourses = course.getStudentCourses();

                for (StudentCourse studentCourse : studentCourses) {
                    System.out.println("CourseService : " + studentCourse.getStudent().getFirstName());
                }
                return studentCourses;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
        return null;
    }
}
