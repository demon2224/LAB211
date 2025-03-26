/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s02;

import java.util.Scanner;

/**
 * S02 - Reverse a string
 * @author TUANLEACE180905
 */
public class MyLib {

    private static Scanner sc = new Scanner(System.in);

    /**
     * Prompts the user to input a non-empty string.
     * @param msg The prompt message.
     * @param errorMsg The error message for invalid input.
     * @return A non-empty string entered by the user.
     */
    public String getNonEmptyString(String msg, String errorMsg) {
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                return ""; // Allow empty input
            }
        } while (input.isEmpty());
        return input;
    }
    
    /**
     * Validates and retrieves a string input containing only letters, spaces, and underscores,
     * ensuring it also contains at least one letter.
     * @param msg The prompt message
     * @param validationError Error message to display for invalid input format
     * @param contentError Error message to display if input lacks a letter
     * @return A valid string entered by the user
     */
    public String getValidatedAndCheckedString(String msg, String validationError, String contentError) {
        String input;
        while (true) {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
            } else if (!input.matches("[a-zA-Z _]+")) {
                System.out.println(validationError);
            } else if (!input.matches(".*[a-zA-Z]+.*")) {
                System.out.println(contentError);
            } else {
                return input;
            }
        }
    }
}