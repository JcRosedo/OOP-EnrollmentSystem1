package org.example.Service;
import org.example.entity.Course;
import org.example.entity.Entity.Person;

import java.util.*;

public class CourseRegistration extends Person {
    private ArrayList<Course> courseList = new ArrayList();

    public CourseRegistration() {

    }

    public void save(Course course) {
        courseList.add(course);
    }

    public void displayAll() {
        for (Course c : courseList) {
            System.out.println("Person ID: " + getPersonID());
            System.out.println("Person Name: " + getPersonName());
            System.out.println("Program: " + c.getProgram());
            System.out.println();
        }
    }

    public void updateCourse(Course course) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getPersonID() == course.getPersonID()) {
                courseList.set(i, course);
                break;
            }
        }
    }

    public void removeCourse(Course course) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getPersonID() == course.getPersonID()) {
                courseList.remove(i);
                break;
            }
        }
    }
}