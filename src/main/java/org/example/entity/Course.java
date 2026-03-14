package org.example.entity;

import org.example.entity.Entity.Person;

public class Course extends Person {

    private String program;

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
