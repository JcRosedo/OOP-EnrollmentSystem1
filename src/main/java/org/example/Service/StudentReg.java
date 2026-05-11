package org.example.Service;

import org.example.model.Student;

public interface StudentReg {
    void saveStudent(Student student);
    void displayAllStudent();
    boolean updateStudent(Student student);
    boolean removeStudent(Student student);
}
