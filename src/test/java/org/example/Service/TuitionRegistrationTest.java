package org.example.Service;

import org.example.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuitionRegistrationTest {

    @Test
    void shouldChangeOverPay() {
        // 1. Arrange - student has a balance of 1000
        TuitionRegistration billingService = new TuitionRegistration();
        Student enrolledStudent = new Student("Alice", "S01", "IT");
        enrolledStudent.getTuitionDetails().setBalance(1000.0);

        // 2. Act - student pays more than the outstanding balance
        billingService.makePayment(enrolledStudent, 1500.0);

        // 3. Assert - account should show a negative balance (credit) of -500
        assertEquals(-500.0, enrolledStudent.getTuitionDetails().getBalance(), "System should reflect a credit balance when overpayment occurs.");
    }
}