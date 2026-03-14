package org.example;

import org.example.entity.Course;
import org.example.entity.Entity.Instructor;
import org.example.entity.Entity.Person;
import org.example.entity.Student;
import org.example.Service.CourseRegistration;
import org.example.Service.StudentRegistration;
import Service.TuitionFeePayment;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        TuitionFeePayment tuitionFeePayment = new TuitionFeePayment();
        System.out.println(tuitionFeePayment.calculateTuitionFee(4, 0));
        tuitionFeePayment.makePayment(2000);
        System.out.println(tuitionFeePayment.getBalance());


        StudentRegistration studentRegistrar = new StudentRegistration();
        CourseRegistration courseRegistrar = new CourseRegistration();

       // Student student2 = new Student(030306, "Jane Doe", "Information Technology");

        //studentRegistrar.saveStudent(student1);
       // studentRegistrar.saveStudent(student2);

       studentRegistrar.displayAllStudent();

        Course cor1 = new Course("00011", "Integrative Programming", "Information Technology");
        courseRegistrar.save(cor1);

        courseRegistrar.displayAll();

    }
}