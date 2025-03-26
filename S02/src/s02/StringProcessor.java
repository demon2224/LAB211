/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s02;

/**
 * S02 - Reverse a string
 *
 * @author TUANLEACE180905
 */
public class StringProcessor {

    /**
     * Reverse a string
     * Splits by spaces or underscores
     * @param input The original string to reverse
     * @return The reversed string
     */
    public String reverseString(String input) {
        // Expression to split the input string into words and separators
        String[] parts = input.split("(?<=\\s|_)|(?=\\s|_)");
        StringBuilder reversed = new StringBuilder();
        // Traverse the array from the end to the beginning
        for (int i = parts.length - 1; i >= 0; i--) {
            reversed.append(parts[i]);
        }
        return reversed.toString(); // Return the reversed string
    }
}
