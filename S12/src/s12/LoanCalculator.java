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
public class LoanCalculator {

    private Loan loan; //Loan object

    /**
     * Constructor to initialize LoanCalculator with loan details.
     *
     * @param loan the loan details object
     */
    public LoanCalculator(Loan loan) {
        this.loan = loan;
    }

    /**
     * Method to calculate the monthly interest rate.
     *
     * @return the monthly interest rate as a decimal
     */
    public double getMonthlyInterestRate() {
        return this.loan.getAnnualInterestRate() / 100 / 12; // Convert annual rate to monthly
    }

    /**
     * Method to check if the monthly payment is sufficient to cover the
     * interest.
     *
     * @return true if the monthly payment is sufficient; false otherwise
     */
    public boolean isPaymentSufficient() {
        return loan.getMonthlyPayment() > loan.getLoanAmount() * getMonthlyInterestRate();
    }

    /**
     * Method to generate and display the payment schedule.
     */
    public void generatePaymentPlay() {
        System.out.println(String.format("%-8s%-12s%-12s", "Month", "Payment", "Amount Owed"));
        System.out.println("-----------------------------------");
        for (Payment payment : loan.getPayments()) {
            System.out.println(payment);
        }
    }

    /**
     * Method to calculate payments and generate the payment schedule.
     */
    public void calculatePayments() {
        int month = 1; // Month counter
        double remainingLoan = loan.getLoanAmount();

        while (remainingLoan > 0) { // Loop until the loan is fully paid
            double interest = remainingLoan * getMonthlyInterestRate(); // Calculate interest for the current month
            remainingLoan += interest; // Add interest to the loan amount
            double payment = Math.min(loan.getMonthlyPayment(), remainingLoan); // Determine the payment amount for the month
            remainingLoan -= payment; // Subtract the payment from the loan amount

            // Add payment record to the list
            loan.addPayment(new Payment(month++, payment, Math.max(0, remainingLoan)));
        }
    }
}
