package com.example.miniproject.Bean;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "specialisation")
public class Specialisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "specialisation_code", unique = true, nullable = false)
    private Integer specialisationCode;

    @Column(nullable = false)
    private String name;
    private String description;

    @Column(nullable = false)
    private Integer year;

    @Column(name = "credits_required", nullable = false)
    private Integer creditsRequired;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "specialisations")
    private List<Course> courses;

    public Specialisation() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpecialisationCode() {
        return specialisationCode;
    }

    public void setSpecialisationCode(Integer specialisationCode) {
        this.specialisationCode = specialisationCode;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCreditsRequired() {
        return creditsRequired;
    }

    public void setCreditsRequired(Integer creditsRequired) {
        this.creditsRequired = creditsRequired;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Specialisation(Integer specialisationCode, String name, String description, Integer year, Integer creditsRequired) {
        this.specialisationCode = specialisationCode;
        this.name = name;
        this.description = description;
        this.year = year;
        this.creditsRequired = creditsRequired;
    }
}