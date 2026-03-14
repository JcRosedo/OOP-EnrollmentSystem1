package org.example.entity;

public class Course extends Person {
    private int courseID;
    private String courseName;
    private String program;

    public Course() {

public class Course extends Person {

    @Override
    public void mainTask() {

    }

    public Course(int courseID, String courseName, String program) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.program = program;
    }

    public Course() {

    }

    public Course (String PersonID, String PersonName, String program) {
        super(PersonID, PersonName);

        this.program = program;
    }

    public void setProgram(String Program) {
        this.program = program;
    }

    public String getProgram() {
        return program;
    }

    public void display() {
        System.out.printf("Course ID: %d \n", getPersonID());
        System.out.printf("Course Name: %s \n", getPersonName());
        System.out.printf("Program: %s \n", program);
    }
}
