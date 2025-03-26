/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v11;

import java.util.Scanner;

/**
 * V11 - Subsystem for listing and searching content files.
 *
 * @author TUANLEACE180905
 */
public class V11 {

    /**
     * Main method to run the program
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in); // Scanner to read user input
        CSVFormatter csvf = new CSVFormatter(); // Create an instance of CSVFormatter to handle CSV operations
        int option; // Variable to store user's menu option choice
        String path; // Variable to store the file path for importing/exporting CSV files

        // Loop to display the menu and handle user choices until they choose to exit
        do {
            System.out.println("======= Format CSV Program =======");
            System.out.println("1. Import CSV"); // Option to import a CSV file
            System.out.println("2. Format Address"); // Option to format the address field in the CSV
            System.out.println("3. Format Name"); // Option to format the name field in the CSV
            System.out.println("4. Export CSV"); // Option to export the formatted CSV file
            System.out.println("5. Exit"); // Option to exit the program

            // Get a valid integer input from the user within the range of 1 to 5
            option = MyLib.getValidInt("Please choice one option: ",
                    "Invalid choice. Please enter a number between 1 and 5", 1, 5);

            // Switch case to handle the user's choice
            switch (option) {
                case 1:
                    System.out.println("--------- Import CSV -------");
                    System.out.print("Enter Path:"); // Prompt the user for the CSV file path
                    path = sc.nextLine(); // Read the file path from the user
                    csvf.importCSV(path); // Call the method to import the CSV file
                    System.out.println(csvf.getInfo()); // Display the status of the operation
                    break;
                case 2:
                    System.out.println("--------- Format Address");
                    csvf.formatAddress(); // Call the method to format the address field in the CSV
                    System.out.println(csvf.getInfo()); // Display the status of the operation
                    break;
                case 3:
                    System.out.println("--------- Format Name");
                    csvf.formatName(); // Call the method to format the name field in the CSV
                    System.out.println(csvf.getInfo()); // Display the status of the operation
                    break;
                case 4:
                    System.out.println("--------- Export CSV -------");
                    System.out.print("Enter Path:"); // Prompt the user for the export file path
                    path = sc.nextLine(); // Read the file path from the user
                    csvf.exportCSV(path); // Call the method to export the formatted CSV data
                    System.out.println(csvf.getInfo()); // Display the status of the operation
                    break;
                case 5:
                    System.out.println("Exiting the program..."); // Exiting message
                    break;
            }
        } while (option != 5); // Continue looping until the user selects option 5 (Exit)
    }
}
