package com.example.miniproject.DAO.implementation;

import com.example.miniproject.Bean.Course;
import com.example.miniproject.Bean.Faculty;
import com.example.miniproject.DAO.FacultyDAO;
import com.example.miniproject.Utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class FacultyDAOImpl implements FacultyDAO {

    @Override
    @Deprecated
    public int loginFaculty(Faculty faculty) {
        Session session = SessionUtil.getSession();
        try {
            System.out.println("email entered by user: "+faculty.getEmail());
            System.out.println("password entered by user: "+faculty.getPassword());
            Query query = session.createQuery("from Faculty where email=:email and password=:password");
            query.setParameter("email", faculty.getEmail());
            query.setParameter("password", faculty.getPassword());
            if(query.getResultList().size()==1){
                Faculty faculty1 = (Faculty)query.getResultList().get(0);
                return faculty1.getEmp_id();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            session.close();
        }
        return -1;
    }

    @Override
    @Deprecated
    public List<Course> getCoursesByFaculty(int facultyId) {
        Session session = SessionUtil.getSession();
        System.out.println("FacultyDaoImpl  facultyId : "+facultyId);
        try{
            Query query = session.createQuery("from Faculty where emp_id=:id");
            query.setParameter("id",facultyId);
            if(query.getResultList().size()==1){
                Faculty faculty1 = (Faculty)query.getResultList().get(0);
//                System.out.println("FacultyDAOImpl course name : "+faculty1.getCourses().get(0).getName());
                return faculty1.getCourses();
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            session.close();
        }
        return null;
    }
}
