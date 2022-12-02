package com.example.miniproject.Service;

import com.example.miniproject.Bean.Faculty;
import com.example.miniproject.DAO.FacultyDAO;
import com.example.miniproject.DAO.implementation.FacultyDAOImpl;

public class FacultyService {
    FacultyDAO facultyDao = new FacultyDAOImpl();
    public int loginFaculty(Faculty faculty){
        return  facultyDao.loginFaculty(faculty);
    }
}
