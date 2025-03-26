/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l02;

/**
 * LO2 - Create a Java console program to manage students.
 *
 * @author TUANLEACE180905
 */
public class L02 {

    /**
     * Main method to run the program
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int option;

        // Create an instance of the StudentManagement class
        StudentManagement studentManagement = new StudentManagement();

        do {
            // Display the welcome message and menu options
            System.out.println("\n\tWELCOME TO STUDENT MANAGEMENT");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Add student list");
            System.out.println("6. Exit");

            // Get a valid menu choice from the user
            option = MyLib.getInt("\tPlease choose: ", "Invalid choice. Please enter a number between 1 and 6", 1,
                    6);

            switch (option) {
                case 1: // Create a new student
                    studentManagement.createStudent();
                    break;
                case 2: // Search and sort students
                    studentManagement.findAndSort();
                    break;
                case 3: // Update or delete a student record
                    studentManagement.updateOrDelete();
                    break;
                case 4: // Generate a report of student enrollments
                    studentManagement.generateReport();
                    break;
                case 5: // Add predefined student list
                    studentManagement.addStudentList();
                    break;
                case 6:
                    System.out.println("Exit the program...");
                    System.out.println("Thank you for using Student Management!");
                    MyLib.closeScanner();
                    break;
            }
        } while (option != 6);
    }
}
