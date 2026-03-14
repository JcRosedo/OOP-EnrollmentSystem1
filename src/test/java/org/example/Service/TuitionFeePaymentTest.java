package org.example.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuitionFeePaymentTest {
    private TuitionFeePayment tuitionFeePayment;

    @BeforeEach
    void setup(){
        tuitionFeePayment = new TuitionFeePayment();
    }
    @Test
    @DisplayName("Calculate Tuition Fee")
    void shouldCalculateCorrectTuitionFeeWithNoDiscount(){
        //ASSERT
        assertEquals(4000,tuitionFeePayment.calculateTuitionFee(4, 0));
    }
    @Test
            void shouldMakeAPaymentWorth500(){
        tuitionFeePayment.calculateTuitionFee(4, 0);
        tuitionFeePayment.makePayment(500);
        //Assert
        assertEquals(3500,tuitionFeePayment.getBalance());
    }

    @Test
    void shouldCheckIfFullyPaid(){
        tuitionFeePayment.calculateTuitionFee(4, 0);
        tuitionFeePayment.makePayment(4000);
        //Assert
        assertTrue(tuitionFeePayment.isFullyPaid());
    }
    @Test
    void shouldCheckIfNotFullyPaid(){
        tuitionFeePayment.calculateTuitionFee(4, 0);
        tuitionFeePayment.makePayment(2000);
        //assert
        assertFalse(tuitionFeePayment.isFullyPaid());
    }


}