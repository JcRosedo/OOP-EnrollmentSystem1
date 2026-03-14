package org.example.entity;

import org.example.entity.Entity.Person;

public class Student extends Person {

    private String program;

    public Student(){

    }

    public Student(String PersonID, String PersonName, String program){
        super(PersonID, PersonName);
        this.program=program;
    }

    public void setprogram(String program){
        this.program=program;
    }

    public String getProgram(){
        return program;
    }

    public void display(){
        System.out.printf("Student ID: %d \n", getPersonID());
        System.out.printf("Student Name: %s \n", getPersonName());
        System.out.printf("Program: %s \n", program);
    }









}
