/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s15;

/**
 * S15 - Delete duplicate elements in an array.
 *
 * @author TUANLEACE180905
 */
public class MyArray {

    private int[] a;
    private int size;

    /**
     * Constructor to initialize the array with a specific size
     *
     * @param n Size of the array
     * @throws Exception If size is not positive integer
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
     *
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
     * Remove duplicate elements from the array
     */
    public void removeDuplicates() {
        if (size <= 1) {
            return; // No duplicates possible
        }
        // Use a temporary array to store unique elements
        int[] temp = new int[size];
        int newSize = 0;

        // Mark first occurrence
        for (int i = 0; i < size; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < newSize; j++) {
                if (temp[j] == a[i]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                temp[newSize++] = a[i];
            }
        }

        // Update the original array
        a = new int[newSize];
        for (int i = 0; i < newSize; i++) {
            a[i] = temp[i];
        }
        this.size = newSize;
    }

    /**
     * Converts the array to a formatted string
     *
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
