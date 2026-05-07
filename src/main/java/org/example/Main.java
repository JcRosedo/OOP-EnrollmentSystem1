package org.example;
import org.example.Service.*;
import org.example.model.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        StudentRegistration studentRegis = new StudentRegistration();
        CourseRegistration courseRegis = new CourseRegistration();
        DepartmentRegistration departmentRegis = new DepartmentRegistration();
        SectionRegistration sectionRegis = new SectionRegistration();
        InstructorRegistration instructorRegis = new InstructorRegistration();
        TuitionRegistration tuitionRegis = new TuitionRegistration();
        IEnrollmentService enrollmentService = new EnrollmentService();


        Registrar registrar = new Registrar(studentRegis, courseRegis, departmentRegis, sectionRegis, tuitionRegis, enrollmentService);
        HumanR humanR = new HumanR(instructorRegis);

        Scanner input = new Scanner(System.in);
        boolean check = true;

        while (check){
            try {

                System.out.println("\n==================================");
                System.out.println("     CAMPUS Enrollment System     ");
                System.out.println("==================================");
                System.out.println("[1] Registrar Operations (Student / Section / Department)");
                System.out.println("[2] HR Portal (Faculty Management)");
                System.out.println("[3] Exit System");
                System.out.print("Select Menu: ");

                int portalChoice = input.nextInt();
                input.nextLine();

                if (portalChoice == 1) {
                    boolean regLoop = true;
                    while (regLoop) {
                        System.out.println("\n=== REGISTRAR DASHBOARD ===");
                        System.out.println("[1] Save Student\n[2] Display Student List\n[3] Update Student Record\n[4] Delete Student\n[5] Create Academic Section\n" +
                                "[6] Enroll Student in a Section\n[7] Check Account Balance\n[8] Settle Payment\n[9] Display Institutional Hierarchy"
                                + "\n[10] Establish Department\n[11] Create Subject/Course\n[12] Modify Course\n[13] Delete Course\n" +
                                "[14] Course Catalog\n[15] Return to Main Menu");
                        System.out.print("Select Action: ");
                        int regAction = input.nextInt();
                        input.nextLine();

                        switch (regAction) {
                            case 1:
                                System.out.print("Enter Full Name: ");
                                String name = input.nextLine();

                                System.out.print("Enter Student ID #: ");
                                String ID = input.nextLine();

                                System.out.print("Enter Student Program: ");
                                String program = input.nextLine();

                                registrar.saveStudent(new Student(name, ID, program));
                                break;
                            case 2:
                                System.out.println("\n=== Student Directory ===");
                                registrar.displayAllStudent();
                                break;
                            case 3:
                                System.out.print("Enter Student ID to change: ");
                                String modifyID = input.nextLine();

                                Student selectedStudent = studentRegis.findByID(modifyID);

                                if (selectedStudent != null) {
                                    System.out.println("Selected Profile: " + selectedStudent.getPersonName());
                                    System.out.print("Update Name: ");
                                    String uPdateName = input.nextLine();
                                    System.out.print("Update Program: ");
                                    String uPdateProgram = input.nextLine();

                                    selectedStudent.setPersonName(uPdateName);
                                    selectedStudent.setProgram(uPdateProgram);

                                    System.out.println("Success: Record modified. " + modifyID + " updated to " + uPdateName);
                                } else {
                                    System.out.println("Warning: Student ID # " + modifyID + " does not exist in the database!");
                                }
                                break;
                            case 4:
                                System.out.print("Enter Student ID to delete: ");
                                String deleteStudentID = input.nextLine();
                                registrar.removeStudent(deleteStudentID);
                                break;

                            case 5:
                                System.out.println("\n--- New Section ---");
                                System.out.print("New Section Name: ");
                                String newSection = input.nextLine();
                                System.out.print("Enter Maximum Allocation: ");
                                int maxCap = input.nextInt();
                                input.nextLine();

                                Instructor chosenInstructor = null;
                                Course chosenCourse = null;
                                Department chosenDept = null;

                                while (chosenInstructor == null) {
                                    instructorRegis.displayAll();
                                    System.out.print("Enter Instructor ID: ");
                                    chosenInstructor = instructorRegis.findByID(input.nextLine());
                                    if (chosenInstructor == null) System.out.println("Error: Instructor ID not recognized. Try again.");
                                }

                                while (chosenCourse == null) {
                                    registrar.displayAll();
                                    System.out.print("Enter Course ID: ");
                                    chosenCourse = courseRegis.findByID(input.nextLine());
                                    if (chosenCourse == null) System.out.println("Error: Course ID not recognized. Try again.");
                                }

                                while (chosenDept == null) {
                                    registrar.displayAllDepts();
                                    System.out.print("Enter Department Name: ");
                                    chosenDept = registrar.findDeptByName(input.nextLine());
                                    if (chosenDept == null) System.out.println("Error: Department not found. Try again.");
                                }

                                Section newSec = new Section(newSection, maxCap, chosenInstructor, new ArrayList<>());
                                newSec.setCourse(chosenCourse);
                                chosenDept.getSectionList().add(newSec);

                                sectionRegis.save(newSec);

                                System.out.println("LOG: Section " + newSection + " stored in directory.");
                                break;
                            case 6:
                                input.nextLine();
                                System.out.print("Enter Section Name for Enrollment: ");
                                String secName = input.nextLine().trim();
                                Section foundSec = sectionRegis.findBySectionName(secName);

                                if (foundSec == null) {
                                    System.out.println("Error: Section '" + secName + "' not found!");
                                    System.out.println("Action: Initialize Section using action 5 first.");
                                } else {
                                    if (foundSec.getStudentList().size() >= foundSec.getMaxCapacity()) {
                                        System.out.println("Action Denied: " + secName + " is at full capacity (" + foundSec.getMaxCapacity() + ")");
                                        break;
                                    }

                                    boolean isEnrolled = false;
                                    while (!isEnrolled) {
                                        System.out.print("\nEnter Student ID to enroll: ");
                                        String sID = input.nextLine().trim();
                                        Student record = studentRegis.findByID(sID);

                                        if (record == null) {
                                            System.out.println("Error: Student ID " + sID + " not recognized!");
                                            System.out.print("Try another ID? (y/n): ");
                                            if (input.nextLine().equalsIgnoreCase("n")) {
                                                break;
                                            }
                                            continue;
                                        }

                                        System.out.print("Enter Name: ");
                                        String sName = input.nextLine().trim();
                                        if (!sName.equalsIgnoreCase(record.getPersonName())) {
                                            System.out.println("Warning: Name mismatch. Verify credentials.");
                                            continue;
                                        }

                                        System.out.print("Enter Program: ");
                                        String sProg = input.nextLine().trim();
                                        if (!sProg.equalsIgnoreCase(record.getProgram())) {
                                            System.out.println("Warning: Program mismatch. Verify credentials.");
                                            continue;
                                        }

                                        int unitCount;
                                        if (foundSec.getCourse() != null) {
                                            unitCount = foundSec.getCourse().getUnits();
                                            System.out.println("Course Identified: " + foundSec.getCourse().getCourseName());
                                            System.out.println("Allocated Units: " + unitCount);
                                        } else {
                                            System.out.println("Info: No linked course found.");
                                            System.out.print("Enter units manually: ");
                                            unitCount = input.nextInt();
                                            input.nextLine();
                                        }

                                        registrar.calculateAndSetTuition(record, unitCount);
                                        registrar.enrollStudent(foundSec, record);
                                        isEnrolled = true;
                                    }
                                }
                                break;
                            case 7:
                                System.out.print("Enter Student ID to view balance: ");
                                String checkID = input.nextLine();
                                registrar.checkStudentBalance(checkID);
                                break;
                            case 8:
                                System.out.print("Enter Student ID: ");
                                String payID = input.nextLine();
                                System.out.print("Enter payment amount: ");
                                double amount = input.nextDouble();
                                input.nextLine();
                                registrar.processStudentPayment(payID, amount);
                                break;
                            case 9:
                                registrar.displayHierarchy();
                                break;
                            case 10:
                                String deptName = "";
                                boolean isUnique = false;

                                while (!isUnique) {
                                    System.out.print("Enter Department Name: ");
                                    deptName = input.nextLine().trim();

                                    if (deptName.isEmpty()) continue;

                                    if (registrar.findDeptByName(deptName) != null) {
                                        System.out.println("Error: Department '" + deptName + "' exists. Use a unique identifier.");
                                    } else {
                                        isUnique = true;
                                    }
                                }

                                System.out.print("Enter Department ID: ");
                                String dID = input.nextLine();

                                Department newDept = new Department(dID, deptName, new ArrayList<>(), new ArrayList<>());

                                registrar.saveDept(newDept);

                                System.out.println("Success: Department " + deptName + " established!");
                                break;
                            case 11:
                                System.out.println("\n--- Add Course to Catalog ---");
                                System.out.print("Enter Course ID: ");
                                String newCID = input.nextLine();

                                if (courseRegis.findByID(newCID) != null) {
                                    System.out.println("Error: Course ID '" + newCID + "' exists in the directory!");
                                    System.out.println("Aborting registration.");
                                    break;
                                }

                                System.out.print("Enter Course Title: ");
                                String newCName = input.nextLine();
                                System.out.print("Enter Program: ");
                                String newCProg = input.nextLine();
                                System.out.print("Enter Unit Count: ");
                                int creditUnits = input.nextInt();
                                input.nextLine();

                                Course courseObj = new Course(newCID, newCName, newCProg, creditUnits);
                                courseRegis.save(courseObj);
                                System.out.println("LOG: Course " + newCID + " added to registry.");
                                break;
                            case 12:
                                System.out.println("\n--- Modify Existing Course ---");
                                System.out.print("Enter Course ID to update: ");
                                String upID = input.nextLine();
                                Course courseToModify = courseRegis.findByID(upID);

                                if (courseToModify != null) {
                                    System.out.println("Active Record: " + courseToModify.getCourseName());
                                    System.out.print("Enter New Title: ");
                                    String upName = input.nextLine();
                                    System.out.print("Enter New Program: ");
                                    String upProg = input.nextLine();
                                    System.out.print("Enter New Unit Count: ");
                                    int upUnits = input.nextInt();
                                    input.nextLine();

                                    courseToModify.setCourseName(upName);
                                    courseToModify.setCourseProgram(upProg);
                                    courseToModify.setUnits(upUnits);

                                    System.out.println("Success: Course record updated.");
                                } else {
                                    System.out.println("Error: Course ID [" + upID + "] could not be found.");
                                }
                                break;
                            case 13:
                                System.out.println("\n--- Remove from Catalog ---");
                                System.out.print("Enter Course ID to remove: ");
                                String remID = input.nextLine();
                                courseRegis.removeCourse(remID);
                                break;
                            case 14:
                                System.out.println("\n--- Master Catalog List ---");
                                registrar.displayAll();
                                break;
                            case 15:
                                regLoop = false;
                                break;
                        }
                    }

                } else if (portalChoice == 2) {
                    boolean hrLoop = true;
                    while (hrLoop) {
                        System.out.println("\n=== HUMAN RESOURCES PORTAL ===");
                        System.out.println("[1] Hire Faculty\n[2] Faculty Roster\n[3] Modify Faculty Profile\n[4] " +
                                "Remove Faculty Profile\n[5] Assign Instructor to Section\n[6] Return to Main Menu");
                        System.out.print("Select Action: ");
                        int hrAction = input.nextInt();
                        input.nextLine();

                        switch (hrAction) {

                            case 1:
                                System.out.println("\n=== Hiring Record ===");
                                System.out.print("Enter ID: ");
                                String insID = input.nextLine();

                                if (instructorRegis.findByID(insID) != null) {
                                    System.out.println("Error: Instructor ID '" + insID + "' already exists.");
                                    System.out.println("Aborting process. Use a unique identifier.");
                                    break;
                                }

                                System.out.print("Faculty Name: ");
                                String insName = input.nextLine();

                                String linkedCourseName = "";
                                boolean subjectFound = false;
                                boolean aborted = false;

                                while (!subjectFound) {
                                    System.out.println("\n--- Course Catalog ---");
                                    registrar.displayAll();

                                    System.out.print("Enter Course ID to link to specialization (or type 'cancel'): ");
                                    String targetID = input.nextLine();

                                    if (targetID.equalsIgnoreCase("cancel")) {
                                        System.out.println("Action: Process terminated by user.");
                                        aborted = true;
                                        break;
                                    }

                                    Course matchedCourse = courseRegis.findByID(targetID);
                                    if (matchedCourse != null) {
                                        linkedCourseName = matchedCourse.getCourseName();
                                        subjectFound = true;
                                    } else {
                                        System.out.println("Error: Course ID '" + targetID + "' does not exist. Try again.");
                                    }
                                }

                                if (subjectFound && !aborted) {
                                    Instructor newIns = new Instructor(insName, insID, linkedCourseName);
                                    instructorRegis.save(newIns);
                                    System.out.println("\nSuccess: " + insName + " [" + insID + "] hired to teach " + linkedCourseName);
                                }
                                break;
                            case 2:
                                System.out.println("\n=== Active Faculty Roster ===");
                                humanR.displayAllInstructors();
                                break;
                            case 3:
                                System.out.print("Enter Instructor ID to modify: ");
                                String upID = input.nextLine();
                                Instructor instructorToEdit = instructorRegis.findByID(upID);

                                if (instructorToEdit != null) {
                                    System.out.println("Editing: " + instructorToEdit.getPersonName());

                                    System.out.print("Enter Name: ");
                                    String newName = input.nextLine();

                                    String newCourseName = "";
                                    while (true) {
                                        System.out.print("Enter Course ID for specialization: ");
                                        String targetCID = input.nextLine();
                                        Course validC = courseRegis.findByID(targetCID);

                                        if (validC != null) {
                                            newCourseName = validC.getCourseName();
                                            break;
                                        }
                                        System.out.println("Error: '" + targetCID + "' is invalid.");
                                    }

                                    instructorToEdit.setPersonName(newName);
                                    instructorToEdit.setCourses(newCourseName);

                                    System.out.println("Success: Record for " + newName + " updated with new course assignment.");
                                } else {
                                    System.out.println("Error: Faculty ID not found.");
                                }
                                break;
                            case 4:
                                System.out.print("Enter Instructor ID to delete: ");
                                String deleteID = input.nextLine();
                                humanR.removeInstructor(deleteID);
                                break;
                            case 5:
                                System.out.println("\n--- Assign to Section ---");

                                List<Instructor> insList = instructorRegis.displayAll();
                                if (insList.isEmpty()) break;

                                System.out.print("Enter Instructor ID: ");
                                String targetID = input.nextLine();
                                Instructor selectedIns = instructorRegis.findByID(targetID);

                                if (selectedIns == null) {
                                    System.out.println("Error: Instructor not found!");
                                    break;
                                }

                                List<Section> secList = sectionRegis.displayAll();
                                if (secList.isEmpty()) {
                                    System.out.println("Info: No active sections found.");
                                    break;
                                }

                                System.out.print("Enter Section Name: ");
                                String targetSec = input.nextLine();
                                Section selectedSec = sectionRegis.findBySectionName(targetSec);

                                if (selectedSec == null) {
                                    System.out.println("Error: Section not found!");
                                    break;
                                }

                                instructorRegis.assignInstructorToSection(selectedIns, selectedSec);
                                break;
                            case 6:
                                hrLoop = false;
                                break;
                        }
                    }

                } else if (portalChoice == 3) {
                    check = false;
                    System.out.println("Exiting portal. Terminating connection.");
                } else {
                    System.out.println("Error: Invalid option selected.");
                }

            } catch (InputMismatchException jc) {
                System.out.println("Error: Invalid data type detected. Please try again.");
                input.nextLine();
            }
        }
    }
}