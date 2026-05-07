package org.example;

import org.example.Service.CourseRegistration;
import org.example.Service.StudentRegistration;
<<<<<<< HEAD
import org.example.Service.TuitionFeePayment;
import org.example.model.Instructor;
import org.example.model.Person;
=======
>>>>>>> d6bbe416be862305820727aff98acf67bc03d08f

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

<<<<<<< HEAD
=======
                Instructor instructor = new Instructor();

        Person person = new Person("2024373751", "Jc Rosedo");

        System.out.printf("Person ID: %s \n", person.getPersonID());
        System.out.printf("Person Name: %s", person.getPersonName());

>>>>>>> d6bbe416be862305820727aff98acf67bc03d08f
    }
}