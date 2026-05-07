package org.example.Service;
import org.example.model.Person;

import java.util.*;

public class StudentRegistration extends Person {
    private final ArrayList<Student> studentLists = new ArrayList();

    public StudentRegistration(){

    }

    public void saveStudent(Student student){
        studentLists.add(student);
    }

    public void updateStudent(Student student){
        for (int i = 0; i < studentLists.size(); i++){
            if (studentLists.get(i).getPersonID() == student.getPersonName()){
                studentLists.set(i,student);
                break;
            }
        }
    }

    public void removeStudent (Student student){
        for (int i = 0; i < studentLists.size(); i++){
            if(studentLists.get(i).getPersonID() == student.getPersonID()){
                studentLists.remove(i);
                break;
            }
        }
    }

    public void displayAllStudent(){
        for (Student s: studentLists){
            System.out.println("Student ID: " + s.getPersonID());
            System.out.println("Student Name: " + s.getPersonName());
            System.out.println("Program: " + s.getProgram());
            System.out.println();
        }
    }




}