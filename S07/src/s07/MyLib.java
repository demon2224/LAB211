/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s07;

import java.util.List;
import java.util.Scanner;

/**
 * Employee Management System.
 *
 * @author TUANLEACE180905
 */
public class MyLib {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * Gets a valid employee ID (format NVxxxx). ID must start with "NV"
     * followed by 4 digits.
     *
     * @param message The prompt message for user input.
     * @return A valid employee ID.
     */
    public static String getValidID(String message) {
        System.out.print(message);
        while (true) {
            String input = sc.nextLine().trim().toUpperCase();
            if (input.matches("NV\\d{4}")) {
                return input;
            }
            System.out.print("--------Erorr! Please id number again (NVxxxx): ");
        }
    }

    /**
     * Gets a valid name (only letters and spaces allowed). Prevents empty input
     * and special characters.
     *
     * @param message The prompt message for user input.
     * @return A valid formatted name.
     */
    public static String getValidString(String message) {
        System.out.print(message);
        while (true) {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.print("--------Erorr! Please name again (Not Null):");
            } else if (!input.matches("[a-zA-Z ]+")) {
                System.out.print("--------Error! Please enter only letters (no numbers or special characters):");
            } else {
                return formatString(input);
            }
        }
    }

    /**
     * Formats string to capitalize first letter of each word.
     *
     * @param input The raw input string.
     * @return A formatted string with proper capitalization.
     */
    public static String formatString(String input) {
        String[] words = input.trim().toLowerCase().split("\\s+");
        StringBuilder formattedString = new StringBuilder();
        for (String word : words) {
            formattedString.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1)).append(" ");
        }
        return formattedString.toString().trim();
    }

    /**
     * Gets a valid salary (must be greater than a given minimum).
     *
     * @param message The prompt message for user input.
     * @param min The minimum salary allowed.
     * @return A valid salary.
     */
    public static double getValidDouble(String message, double min) {
        System.out.print(message);
        while (true) {
            try {
                double value = Double.parseDouble(sc.nextLine().trim());
                if (value > min) {
                    return value;
                }
                System.out.printf("--------Erorr! Please salary again (Salary > 100 USD):", min);
            } catch (NumberFormatException e) {
                System.out.print("--------Error! Please enter a valid number:");
            }
        }
    }

    /**
     * Gets a valid coefficient salary (must be within a specific range).
     *
     * @param message The prompt message for user input.
     * @param min The minimum allowed value.
     * @param max The maximum allowed value.
     * @return A valid coefficient salary.
     */
    public static double getValidDoubleSalary(String message, double min, double max) {
        System.out.print(message);
        while (true) {
            try {
                double value = Double.parseDouble(sc.nextLine().trim());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.printf("-----Erorr! Please coefficients salary again (From 1 to 5): ", min, max);
            } catch (NumberFormatException e) {
                System.out.print("--------Error! Please enter a valid number.");
            }
        }
    }

    /**
     * Gets a valid integer (must be greater than 0).
     *
     * @param message The prompt message for user input.
     * @return A valid integer.
     */
    public static int getValidInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                int value = Integer.parseInt(sc.nextLine().trim());
                if (value > 0) {
                    return value;
                }
                System.out.println("--------Error! Please enter a valid number greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("--------Error! Please enter a valid integer.");
            }
        }
    }

    /**
     * Gets a valid menu choice (only numbers allowed, minimum 0). Prevents
     * users from entering invalid choices.
     *
     * @param message The prompt message for user input.
     * @return A valid menu choice.
     */
    public static int getValidMenuChoice(String message) {
        while (true) {
            System.out.print(message);
            try {
                int value = Integer.parseInt(sc.nextLine().trim());
                if (value >= 0) {
                    return value;
                }
                System.out.println("--------Error! Please enter a valid number (0 or greater).");
            } catch (NumberFormatException e) {
                System.out.println("--------Error! Please enter a valid integer.");
            }
        }
    }
}
