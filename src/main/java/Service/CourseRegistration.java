package org.example.Service;
import org.example.entity.Course;

import java.util.*;

public class CourseRegistration {
    private ArrayList <Course> courseList = new ArrayList();

    public CourseRegistration(){

    }

    public void save(Course course){
        courseList.add(course);
    }

    public void displayAll(){
        for (Course c : courseList){
            System.out.println("Course ID: " + c.getcourseID());
            System.out.println("Course Name: " + c.getcourseName());
            System.out.println("Program: " + c.getprogram());
        }
    }

    public void updateCourse(Course course){
        for (int i=0; i<courseList.size(); i++){
            if (courseList.get(i).getcourseID()==course.getcourseID()){
                courseList.set(i,course);
                break;
            }

        }
    }

    public void removeCourse(Course course){
        for (int i=0; i<courseList.size(); i++){
            if (courseList.get(i).getcourseID()==course.getcourseID()){
                courseList.remove(i);
                break;
            }
        }
    }



}