/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s12;

import java.util.Scanner;

/**
 * S12 - Printing Payments and Calculating Total Expenditure.
 *
 * @author TUANLEACE180905
 */
public class MyLib {

    // Create a Scanner object for user input
    static Scanner sc = new Scanner(System.in);

    /**
     * Prompts the user for a valid double input and validates it.
     *
     * @param inputMessage the message to prompt the user
     * @return a valid double number entered by the user
     */
    public static double getValidDouble(String inputMessage) {
        double number = 0.0;      // Variable to store the valid double input
        boolean isValid = false;   // Flag to track the validity of the input

        do {
            System.out.println(inputMessage); // Display the input prompt
            try {
                number = sc.nextDouble(); // Attempt to read a double value from user input

                // Check if the number is within the specified range (non-negative)
                if (number < 0.0) {
                    throw new IllegalArgumentException("Error: Value cannot be negative."); // Throw exception if out of range
                }

                isValid = true; // Set flag to true indicating valid input
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // Display specific error message for negative values
                sc.nextLine(); // Clear the invalid input from the scanner
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number."); // Display general error message
                sc.nextLine(); // Clear the invalid input from the scanner
            }
        } while (!isValid); // Continue prompting until valid input is received

        sc.nextLine(); // Clear any newline character remaining in the buffer
        return number; // Return the valid double input
    }
}
