/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s12;

/**
 * S12 - Printing Payments and Calculating Total Expenditure.
 *
 * @author TUANLEACE180905
 */
public class Payment {

    private int month;         // The month in which the payment was made
    private double payment;    // The amount of the payment
    private double amountOwed; // The remaining amount owed after the payment

    /**
     * Constructs a Payment instance with specified month, payment amount, and
     * amount owed.
     *
     * @param month the month of the payment
     * @param payment the payment amount
     * @param amountOwed the remaining amount owed after the payment
     */
    public Payment(int month, double payment, double amountOwed) {
        this.month = month;               // Initialize the month field
        this.payment = payment;           // Initialize the payment field
        this.amountOwed = amountOwed;     // Initialize the amount owed field
    }

    /**
     * Retrieves the month of the payment.
     *
     * @return the month of the payment
     */
    public int getMonth() {
        return month; // Return the month field
    }

    /**
     * Retrieves the amount of the payment.
     *
     * @return the payment amount
     */
    public double getPayment() {
        return payment; // Return the payment field
    }

    /**
     * Retrieves the remaining amount owed after the payment.
     *
     * @return the remaining amount owed
     */
    public double getAmountOwed() {
        return amountOwed; // Return the amount owed field
    }

    /**
     * Returns a string representation of the Payment instance, formatted to
     * display month, payment amount, and amount owed.
     *
     * @return a formatted string of payment details
     */
    @Override
    public String toString() {
        return String.format("%-8d%-12.2f%-12.2f", month, payment, amountOwed); // Format the output
    }
}
