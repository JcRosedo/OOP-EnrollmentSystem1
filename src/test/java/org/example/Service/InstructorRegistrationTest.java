package org.example.Service;

import org.example.model.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class InstructorRegistrationTest {

    @Test
    void shouldsuccessfullyconnectInst() {
        // 1. Arrange - prepare an instructor and an empty section
        Instructor faculty = new Instructor("Sir. JC", "030306", "INTEPROG");
        Section classSection = new Section("IT1A", 30, null, new ArrayList<>());
        InstructorRegistration facultyRegistry = new InstructorRegistration();

        // 2. Act - assign the instructor to the section
        facultyRegistry.assignInstructorToSection(faculty, classSection);

        // 3. Assert - confirm the section now has the correct instructor
        assertNotNull(classSection.getInstructorInCharge());
        assertEquals("SIR. JC", classSection.getInstructorInCharge().getPersonName());
    }
}