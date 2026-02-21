package org.example.Service;
import org.example.entity.Student;
import java.util.*;

public class StudentRegistration {
    private ArrayList<Student> studentLists = new ArrayList();

    public StudentRegistration(){

    }

    public void saveStudent(Student student){
        studentLists.add(student);
    }

    public void updateStudent(Student student){
        for (int i = 0; i < studentLists.size(); i++){
            if (studentLists.get(i).getstudentID() == student.getstudentID()){
                studentLists.set(i,student);
                break;
            }
        }
    }

    public void removeStudent (Student student){
        for (int i = 0; i < studentLists.size(); i++){
            if(studentLists.get(i).getstudentID() == student.getstudentID()){
                studentLists.remove(i);
                break;
            }
        }
    }

    public void displayAllStudent(){
        for (Student s: studentLists){
            System.out.println("Student ID: " + s.getstudentID());
            System.out.println("Student Name: " + s.getstudentName());
            System.out.println("Program: " + s.getprogram());
            System.out.println();
        }
    }




}