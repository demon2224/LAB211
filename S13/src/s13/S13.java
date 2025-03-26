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
public class S13 {

    /**
     * Main method to run the program
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Prompt user to enter the number of names (n) and validate the input
        int n = MyLib.getValidInt("Enter the value of n", "!!! Input must be an integer between 1 and 50 !!!", 1, 50);

        // Create an ArrayManipulations object to handle array operations with size n
        ArrayManipulations arrayManipulations = new ArrayManipulations(n);

        // Prompt the user to enter n names
        System.out.printf("Enter %d names\n", n);
        for (int i = 0; i < n; i++) {
            // Validate and add each name to the array
            arrayManipulations.addString(MyLib.getValidString("Name must be at least 2 words, contain only letters and spaces, maximum 25 characters.", 25));
        }

        // Display the list of input names
        System.out.println("List input name:");
        System.out.println(arrayManipulations);

        // Sort the names using bubble sort
        System.out.println("List sort name:");
        arrayManipulations.bubbleSortStringArray();

        // Display the sorted list of names
        System.out.println(arrayManipulations);
    }
}
