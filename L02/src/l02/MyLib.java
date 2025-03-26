/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l02;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * LO2 - Create a Java console program to manage students.
 *
 * @author TUANLEACE180905
 */
public class MyLib {

    // Create a Scanner object for user input
    private static Scanner sc = new Scanner(System.in);

    /**
     * Prompts the user for an integer input within a specified range.
     *
     * @param prompt The message to prompt the user.
     * @param errorMsg The message to display if the input is invalid.
     * @param min The minimum acceptable value.
     * @param max The maximum acceptable value.
     * @return A valid integer input within the specified range.
     */
    public static int getInt(String prompt, String errorMsg, int min, int max) {
        int number = 0;
        boolean isValid = false;
        do {
            try {
                System.out.print(prompt);
                number = Integer.parseInt(sc.nextLine().trim());
                if (number < min || number > max) {
                    throw new IllegalArgumentException();
                }
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(errorMsg);
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        } while (!isValid);
        return number;
    }

    /**
     * Prompts the user for a valid student ID.
     *
     * @param inputMessage The message to prompt the user.
     * @param lengthLimit The required length of the ID.
     * @return A valid student ID that meets the specified criteria.
     */
    public static String getValidID(String inputMessage, int lengthLimit) {
        String str = ""; // Initialize an empty string to store user input
        boolean isValid = false; // Initialize a flag to track input validity
        do {
            try {
                System.out.print(inputMessage);
                str = sc.nextLine().trim(); // Read and trim the user input
                if (str.isEmpty()) {
                    throw new IllegalArgumentException("Input cannot be empty."); // Throw an exception for empty input
                }
                // Check if input starts with "CE"
                if (!str.toUpperCase().startsWith("CE")) {
                    throw new IllegalArgumentException("ID must start with 'CE'.");
                }
                // Extract the numeric part after "CE"
                String numericPart = str.substring(2);
                if (numericPart.length() != 6) {
                    throw new IllegalArgumentException("ID must have exactly 6 digits after 'CE'.");
                }
                // Check if the numeric part contains only digits
                for (int i = 0; i < numericPart.length(); i++) {
                    char currentChar = numericPart.charAt(i);
                    if (!Character.isDigit(currentChar)) {
                        throw new IllegalArgumentException("Invalid character '" + currentChar + "' at position "
                                + (i + 3) + ". Only digits allowed after 'CE'.");
                    }
                }
                // Ensure total length matches lengthLimit (8)
                str = "CE" + numericPart; // "CE" is already uppercase
                if (str.length() != lengthLimit) {
                    throw new IllegalArgumentException("ID must be exactly " + lengthLimit + " characters long.");
                }
                isValid = true; // Mark input as valid
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // Display the provided error message for invalid input
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid ID (e.g., CE123456)."); // General error message
            }
        } while (!isValid); // Continue looping until valid input is received

        return str; // Return the validated and formatted string
    }

    /**
     * Prompts the user for a valid student semester based on real-time
     * constraints.
     *
     * @param inputMessage The message to prompt the user.
     * @param length The required length of the semester.
     * @return A valid student semester that meets the specified criteria.
     */
    public static String getValidSemester(String inputMessage, int length) {
        String str = "";
        boolean isValid = false;
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear() % 100;
        int currentMonth = currentDate.getMonthValue();

        do {
            try {
                System.out.print(inputMessage);
                str = sc.nextLine().trim().toUpperCase();
                if (str.length() != length) {
                    throw new IllegalArgumentException();
                }
                for (int i = 0; i < str.length(); i++) {
                    if (i < 2 && !Character.isLetter(str.charAt(i))) {
                        throw new IllegalArgumentException();
                    } else if (i >= 2 && !Character.isDigit(str.charAt(i))) {
                        throw new IllegalArgumentException();
                    }
                }
                String prefix = str.substring(0, 2);
                if (!prefix.equals("SU") && !prefix.equals("SP") && !prefix.equals("FA")) {
                    throw new IllegalArgumentException();
                }
                int year = Integer.parseInt(str.substring(2));
                if (year < 17 || year > currentYear) {
                    throw new IllegalArgumentException();
                }
                if (year == currentYear) {
                    if (currentMonth <= 4) { // SP (tháng 1-4)
                        if (!prefix.equals("SP")) {
                            throw new IllegalArgumentException();
                        }
                    } else if (currentMonth <= 8) { // SU (tháng 5-8)
                        if (!prefix.equals("SU") && !prefix.equals("SP")) {
                            throw new IllegalArgumentException();
                        }
                    } else { // FA (tháng 9-12)
                        if (!prefix.equals("FA") && !prefix.equals("SU") && !prefix.equals("SP")) {
                            throw new IllegalArgumentException();
                        }
                    }
                }
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid semester! Must be " + length + " characters, from SP17 to current semester (e.g., SP" + currentYear + ").");
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid semester (e.g., SP25).");
            }
        } while (!isValid);
        return str;
    }

    /**
     * Prompts the user for a valid name.
     *
     * @param inputMessage The message to prompt the user.
     * @param errorMessage The message to display if the input is invalid.
     * @param from The minimum acceptable length of the name.
     * @param to The maximum acceptable length of the name.
     * @return A valid name that meets the specified criteria.
     */
    public static String getValidName(String inputMessage, String errorMessage, int from, int to) {
        String str = ""; // Variable to store user input
        boolean isValid = false; // Flag to check if input is valid
        do {
            try {
                System.out.print(inputMessage);
                str = sc.nextLine().trim(); // Read and trim the user input
                String[] words = str.split("\\s+"); // Split into words
                if (words.length < 2) { // Check for at least 2 words
                    throw new IllegalArgumentException();
                }
                str = getNormalizedString(str); // Normalize the string format
                if (str.isEmpty()) {
                    throw new IllegalArgumentException(); // Throw exception for empty input
                }
                for (int i = 0; i < str.length(); i++) {
                    // Ensure all characters are alphabetic or space
                    if (!(Character.isAlphabetic(str.charAt(i)) || Character.isSpaceChar(str.charAt(i)))) {
                        throw new IllegalArgumentException();
                    }
                }
                // Check if the input length is within the specified range
                if (str.length() < from || str.length() > to) {
                    throw new IllegalArgumentException();
                }
                isValid = true; // Input is valid
            } catch (IllegalArgumentException e) {
                System.out.println(errorMessage); // Display the error message
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a name with at least 2 words (e.g., Le Tuan).");
            }
        } while (!isValid);
        return str; // Return the valid name
    }

    /**
     * Prompts the user for a valid course from a predefined list.
     *
     * @param inputMessage The message to prompt the user.
     * @return A valid course that matches the predefined options.
     */
    public static String getValidCourse(String inputMessage) {
        String str = "";
        boolean isValid = false;
        String[] validCourses = {"Java", ".Net", "C/C++"}; // List of valid courses
        do {
            try {
                System.out.print(inputMessage);
                str = sc.nextLine().trim(); // Read and trim the user input
                if (str.isEmpty()) {
                    throw new IllegalArgumentException("Input cannot be empty."); // Throw exception for empty input
                }
                // Check if the input matches any valid course
                for (String valiCourse : validCourses) {
                    if (str.equalsIgnoreCase(valiCourse)) {
                        isValid = true;
                        str = valiCourse; // Normalize the course name
                        break;
                    }
                }
                if (!isValid) {
                    throw new IllegalArgumentException("Invalid course. Please enter Java, .Net, or C/C++.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // Display error message
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid course (e.g., Java, .Net, C/C++)."); // Display a general error message
            }
        } while (!isValid);
        return str; // Return the valid course
    }

    /**
     * Normalizes the input string by capitalizing the first letter of each
     * word.
     *
     * @param str The input string to normalize.
     * @return The normalized string with proper capitalization.
     */
    public static String getNormalizedString(String str) {
        if (str == null || str.trim().isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String[] parts = str.trim().split("\\s+"); // Split by one or more whitespace            
        for (String string : parts) {
            if (!string.isEmpty()) { // Avoid empty parts
                sb.append(Character.toUpperCase(string.charAt(0))); // Capitalize first letter
                for (int i = 1; i < string.length(); i++) { // Lowercase the rest
                    sb.append(Character.toLowerCase(string.charAt(i)));
                }
                sb.append(" "); // Add space after each word
            }
        }
        return sb.toString().trim(); // Return normalized string
    }

    /**
     * Prompts the user for a Yes or No response.
     *
     * @param inputMessage The message to prompt the user.
     * @param errorMessage The message to display if the input is invalid.
     * @return A valid Yes or No response.
     */
    public static String getValidYesNo(String inputMessage, String errorMessage) {
        String str = ""; // Variable to store user input
        boolean isValid = false; // Flag to check if input is valid
        // Loop until valid input is received
        do {
            try {
                System.out.print(inputMessage);
                str = sc.nextLine().trim(); // Read and trim the user input
                if (str.isEmpty()) {
                    throw new IllegalArgumentException(); // Throw exception for empty input
                }
                // Check if the input is valid
                if (!(str.equalsIgnoreCase("Y") || str.equalsIgnoreCase("N"))) {
                    throw new IllegalArgumentException();
                }
                isValid = true; // Mark input as valid
            } catch (IllegalArgumentException e) {
                System.out.println(errorMessage); // Display the error message
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter 'Y' or 'N' only."); // Display a general error message
            }
        } while (!isValid);
        return str; // Return the valid response
    }

    /**
     * Prompts the user for a choice between updating or deleting.
     *
     * @param inputMessage The message to prompt the user.
     * @param errorMessage The message to display if the input is invalid.
     * @return A valid response indicating Update or Delete.
     */
    public static String getValidUpdateOrDelete(String inputMessage, String errorMessage) {
        String str = ""; // Variable to store user input
        boolean isValid = false; // Flag to check if input is valid
        // Loop until valid input is received
        do {
            try {
                System.out.print(inputMessage);
                str = sc.nextLine().trim(); // Read and trim the user input
                if (str.isEmpty()) {
                    throw new IllegalArgumentException(); // Throw exception for empty input
                }
                // Check if the input is valid
                if (!(str.equalsIgnoreCase("U") || str.equalsIgnoreCase("D"))) {
                    throw new IllegalArgumentException();
                }
                isValid = true; // Mark input as valid
            } catch (IllegalArgumentException e) {
                System.out.println(errorMessage); // Display the error message
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter 'U' for Update or 'D' for Delete."); // Display a general error message
            }
        } while (!isValid);

        return str; // Return the valid response
    }

    /**
     * Prompts the user for a valid search term (letters only).
     *
     * @param inputMessage The message to prompt the user.
     * @param errorMessage The message to display if the input is invalid.
     * @return A valid search term.
     */
    public static String getValidSearchTerm(String inputMessage, String errorMessage) {
        String str = "";
        boolean isValid = false;
        do {
            try {
                System.out.print(inputMessage);
                str = sc.nextLine().trim();
                if (str.isEmpty()) {
                    throw new IllegalArgumentException();
                }
                if (str.length() > 25) {
                    throw new IllegalArgumentException();
                }
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(errorMessage);
            } catch (Exception e) {
                System.out.println("Invalid input! Search term must contain letters only, max 25 characters (e.g., CE180905 or Le).");
            }
        } while (!isValid);
        return str;
    }

    public static void closeScanner() {
        sc.close();
    }
}
