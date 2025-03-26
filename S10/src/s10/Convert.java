/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s10;

import java.util.Scanner;

/**
 * S10 - Program to convert number to word
 *
 * @author TUANLEACE180905
 */
public class Convert {

    private long number; // Field to store the numeric value entered by the user
    private final String[] unitsMap = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen" };
    private final String[] tensMap = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety" };

    /**
     * Prompts the user to enter a numeric string and converts it to words.
     * Loops until the user chooses to stop.
     */
    public void getNumber() {
        Scanner sc = new Scanner(System.in);
        boolean stop = false; // Initialize a stop boolean

        do {
            try {
                // Prompt the user to enter a numeric string
                System.out.print("Please enter a string in numeric format: ");
                String input = sc.nextLine().trim();

                // Validate user input
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Input can't be blank, please enter your number again.");
                } else if (!isNumber(input)) {
                    throw new IllegalArgumentException("Input must be a number, please enter your number again.");
                } else {
                    // Convert numeric string to words
                    number = Long.parseLong(input);
                    System.out.println("The converted string: " + convertToWords(number));
                }

                // Ask the user if they want to continue
                String userChoice;
                do {
                    System.out.print("Do you want to continue? (Y/N): ");
                    userChoice = sc.nextLine().toLowerCase();

                    if (!userChoice.equals("y") && !userChoice.equals("n")) {
                        System.out.println("Please only enter Y (Yes) or N (No), enter again.");
                    }
                } while (!userChoice.equals("y") && !userChoice.equals("n"));

                // Check if the user wants to stop if they enter 'n' else the program loop again
                if (userChoice.equals("n")) {
                    stop = true; // Boolean stop set to true, stopping the whole program
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!stop);
    }

    /**
     * Converts a numeric value to its word representation.
     *
     * @param number The numeric value to convert.
     * @return The word representation of the numeric value.
     */
    public String convertToWords(long number) {
        if (number == 0) {
            return "Zero";
        }
        if (number < 0) {
            return "Minus " + convertToWords(Math.abs(number));
        }

        String words = "";

        // Process millions
        if (number / 1000000 > 0) {
            words += convertToWords(number / 1000000) + " Million ";
            number %= 1000000;
            if (number > 0 && number < 100000 && number % 100000 != 0) {
                words += " and ";
            } else {
                words += " ";
            }
        }

        // Process thousands
        if (number / 1000 > 0) {
            words += convertToWords(number / 1000) + " Thousand ";
            number %= 1000;
            if (number > 0 && number < 100 && number % 100 != 0) {
                words += " and ";
            } else {
                words += " ";
            }
        }

        // Process hundreds
        if (number / 100 > 0) {
            words += convertToWords(number / 100) + " Hundred ";
            number %= 100;

            if (number > 0 && number < 10 && number % 10 != 0) {
                words += " and ";
            } else {
                words += " ";
            }
        }

        // Process remaining units
        if (number > 0) {
            if (number < 20) {
                words += unitsMap[(int) number];
            } else {
                words += tensMap[(int) (number / 10)];
                if (number % 10 > 0) {
                    words += " - " + unitsMap[(int) (number % 10)];
                }
            }
        }

        return words.trim().replaceAll(" +", " ");
    }

    /**
     * Checks if the input string contains only numeric digits (0-9).
     *
     * @param input The input string to be checked.
     * @return True if the input consists only of numeric digits, false
     *         otherwise.
     */
    public boolean isNumber(String input) {
        return input.matches("^-?\\d+$");
    }
}
