package org.example.model;

public class Student extends Person {
    private String program;
    private TuitionFeePayment tuitionDetails;

    public Student(String PersonName, String PersonID, String program) {
        super(PersonName, PersonID);
        this.program = program;
        this.tuitionDetails = new TuitionFeePayment(0);
    }

    public void setPersonName(String personName) {
        super.setPersonName(personName);
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getProgram() {
        return program;
    }

    public TuitionFeePayment getTuitionDetails() {
        return tuitionDetails;
    }

    public void showStudentInfo() {
        System.out.println("Scholar ID: " + getPersonID());
        System.out.println("Full Name: " + getPersonName());
        System.out.println("Degree Program: " + getProgram() + "\n");
    }

    @Override
    public void mainTask() {
        System.out.println("Student attends classes and completes coursework.");
    }
}