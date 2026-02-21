package org.example;

import org.example.entity.Course;
import org.example.entity.Student;
import org.example.Service.CourseRegistration;
import org.example.Service.StudentRegistration;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        StudentRegistration studentRegis = new StudentRegistration();
        CourseRegistration courseRegis = new CourseRegistration();

        Student stud1 = new Student(2022317151, "John Doe", "Information Technology");
        Student stud2 = new Student(2022317159, "Jane Doe", "Information Technology");

        studentRegis.saveStudent(stud3);
        studentRegis.saveStudent(stud4);

        studentRegis.displayAllStudent();

        Course c1 = new Course(0001, "Integrative Programming", "Information Technology");
        courseRegis.save(c1);

        courseRegis.displayAll();




    }
}