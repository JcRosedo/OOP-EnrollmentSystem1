package org.example.Service;

import org.example.model.Department;
import org.example.model.Section;
import org.example.model.Student;
import java.util.*;

public interface IEnrollmentService {
    void enrollStudentInSection(Section section, Student student);
    void viewDepartmentHierarchy(List<Department> allDepts);
}