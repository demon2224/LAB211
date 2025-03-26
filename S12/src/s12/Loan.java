/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s12;

import java.util.ArrayList;

/**
 * S12 - Printing Payments and Calculating Total Expenditure.
 *
 * @author TUANLEACE180905
 */
public class Loan {

    private double loanAmount;               // Total loan amount
    private double annualInterestRate;       // Annual interest rate as a percentage
    private double monthlyPayment;           // Monthly payment amount
    private ArrayList<Payment> payments;     // List of payments

    /**
     * Constructs a Loan object with the specified loan amount, annual interest
     * rate, and monthly payment.
     *
     * @param loanAmount the total loan amount
     * @param annualInterestRate the annual interest rate in percentage
     * @param monthlyPayment the monthly payment amount
     */
    public Loan(double loanAmount, double annualInterestRate, double monthlyPayment) {
        this.loanAmount = loanAmount;
        this.annualInterestRate = annualInterestRate;
        this.monthlyPayment = monthlyPayment;
        this.payments = new ArrayList<>();
    }

    /**
     * Gets the total loan amount.
     *
     * @return the loan amount.
     */
    public double getLoanAmount() {
        return loanAmount;
    }

    /**
     * Sets the total loan amount.
     *
     * @param loanAmount the loan amount to set.
     */
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * Gets the annual interest rate for the loan.
     *
     * @return the annual interest rate.
     */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /**
     * Sets the annual interest rate for the loan.
     *
     * @param annualInterestRate the annual interest rate to set (percentage).
     */
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * Gets the monthly payment amount.
     *
     * @return the monthly payment amount.
     */
    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    /**
     * Sets the monthly payment amount.
     *
     * @param monthlyPayment the monthly payment amount to set.
     */
    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    /**
     * Gets the list of payments made towards the loan.
     *
     * @return an ArrayList of payments.
     */
    public ArrayList<Payment> getPayments() {
        return payments;
    }

    /**
     * Adds a new payment to the loan payment history.
     *
     * @param payment the payment to add.
     */
    public void addPayment(Payment payment) {
        this.payments.add(payment);
    }
}
