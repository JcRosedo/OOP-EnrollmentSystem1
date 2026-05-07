package org.example.Service;

import org.example.model.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class InstructorRegistrationTest {

    @Test
    void shouldsuccessfullyconnectInst() {
        // 1. Arrange - lagay ng instructor and an empty section
        Instructor faculty = new Instructor("Sir. JC", "030306", "INTEPROG");
        Section classSection = new Section("IT1A", 20, null, new ArrayList<>());
        InstructorRegistration facultyRegistry = new InstructorRegistration();

        // 2. Act - lagay ang instructor sa section
        facultyRegistry.assignInstructorToSection(faculty, classSection);

        // 3. Assert - confirm ang section now has the correct instructor
        assertNotNull(classSection.getInstructorInCharge());
        assertEquals("Sir. JC", classSection.getInstructorInCharge().getPersonName());
    }
}