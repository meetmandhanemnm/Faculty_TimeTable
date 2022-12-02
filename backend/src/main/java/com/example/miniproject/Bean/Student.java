package com.example.miniproject.Bean;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private Integer rollnumber;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "photograph_path")
    private String photographPath;

    @Column(columnDefinition = "float default 0.0")
    private Float cgpa;

    private Integer totalCredits;

    private Integer graduationYear;

    @OneToMany(mappedBy = "student")
    private List<StudentCourse> studentCourses;

    public Student() {
    }

    public Student(Integer rollnumber, String firstName, String lastName, String email, String photographPath, Float cgpa, Integer totalCredits, Integer graduationYear) {
        this.rollnumber = rollnumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.photographPath = photographPath;
        this.cgpa = cgpa;
        this.totalCredits = totalCredits;
        this.graduationYear = graduationYear;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(Integer rollnumber) {
        this.rollnumber = rollnumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotographPath() {
        return photographPath;
    }

    public void setPhotographPath(String photographPath) {
        this.photographPath = photographPath;
    }

    public Float getCgpa() {
        return cgpa;
    }

    public void setCgpa(Float cgpa) {
        this.cgpa = cgpa;
    }

    public Integer getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(Integer totalCredits) {
        this.totalCredits = totalCredits;
    }

    public Integer getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(Integer graduationYear) {
        this.graduationYear = graduationYear;
    }

    public List<StudentCourse> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(List<StudentCourse> studentCourses) {
        this.studentCourses = studentCourses;
    }
}