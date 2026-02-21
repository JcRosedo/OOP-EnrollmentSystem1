package org.example.entity;

public class Student {
    private int studentID;
    private String studentName;
    private String program;

    public Student(){

    }

    public Student(int studentID, String studentName, String program){
        this.studentID=studentID;
        this.studentName=studentName;
        this.program=program;
    }

    public void setStudentID(int studentID){
        this.studentID=studentID;
    }

    public int getstudentID(){
        return studentID;
    }

    public void setstudentName(String studentName){
        this.studentName=studentName;
    }

    public String getstudentName(){
        return studentName;
    }

    public void setprogram(String program){
        this.program=program;
    }

    public String getprogram(){
        return program;
    }

    public void display(){
        System.out.printf("Student ID: %d \n", studentID);
        System.out.printf("Student Name: %s \n", studentName);
        System.out.printf("Program: %s \n", program);
    }









}
