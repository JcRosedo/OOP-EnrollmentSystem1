package org.example.Service;

import org.example.model.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class EnrollmentServiceTest {

    @Test
    void shouldRejectEnrWhenFull() {
        // 1. Arrange - set up a section with a limit of 1 student
        Section classSection = new Section("IT1A", 1, null, new ArrayList<>());
        Student firstStudent = new Student("Alice", "S01", "IT");
        Student secondStudent = new Student("Bob", "S02", "IT");

        EnrollmentService enrollmentHandler = new EnrollmentService();

        // 2. Act - enroll first student, then attempt to enroll a second
        enrollmentHandler.enrollStudentInSection(classSection, firstStudent);
        enrollmentHandler.enrollStudentInSection(classSection, secondStudent);

        // 3. Assert - section should still only have 1 student
        assertEquals(1, classSection.getStudentList().size(), "Section should have blocked the 2nd student.");
    }
}