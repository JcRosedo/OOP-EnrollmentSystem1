package org.example.entity;

public class Course extends Person {
    private int courseID;
    private String courseName;
    private String program;

    public Course() {

    }

    @Override
    public void mainTask() {

    }

    public Course(int courseID, String courseName, String program) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.program = program;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setProgram(String Program) {
        this.program = program;
    }

    public String getProgram() {
        return program;
    }

    public void display() {
        System.out.printf("Course ID: %d \n", courseID);
        System.out.printf("Course Name: %s \n", courseName);
        System.out.printf("Program: %s \n", program);
    }
}
