package org.example.model;

public class Student extends Person {
    private String program;

    public Student() {

    }
    public Student(String personID, String personName){
    super(personID,personName);
    this.program = program;

}
    public void setprogram(String program) {
        this.program = program;
    }
    public String getprogram() {
        return program;
    }

    public void display() {
        System.out.printf("Student ID: %d \n", getPersonID());
        System.out.printf("Student Name: %d \n", getPersonName());
        System.out.printf("Program: %s \n", program);
    }
}