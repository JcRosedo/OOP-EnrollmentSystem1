package org.example.Service;

import org.example.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuitionFeePaymentTest {
    private TuitionRegistration tuitionService;
    private Student testStudent;

    @BeforeEach
    void setup() {
        // Initialize the tuition service and a sample student before each test
        tuitionService = new TuitionRegistration();
        testStudent = new Student("Test Student", "0102", "IT");
    }

    @Test
    void shouldCalcurightTuiNoDisc() {
        // Verify: 5 units x PHP 1000 = PHP 5000 with no discount applied
        assertEquals(5000, tuitionService.calculateTuitionFee(5, 0));
    }

    @Test
    void shouldCalcurightTuiWithDisc() {
        // Verify: PHP 5000 minus 10% scholarship discount = PHP 4500
        assertEquals(4500, tuitionService.calculateTuitionFee(5, 0.10));
    }

    @Test
    void shouldPay600() {
        // 1. Arrange - compute and assign the full balance
        double computedFee = tuitionService.calculateTuitionFee(5, 0);
        testStudent.getTuitionDetails().setBalance(computedFee);

        // 2. Act - process a partial payment of 600
        tuitionService.makePayment(testStudent, 600);

        // 3. Assert - remaining balance should be 5000 - 600 = 4400
        assertEquals(4400, testStudent.getTuitionDetails().getBalance());
    }

    @Test
    void shouldPayFullAmt() {
        // 1. Arrange
        testStudent.getTuitionDetails().setBalance(5000);

        // 2. Act - pay the full amount
        tuitionService.makePayment(testStudent, 5000);

        // 3. Assert - account should now be fully settled
        assertTrue(tuitionService.isFullyPaid(testStudent));
    }

    @Test
    void shouldNotBePaidFull() {
        // 1. Arrange
        testStudent.getTuitionDetails().setBalance(5000);

        // 2. Act - pay only a portion of the balance
        tuitionService.makePayment(testStudent, 1000);

        // 3. Assert - account should still have an outstanding balance
        assertFalse(tuitionService.isFullyPaid(testStudent));
    }
}