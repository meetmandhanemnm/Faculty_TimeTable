package com.example.miniproject.Bean;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int course_id;

    @Column(unique = true,nullable = false)
    private int course_code;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private int term;

    @Column(nullable = false)
    private int credits;

    @Column(nullable = false)
    private int capacity;

    @OneToMany(mappedBy = "course")
    private List<StudentCourse> studentCourses;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course")
    private List<CourseSchedule> courseSchedules;

    @ManyToOne()
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "course_specialisation", joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "specialisation_id")})
    private List<Specialisation> specialisations;

    public Course(int course_code, String name, String description, int year, int term, int credits, int capacity, List<StudentCourse> studentCourses, List<CourseSchedule> courseSchedules, Faculty faculty, List<Specialisation> specialisations) {
        this.course_code = course_code;
        this.name = name;
        this.description = description;
        this.year = year;
        this.term = term;
        this.credits = credits;
        this.capacity = capacity;
        this.studentCourses = studentCourses;
        this.courseSchedules = courseSchedules;
        this.faculty = faculty;
        this.specialisations = specialisations;
    }

    public Course() {

    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getCourse_code() {
        return course_code;
    }

    public void setCourse_code(int course_code) {
        this.course_code = course_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<StudentCourse> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(List<StudentCourse> studentCourses) {
        this.studentCourses = studentCourses;
    }

    public List<CourseSchedule> getCourseSchedules() {
        return courseSchedules;
    }

    public void setCourseSchedules(List<CourseSchedule> courseSchedules) {
        this.courseSchedules = courseSchedules;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<Specialisation> getSpecialisations() {
        return specialisations;
    }

    public void setSpecialisations(List<Specialisation> specialisations) {
        this.specialisations = specialisations;
    }
}
