/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s13;

import java.util.Scanner;

/**
 * S13 - String Array Manipulations.
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
        int number = 0;
        boolean isValid = false;
        do {
            System.out.println(inputMessage);
            try {
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
                System.out.println("Invalid input! Please enter a valid number."); // Display general error message
                sc.nextLine(); // Clear the invalid input
            }
        } while (!isValid); // Continue until valid input is received
        sc.nextLine(); // Clear the newline character
        return number; // Return the valid integer
    }

    /**
     * Prompts the user for a string with at least 2 words, each word starting
     * with an uppercase letter, containing only alphabetic characters and
     * spaces, with a total length limit.
     *
     * @param errorMessage The message to display if the input is invalid.
     * @param lengthLimit The maximum allowable length of the string.
     * @return A valid string meeting the specified criteria.
     */
    public static String getValidString(String errorMessage, int lengthLimit) {
        String str = "";
        boolean isValid = false;
        do {
            try {
                str = sc.nextLine().trim(); // Read string input and remove leading/trailing spaces
                if (str.isEmpty()) {
                    throw new IllegalArgumentException(); // Throw exception if empty
                }
                if (str.length() > lengthLimit) {
                    throw new IllegalArgumentException(); // Throw exception if length exceeds limit
                }

                // Check if string contains only alphabetic characters and spaces
                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    if (!Character.isLetter(c) && !Character.isSpaceChar(c)) {
                        throw new IllegalArgumentException(); // Throw if non-letter and non- space
                    }
                }

                // Split string into words
                String[] words = str.split("\\s+"); // Split by one or more spaces
                if (words.length < 2) {
                    throw new IllegalArgumentException(); // Throw if less than 2 words
                }

                // Normalize: Capitalize first letter of each word, lowercase the rest
                StringBuilder normalized = new StringBuilder();
                for (int i = 0; i < words.length; i++) {
                    String word = words[i];
                    if (word.isEmpty()) {
                        throw new IllegalArgumentException(); // Throw if word empty or not starting with uppercase
                    }
                    String normalizedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                    normalized.append(normalizedWord);
                    if (i < words.length - 1) {
                        normalized.append(" "); // Add space between words
                    }
                }
                str = normalized.toString(); // Update str with normalized version

                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() != null ? e.getMessage() : errorMessage);
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid string."); // Display general error message
            }
        } while (!isValid); // Continue until valid input is received
        return str; // Return the valid string
    }
}
