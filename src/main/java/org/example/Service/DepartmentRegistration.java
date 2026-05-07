package org.example.Service;

import org.example.model.Department;

import java.util.*;

public class DepartmentRegistration implements DepartmentReg {
    private List<Department> departments;

    public DepartmentRegistration() {
        this.departments = new ArrayList<>();
    }

    @Override
    public void save(Department department) {
        if (department.getInstructorList() == null) {
            department.setInstructorList(new ArrayList<>());
        }
        if (department.getSectionList() == null) {
            department.setSectionList(new ArrayList<>());
        }

        departments.add(department);
        System.out.println("Successful! " + department.getDepartmentName());
    }

    @Override
    public List<Department>displayAll() {
        return this.departments;
    }
}