/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s06;

/**
 * S06 - Array Manipulations.
 *
 * @author TUANLEACE180905
 */
public class MyArray {

    private int[] array; // Fixed-size array to store integers
    private int size; // Current size of the array

    /**
     * Constructor to initialize the array.
     */
    public MyArray() {
        array = new int[100]; // Initialize array with a maximum size of 100
        size = 0; // Initially, the array is empty
    }

    /**
     * Checks if the array is empty.
     *
     * @return True if the array is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds a value to the array.
     *
     * @param value The value to add.
     */
    public void addValue(int value) {
        if (size < array.length) {
            array[size] = value; // Add value at the current size index
            size++;
            System.out.println("Value added successfully.");
        } else {
            System.out.println("Array is full. Cannot add more values.");
        }
    }

    /**
     * Searches for a value in the array.
     *
     * @param value The value to search for.
     * @return The index of the value, or -1 if not found.
     */
    public int searchValue(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return i; // Return the index if value is found
            }
        }
        return -1; // Return -1 if value is not found
    }

    /**
     * Prints the array as a string.
     *
     * @return A string representation of the array.
     */
    public String printArray() {
        if (size == 0) {
            return "Array is empty.";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(array[i]);
            if (i < size - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }

    /**
     * Gets all values in the array within a specified range.
     *
     * @param min The minimum value of the range.
     * @param max The maximum value of the range.
     */
    public void valuesInRange(int min, int max) {
        StringBuilder result = new StringBuilder();

        // Array browsing, and add valid values ​​to the result.
        for (int i = 0; i < size; i++) {
            if (array[i] >= min && array[i] <= max) {
                result.append(array[i]).append(", ");
            }
        }

        // If no value is found, output a message and return
        if (result.length() == 0) {
            System.out.println("No values in the specified range.");
            return;
        }

        // Remove the last comma and print the result
        result.setLength(result.length() - 2);
        System.out.println("Values in range [" + min + ", " + max + "]: " + result);
    }

    /**
     * Sorts the array in ascending order using bubble sort.
     */
    public void sortArray() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("Array sorted in ascending order: " + printArray());
    }
}
