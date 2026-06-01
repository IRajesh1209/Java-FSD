package com.rajesh;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String course;

    public Student() {}

    public Student(String name, String course) {
        this.name = name;
        this.course = course;
    }

    // ✅ Getters & Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getCourse() { return course; }

    public void setName(String name) { this.name = name; }
    public void setCourse(String course) { this.course = course; }
}