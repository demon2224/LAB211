/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v11;

import java.util.Scanner;

/**
 * V11 - Subsystem for listing and searching content files.
 *
 * @author TUANLEACE180905
 */
public class MyLib {
// Create a Scanner object for user input

    static Scanner sc = new Scanner(System.in);

    /**
     * Prompts the user for an integer input within a specified range.
     *
     * @param inputMessage The message to prompt the user.
     * @param errorMessage The message to display if the input is invalid.
     * @param from The minimum acceptable value.
     * @param to The maximum acceptable value.
     * @return A valid integer input within the specified range.
     */
    public static int getValidInt(String inputMessage, String errorMessage, int from, int to) {
        int number = 0; // Variable to store user input
        boolean isValid = false; // Flag to track input validity
        do {
            try {
                System.out.print(inputMessage);
                number = sc.nextInt(); // Read integer input
                // Check if the number is within the specified range
                if (number < from || number > to) {
                    throw new IllegalArgumentException(); // Throw exception if out of range
                }
                isValid = true; // Input is valid
            } catch (IllegalArgumentException e) {
                System.out.println(errorMessage); // Display error message
                sc.nextLine(); // Clear the invalid input
            } catch (Exception e) {
                System.out.println("!!! Invalid input !!!"); // Display general error message
                sc.nextLine(); // Clear the invalid input
            }
        } while (!isValid); // Continue until valid input is received
        sc.nextLine(); // Clear the newline character
        return number; // Return the valid integer
    }
}
