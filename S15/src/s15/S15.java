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
public class S15 {

    /**
     * Main method to run the program
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            // Input size of the array
            int size = MyLib.getPositiveInteger("Please enter size of array: ",
                    "The size of the array must be a positive integer.");

            // Initialize the array
            MyArray myArray = new MyArray(size);

            // Fill the array with user inputs
            myArray.fillArray();

            // Display original array
            System.out.println("The original array:");
            System.out.println(myArray.toString());

            // Remove duplicates
            myArray.removeDuplicates();

            // Display array after removing duplicates
            System.out.println("The array after removing duplicate elements:");
            System.out.println(myArray.toString());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
