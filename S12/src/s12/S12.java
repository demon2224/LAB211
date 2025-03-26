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
public class S12 {

    /**
     * Main method to run the program
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Prompt the user to enter the remaining mortgage value and validate the input
        double loanAmount = MyLib.getValidDouble("What is the value left on the mortgage?");

        // Prompt the user to enter the annual interest rate and validate the input
        double annualInterestRate = MyLib.getValidDouble("What is the annual interest rate of the loan, in percent?");

        boolean isValid;
        do {
            isValid = false;
            // Prompt the user to enter the monthly payment amount and validate the input
            double monthlyPayment = MyLib.getValidDouble("What is the monthly payment?");

            // Create a LoanDetails instance with the provided inputs
            Loan loan = new Loan(loanAmount, annualInterestRate, monthlyPayment);

            // Create an instance of LoanCalculator with the user-provided loan details
            LoanCalculator Calculator = new LoanCalculator(loan);

            // Check if the monthly payment is sufficient to cover the loan payments
            if (!Calculator.isPaymentSufficient()) {
                // Inform the user that the payment is insufficient
                System.out.println("Error: The monthly payment is not enough to pay off the loan.");
                isValid = true;
            } else {
                // Calculate the loan payments and generate a payment plan
                Calculator.calculatePayments();
                Calculator.generatePaymentPlay(); // Display the payment schedule
            }

        } while (isValid);

    }
}
