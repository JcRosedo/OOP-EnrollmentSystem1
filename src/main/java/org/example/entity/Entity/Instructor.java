package org.example.entity.Entity;

public class Instructor extends Person{

   private String courses;

    public Instructor(){

            this.courses = courses;

    }
    public Instructor(String personID, String personName, String courses){
        super(personID, personName);
    }

    public void setcourses(String courses) {

        this.courses = courses;
    }

    public String getcourses() {
        return courses;
    }
}