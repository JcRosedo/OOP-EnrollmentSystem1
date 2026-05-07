package org.example.Service;

import org.example.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuitionRegistrationTest {

    @Test
    void shouldChangeOverPay() {
        // 1. Arrange - student has a balance of 1000
        TuitionRegistration billingService = new TuitionRegistration();
        Student enrolledStudent = new Student("Alice", "0001", "IT");
        enrolledStudent.getTuitionDetails().setBalance(5000.0);

        // 2. Act - student pays more than the outstanding balance
        billingService.makePayment(enrolledStudent, 5500.0);

        //   student should now show a negative balance (credit) of -500
        assertEquals(-500.0, enrolledStudent.getTuitionDetails().getBalance(), "System should reflect a credit balance when overpayment occurs.");
    }
}