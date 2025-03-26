/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s02;

/**
 * S02 - Reverse a string
 * @author TUANLEACE180905
 */
public class S02 {

    /**
     * Main method to run the program
     * @param args the command line arguments
     *
     */

    public static void main(String[] args) {
        // TODO code application logic here
        StringProcessor processor = new StringProcessor(); // Create instance of StringProcessor
        MyLib myLib = new MyLib(); // Create instance of MyLib

        while (true) {
            // Get a non-empty string from the user
            String input = myLib.getValidatedAndCheckedString("Please enter a string: ",
                    "Input must contain only uppercase, lowercase, spaces and underscores.",
                    "Input must contain at least one letter. Please try again.");

            // Reverse the string
            String reversed = processor.reverseString(input);

            // Display results
            System.out.println("The original string: " + input);
            System.out.println("The reversed string: " + reversed);

            // Ask the user if they want to continue or exit
            while (true) {
                String choice = myLib.getNonEmptyString("Press enter to continue reversing, QUIT to exit: ",
                        "Input cannot be empty. Please try again.");
                if (choice.isEmpty()) {
                    break; // Allow entering a new string
                } else if (choice.equalsIgnoreCase("QUIT")) {
                    System.out.println("Exiting the program!");
                    return; // Exit the program
                } else {
                    System.out.println("You are only allowed to press enter or type QUIT.");
                }
            }
        }
    }
}
