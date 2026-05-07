package org.example.Service;

import org.example.model.Student;

public interface TuitionReg {
    double calculateTuitionFee(int units, double discounts);
    void makePayment(Student student, double amount);
    double getRemainingBalance(Student student);
    boolean isFullyPaid(Student student);
}