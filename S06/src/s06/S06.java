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
public class S06 {

    /**
     * Main method to run the program
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyArray array = new MyArray(); // Create an instance of ArrayProcessor
        int choice;

        do {
            // Display the menu
            System.out.println("\nArray Manipulations:");
            System.out.println("1. Add a value");
            System.out.println("2. Search a value");
            System.out.println("3. Print out the array");
            System.out.println("4. Print out values in a range");
            System.out.println("5. Sort the array in ascending order");
            System.out.println("6. Quit");
            choice = MyLib.getIntegerInRange("Please select an option (1-6): ",
                    "Please enter a number between 1 and 6.", 1, 6);

            try {
                switch (choice) {
                    case 1:
                        // Add a value
                        int valueToAdd = MyLib.getInteger("Enter a value to add: ",
                                "Please enter an integer.");
                        array.addValue(valueToAdd);
                        break;

                    case 2:
                        // Search a value
                        if (MyLib.checkArrayNotEmpty(array)) {
                            int valueToSearch = MyLib.getInteger("Enter a value to search: ",
                                    "Please enter an integer.");
                            int index = array.searchValue(valueToSearch);
                            if (index == -1) {
                                System.out.println("Value not found in the array.");
                            } else {
                                System.out.println("Value found at index: " + index);
                            }
                        }
                        break;

                    case 3:
                        // Print out the array
                        System.out.println("Current array: " + array.printArray());
                        break;

                    case 4:
                        // Print values in a range
                        if (MyLib.checkArrayNotEmpty(array)) {
                            int[] range = MyLib.getValidRange(
                                    "Enter the minimum value of the range: ",
                                    "Enter the maximum value of the range: ",
                                    "Please ensure max > min."
                            );
                            array.valuesInRange(range[0], range[1]);
                        }
                        break;

                    case 5:
                        // Sort the array
                        if (MyLib.checkArrayNotEmpty(array)) {
                            array.sortArray();
                        }
                        break;

                    case 6:
                        // Quit
                        System.out.println("Exiting the program!");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (choice != 6);
    }
}
