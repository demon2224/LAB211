/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s13;

/**
 * S13 - String Array Manipulations.
 *
 * @author TUANLEACE180905
 */
public class ArrayManipulations {
// Array to store strings

    private final String[] stringArray;
    // Static index variable to keep track of the current index in the array
    private static int idex = 0;

    /**
     * Constructor for the ArrayManipulations class. Initializes the string
     * array with the specified size.
     *
     * @param n The size of the string array to be created.
     */
    public ArrayManipulations(int n) {
        this.stringArray = new String[n];
    }

    /**
     * Method to add a string to the array.
     *
     * @param x the string to be added
     */
    public void addString(String x) {
        // Add string to array at the current index and increment the index
        stringArray[idex++] = x;
    }

    /**
     * Method to sort the array of strings using the bubble sort algorithm.
     */
    public void bubbleSortStringArray() {
        int n = stringArray.length;  // Get the length of the array
        // Perform bubble sort to sort the array in ascending order
        for (int i = 0; i < n - 1; i++) {  // Loop over each element in the array
            for (int j = i + 1; j < n; j++) {  // Compare adjacent elements
                // If the current string is greater than the next string, swap them
                if (stringArray[i].compareToIgnoreCase(stringArray[j]) > 0) {
                    String temp = stringArray[i];
                    stringArray[i] = stringArray[j];
                    stringArray[j] = temp;
                }
            }
        }
    }

    /**
     * Overrides the toString method to provide a custom string representation
     * of the object. The method builds a formatted string of the elements in
     * the stringArray. Each element is preceded by its index (1-based) followed
     * by a period and a space. Each element is separated by a newline character
     * except for the last element.
     *
     * @return A formatted string representation of the stringArray elements.
     */
    @Override
    public String toString() {
        String result = "";  // Initialize an empty string to hold the result
        for (int i = 0; i < stringArray.length; i++) {  // Loop through each element in the stringArray
            // Append the index (1-based) and the element to the result string
            result += String.format("%d. %s", i + 1, stringArray[i]);
            if (i < stringArray.length - 1) {  // Add a newline character after each element except the last one
                result += "\n";
            }
        }
        return result;  // Return the formatted string
    }

}
