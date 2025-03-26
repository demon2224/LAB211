/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s05;

import java.util.HashMap;

/**
 * S05 - Count the number of the appearance of letters in a string.
 *
 * @author TUANLEACE180905
 */
public class Program {

    private MyLib myLib = new MyLib(); // Utility class for validation
    private String str; // Input string after processing
    private HashMap<Character, Integer> letterList = new HashMap<>(); // Stores letter counts

    /**
     * Main method to run the program.
     */
    public void run() {
        // Get validated input from user
        str = myLib.getValidString("Enter a string: ");

        // Remove all special characters using regex
        str = removeSpecialCharacters(str);

        countLetters(); // Count occurrences of each letter
        printResults(); // Display results
    }

    /**
     * Removes all special characters.
     *
     * @param input The input string from user.
     * @return The cleaned string with only letters.
     */
    public String removeSpecialCharacters(String input) {
        return input.replaceAll("[^a-zA-Z]", ""); // Keep only letters
    }

    /**
     * Count the occurrences of letters in the string.
     */
    public void countLetters() {
        for (char c : str.toCharArray()) {
            letterList.put(c, letterList.getOrDefault(c, 0) + 1);
        }
    }

    /**
     * Prints the result in alphabetical order.
     */
    public void printResults() {
        // Check if input contains at least one letter
        if (!str.matches(".*[a-zA-Z]+.*")) {
            System.out.println("Input does not contain any letters.");
        } else {
            System.out.println("\nLetter Frequency:");
            for (char c = 'a'; c <= 'z'; c++) {
                if (letterList.containsKey(c)) {
                    System.out.println(c + ": " + letterList.get(c));
                }
            }
        }
    }
}
