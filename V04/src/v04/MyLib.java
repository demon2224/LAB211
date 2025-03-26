/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v04;

import java.util.Scanner;

/**
 * V04 - Program to Manage Doctors.
 *
 * @author TUANLEACE180905
 */
public class MyLib {

    static Scanner sc = new Scanner(System.in);

    /**
     * Gets a valid code starting with "DOC " followed by at most 3 digits.
     *
     * @param msg Prompt message
     * @return Valid code string
     */
    public static String getCode(String msg) {
        String str;
        while (true) { // Infinite loop until a valid input is entered
            System.out.print(msg); // Display the input prompt
            str = sc.nextLine().trim().toUpperCase(); // Read and format input

            // Check if the input is empty
            if (str.isEmpty()) {
                System.out.println("Doctor code must not be empty!");
                continue;
            }

            // Check if the doctor code starts with "DOC "
            if (!str.startsWith("DOC ")) {
                System.out.println("Doctor code must start with 'DOC '.");
                continue;
            }

            // Check the length of the doctor code (should be between 5 and 7 characters)
            if (str.length() < 5 || str.length() > 7) {
                System.out.println("Doctor code must has lenght from 5 to 7!");
                continue;
            }

            // Extract the numeric part after "DOC "
            String numberPart = str.substring(4);

            // Check if the numeric part contains only digits
            if (!numberPart.matches("[0-9]+")) {
                System.out.println("Doctor code must contain only digits after 'DOC '.");
                continue;
            }

            return str; // If all checks pass, return the valid input

        }
    }

    /**
     * Get a valid name input from the user.
     *
     * @param msg The prompt message.
     * @param errMsg The error message to display when the input is invalid.
     * @return Valid input String
     */
    public static String getName(String msg, String errMsg) {
        boolean isValid; // Tracks whether the input is valid
        String str;

        do {
            System.out.print(msg); // Display the input prompt
            str = sc.nextLine().trim();   // Read the entire line
            isValid = true;        // Assume the input is valid initially
            boolean containLetter = false;

            // Check each character in the input string
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i); // Get the current character
                // Validate: letter (A-Z, a-z), space (' '), or underscore ('_')
                if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || c == ' ')) {
                    isValid = false; // Mark as invalid if any character is not allowed
                    break; // Stop checking further
                }

                if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                    containLetter = true;
                }
            }

            // If the input is invalid, display the error message
            if (!isValid || !containLetter) {
                System.out.println(errMsg);
            }
        } while (!isValid); // Repeat until the input is valid

        return str; // Return the valid input
    }

    /**
     * Get an integer from the user with optional min/max validation.
     *
     * @param msg Prompt message
     * @param errMsg Error message for invalid input
     * @param choice 1 to enable min/max check, 0 to disable
     * @param min Minimum allowed value
     * @param max Maximum allowed value
     * @return Valid integer input
     */
    public static int getInterger(String msg, String errMsg, int choice, int min, int max) {
        int n = 0;
        boolean isValid;
        do {
            try {
                isValid = true;

                System.out.print(msg);
                n = Integer.parseInt(sc.nextLine().trim());
                // Check if n is a positive interger
                if (n < 0) {
                    isValid = false;
                    System.out.println(errMsg);
                }
                if (choice == 1) {
                    if (n < min || n > max) {
                        isValid = false;
                        System.out.println(errMsg);
                    }
                }

            } catch (Exception e) {
                // Catch if exception occurs(users do not input number)
                System.out.println(errMsg);
                isValid = false;
            }

        } while (!isValid);
        return n;
    }

    /**
     * Get a valid choice input from the user (yes or no).
     *
     * @param msg The prompt message.
     * @param errMsg The error message to display when the input is invalid.
     * @return 1 for "yes" and 0 for "no".
     */
    public static int getChoice(String msg, String errMsg) {
        int choice = 0;
        boolean flag;

        do {
            flag = true;
            System.out.print(msg);

            try {
                choice = Integer.parseInt(sc.nextLine().trim());

                if (choice < 1 || choice > 5) {
                    System.out.println(errMsg);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println(errMsg);
                flag = false;
            }
        } while (!flag);

        return choice;
    }

}
