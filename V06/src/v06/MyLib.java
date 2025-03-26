/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v06;

import java.util.Scanner;

/**
 * V06 - Array and string manipulations.
 *
 * @author TUANLEACE180905
 */
public class MyLib {

    private static Scanner scanner = new Scanner(System.in); // Scanner for user input

    /**
     * Reads an integer within a specified range. Ensures valid numeric input
     * and prevents empty input.
     *
     * @param message The prompt message for the user.
     * @param min The minimum acceptable value.
     * @param max The maximum acceptable value.
     * @return A valid integer within the specified range.
     */
    public static int getInteger(String message, int min, int max) {
        int num;
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                // Ensure input is not empty
                if (input.isEmpty()) {
                    System.out.println(
                            "Input cannot be empty! Please enter a number between " + min + " and " + max + ".");
                    continue;
                }
                num = Integer.parseInt(input);
                // Ensure the number is within the valid range
                if (num >= min && num <= max) {
                    return num;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between " + min + " and " + max + ".");
            }
        }
    }

    /**
     * Reads a valid student name containing only letters, numbers, and spaces.
     * Ensures input is non-empty and does not contain special characters.
     *
     * @param message The prompt message for the user.
     * @return A valid name with normalized spacing.
     */
    public static String getString(String message) {
        String input;
        while (true) {
            System.out.print(message);
            input = scanner.nextLine().trim();
            // Ensure input matches allowed characters (letters, numbers, spaces)
            if (input.matches("[a-zA-Z0-9 ]+")) {
                return input;
            } else {
                System.out.println(
                        "Invalid input! Please enter a valid string, without special characters and empty spaces.");
            }
        }
    }
}
