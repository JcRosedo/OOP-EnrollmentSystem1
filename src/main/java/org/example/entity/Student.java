package org.example.entity;

public class Student extends Person {
    private int studentID;
    private String studentName;
    private String program;

    public Student(){

    }

    @Override
    public void mainTask() {

    }

    public Student(int studentID, String studentName, String program){
        this.studentID=studentID;
        this.studentName=studentName;
        this.program=program;
    }

    public void setStudentID(int studentID){
        this.studentID=studentID;
    }

    public int getStudentID(){
        return studentID;
    }

    public void setStudentName(String studentName){
        this.studentName=studentName;
    }

    public String getStudentName(){
        return studentName;
    }

    public void setprogram(String program){
        this.program=program;
    }

    public String getProgram(){
        return program;
    }

    public void display(){
        System.out.printf("Student ID: %d \n", studentID);
        System.out.printf("Student Name: %s \n", studentName);
        System.out.printf("Program: %s \n", program);
    }




}
