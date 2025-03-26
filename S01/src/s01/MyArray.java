/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s01;

/**
 * S01 - Program to insert new element into an existing array.
 *
 * @author TUANLACE180905
 */
public class MyArray {

    private int[] a;
    private int size;

    /**
     * Constructor to initialize the array with a specific size.
     * @param n Size of the array.
     * @throws Exception If size is not positive integer.
     */
    public MyArray(int n) throws Exception {
        if (n <= 0) {
            throw new Exception("Number of elements must be a positive integer.");
        } else {
            this.a = new int[n];
            this.size = n;
        }
    }

    /**
     * Fill the array with positive integers form user input.
     * @throws Exception If input is invalid.
     */
    public void fillArray() throws Exception {
        for (int i = 0; i < a.length; i++) {
            a[i] = MyLib.getInteger(
                    "Element[" + i + "]: ",
                    "Elements must be a integer."
            );
        }
    }

    /**
     * Sort the array in ascending order using the bubble sort algorithm
     */
    public void sortArray() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    /**
     * Inserts a new element into the sorted array while maintaining order
     * @param value The value to be inserted
     */
    public void insertElement(int value) {
        int[] newArray = new int[size + 1];
        int i = 0;

        // Copy elements until the insertion point
        while (i < size && a[i] < value) {
            newArray[i] = a[i];
            i++;
        }

        // Insert the new value
        newArray[i] = value;

        // Copy the remaining elements
        for (int j = i; j < size; j++) {
            newArray[j + 1] = a[j];
        }
        a = newArray;
        size++;
    }

    /**
     * Converts the array to a formatted string
     * @return The formatted string representation of the array
     */
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += String.format("%-8d", a[i]);
        }
        return result;
    }
}
