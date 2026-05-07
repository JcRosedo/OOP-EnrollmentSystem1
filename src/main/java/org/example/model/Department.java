package org.example.model;
import java.util.*;

public class Department {
    private String departmentID;
    private String departmentName;
    private List<Instructor> instructorList;
    private List<Section> sectionList;

    public Department(String departmentID, String departmentName, List<Instructor> instructorList,
                      List<Section> sectionList) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.instructorList = instructorList;
        this.sectionList = sectionList;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Instructor> getInstructorList() {
        return instructorList;
    }

    public void setInstructorList(List<Instructor> instructorList) {
        this.instructorList = instructorList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void showDepartmentInfo() {
        System.out.println("College Code: " + getDepartmentID());
        System.out.println("College Name: " + getDepartmentName());
        System.out.println("Faculty Members: " + getInstructorList());
        System.out.println("Enrolled Sections: " + getSectionList() + "\n");
    }

    @Override
    public String toString() {
        return departmentName + " (ID: " + departmentID + ")";
    }
}