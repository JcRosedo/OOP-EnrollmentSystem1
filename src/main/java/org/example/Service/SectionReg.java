package org.example.Service;
import org.example.model.Section;
import org.example.model.Student;

import java.util.*;

public interface SectionReg {
    void save(Section section);
    List<Section> displayAll();
    Section findBySectionName(String sectionName);
    void updateSection(String oldName, Section updatedSection);
    void addStudentToSection(String sectionName, Student student);
    void deleteSection(String sectionName);
}