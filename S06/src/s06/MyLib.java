/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s06;

import java.util.Scanner;

/**
 * S06 - Array Manipulations.
 *
 * @author TUANLEACE180905
 */
public class MyLib {

    private static Scanner sc = new Scanner(System.in);

    /**
     * Prompts the user to input an integer.
     *
     * @param msg The prompt message.
     * @param errorMsg The error message for invalid input.
     * @return The integer entered by the user.
     */
    public static int getInteger(String msg, String errorMsg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(errorMsg);
            }
        }
    }

    /**
     * Prompts the user to input an integer within a range.
     *
     * @param msg The prompt message.
     * @param errorMsg The error message for invalid input.
     * @param min The minimum allowed value.
     * @param max The maximum allowed value.
     * @return The integer entered by the user within the range.
     */
    public static int getIntegerInRange(String msg, String errorMsg, int min, int max) {
        while (true) {
            int value = getInteger(msg, errorMsg);
            if (value >= min && value <= max) {
                return value;
            } else {
                System.out.println(errorMsg);
            }
        }
    }

    /**
     * Get the valid range when max > min, ensuring the input is not empty and is a valid integer.
     * @param minMsg Prompt message for the minimum value.
     * @param maxMsg Prompt message for the maximum value.
     * @param errorMsg Error message for invalid input.
     * @param array The MyArray instance used to check if values exist in the specified range.
     * @return An array containing the minimum and maximum values, where max > min. 
     *         If the user enters an empty value or an invalid number, they are prompted again.
     */
    public static int[] getValidRange(String minMsg, String maxMsg, String errorMsg) {
        int min, max;

        // Check minium input value
        while (true) {
            System.out.print(minMsg);
            String minInput = sc.nextLine().trim();
            if (minInput.isEmpty()) {
                System.out.println("Minimum cannot be empty.");
                continue;
            }
            if (!minInput.matches("-?\\d+")) {  // Check if it is an integer
                System.out.println("Value must be integer.");
                continue;
            }
            min = Integer.parseInt(minInput);
            break;
        }

        // Check maximum input value
        while (true) {
            System.out.print(maxMsg);
            String maxInput = sc.nextLine().trim();
            if (maxInput.isEmpty()) {
                System.out.println("Maximum cannot be empty.");
                continue;
            }
            if (!maxInput.matches("-?\\d+")) {  // Check if it is an integer
                System.out.println("Value must be integer.");
                continue;
            }
            max = Integer.parseInt(maxInput);
            if (max > min) {
                return new int[]{min, max};
            } else {
                System.out.println(errorMsg);
            }
        }
    }

    /**
     * Checks if the array is not empty. Prints a message if the array is empty.
     *
     * @param array The instance of MyArray to check.
     * @return True if the array is not empty, false otherwise.
     */
    public static boolean checkArrayNotEmpty(MyArray array) {
        if (array.isEmpty()) {
            System.out.println("Array is empty.");
            return false;
        }
        return true;
    }
}
