package org.example.Service;
import org.example.entity.Person;
import org.example.entity.Student;
import java.util.*;

public class StudentRegistration extends Person {
    private ArrayList<Student> studentLists = new ArrayList();

    public StudentRegistration(){

    }

    @Override
    public void mainTask() {

    }

    public void saveStudent(Student student){
        studentLists.add(student);
    }

    public void updateStudent(Student student){
        for (int i = 0; i < studentLists.size(); i++){
            if (studentLists.get(i).getStudentID() == student.getStudentID()){
                studentLists.set(i,student);
                break;
            }
        }
    }

    public void removeStudent (Student student){
        for (int i = 0; i < studentLists.size(); i++){
            if(studentLists.get(i).getStudentID() == student.getStudentID()){
                studentLists.remove(i);
                break;
            }
        }
    }

    public void displayAllStudent(){
        for (Student s: studentLists){
            System.out.println("Student ID: " + s.getStudentID());
            System.out.println("Student Name: " + s.getStudentName());
            System.out.println("Program: " + s.getProgram());
            System.out.println();
        }
    }




}