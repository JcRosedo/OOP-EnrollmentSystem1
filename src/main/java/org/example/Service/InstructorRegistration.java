package org.example.Service;

import org.example.model.Instructor;
import org.example.model.Section;
import java.util.*;

public class InstructorRegistration implements InstructorReg {
    private List<Instructor> instructors = new ArrayList<>();

    @Override
    public void save(Instructor instructor) {
        instructors.add(instructor);
        System.out.println("Instructor " + instructor.getPersonName() + " saved.");
    }

    @Override
    public List<Instructor> displayAll() {
        if (instructors.isEmpty()) {
            System.out.println("No instructor was found");
        }
        for (Instructor i : instructors) {
            System.out.println("ID: " + i.getPersonID() + " | Name: " + i.getPersonName());
        }
        return instructors;
    }

    @Override
    public Instructor findByID(String id) {
        for (Instructor i : instructors) {
            if (i.getPersonID().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void updateInstructor(String id, Instructor updated) {
        for (int i = 0; i < instructors.size(); i++) {
            if (instructors.get(i).getPersonID().equalsIgnoreCase(id)) {
                instructors.set(i, updated);
                System.out.println("Instructor " + instructors.get(i).getPersonName() + " updated.");
                return;
            }
        }
    }

    @Override
    public void deleteInstructor(String id) {
        for (int i = 0; i < instructors.size(); i++) {
            if (instructors.get(i).getPersonID().equalsIgnoreCase(id)) {
                instructors.remove(i);
                System.out.println("Instructor " + instructors.get(i).getPersonName() + " deleted.");
                return;
            }
        }
        System.out.println("Error: The ID does not match any instructor.");
    }

    @Override
    public void assignInstructorToSection(Instructor instructor, Section section) {
        section.setInstructorInCharge(instructor);
        System.out.println("Success: Faculty member " + instructor.getPersonName() + " assigned to " + section.getSectionName());
    }
}