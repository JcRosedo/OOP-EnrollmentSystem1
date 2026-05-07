package org.example.model;

public class TuitionFeePayment {
    private double balance;
    private double totalTuitionFee;

    public TuitionFeePayment(double balance) {
        this.balance = balance;
    }

    // Returns the outstanding amount the student still owes
    public double getBalance() {
        return balance;
    }

    // Updates the outstanding amount after a payment is made
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Returns the full assessed tuition for the semester
    public double getTotalTuitionFee() {
        return totalTuitionFee;
    }

    // Sets the full assessed tuition for the semester
    public void setTotalTuitionFee(double totalTuitionFee) {
        this.totalTuitionFee = totalTuitionFee;
    }
}