package org.example.Service;

import org.example.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentRegistrationTest {

    @Test
    void shouldsaveStu() {
        // 1. Arrange
        StudentRegistration registry = new StudentRegistration();
        Student newStudent = new Student("Alice", "0001", "IT");

        // 2. Act
        registry.saveStudent(newStudent);

        // 3. Assert
        assertEquals(1, registry.getStudentList().size());
        assertEquals("Alice", registry.findByID("0001").getPersonName());
    }

    @Test
    void shouldremStu() {
        // 1. Arrange
        StudentRegistration registry = new StudentRegistration();
        Student newStudent = new Student("Alice", "0001", "IT");
        registry.saveStudent(newStudent);

        // 2. Act
        registry.removeStudent(newStudent);

        // 3. Assert
        assertEquals(0, registry.getStudentList().size(), "Roster should be empty once the student is removed.");
        assertNull(registry.findByID("0001"));
    }

    @Test
    void shouldNotDupID() {
        // 1. Arrange
        StudentRegistration registry = new StudentRegistration();
        Student original = new Student("Alice", "0001", "IT");
        Student duplicate = new Student("Fake Alice", "0001", "EE"); // Identical ID

        // 2. Act
        registry.saveStudent(original);
        registry.saveStudent(duplicate);

        // 3. Assert
        assertEquals(1, registry.getStudentList().size(), "System should not permit two students sharing the same ID.");
    }
}