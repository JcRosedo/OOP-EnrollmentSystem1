package org.example.Service;

import org.example.model.Department;

import java.util.*;

public interface DepartmentReg {
    void save(Department department);
    List<Department> displayAll();
}