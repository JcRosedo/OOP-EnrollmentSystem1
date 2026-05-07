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
        // It will verify if 5 units x PHP 1000 = PHP 5000 with no discount applied
        assertEquals(5000, tuitionService.calculateTuitionFee(5, 0));
    }

    @Test
    void shouldCalcurightTuiWithDisc() {
        //It will verify if PHP 5000 minus 10% scholarship was discounted = PHP 4500
        assertEquals(4500, tuitionService.calculateTuitionFee(5, 0.10));
    }

    @Test
    void shouldPay600() {
        // Arrange - compute and assign the full balance
        double computedFee = tuitionService.calculateTuitionFee(5, 0);
        testStudent.getTuitionDetails().setBalance(computedFee);

        //  Act - processes a partial payment of 600
        tuitionService.makePayment(testStudent, 600);

        //  Assert - A remaining balance should be 5000 - 600 = 4400
        assertEquals(4400, testStudent.getTuitionDetails().getBalance());
    }

    @Test
    void shouldPayFullAmt() {
        testStudent.getTuitionDetails().setBalance(5000);

        tuitionService.makePayment(testStudent, 5000);

        assertTrue(tuitionService.isFullyPaid(testStudent));
    }

    @Test
    void shouldNotBePaidFull() {
        testStudent.getTuitionDetails().setBalance(5000);

        tuitionService.makePayment(testStudent, 1000);

        assertFalse(tuitionService.isFullyPaid(testStudent));
    }
}