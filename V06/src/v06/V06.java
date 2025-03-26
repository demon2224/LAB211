/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v06;

/**
 * V06 - Array and string manipulations.
 *
 * @author TUANLEACE180905
 */
public class V06 {

    /**
     * Main method to run the program
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement(); // Student studentManagement instance
        int choice;
        System.out.println("========== Student Management ==========");
        do {
            // Display menu
            System.out.println("\n*************************************");
            System.out.println("1 - Add a student.");
            System.out.println("2 - Remove a student.");
            System.out.println("3 - Search a student.");
            System.out.println("4 - Print list student in an ascending folder.");
            System.out.println("5 - Exit");
            System.out.println("*************************************");
            // Get user choice
            choice = MyLib.getInteger("\nEnter your choice: ", 1, 5);

            switch (choice) {
                case 1:
                    // Add student
                    String nameAdd = MyLib.getString("\nEnter new student name: ");
                    studentManagement.addStudent(nameAdd);
                    break;

                case 2:
                    if (studentManagement.isEmpty()) {
                        System.out.println("Student list is empty. Cannot perform remove.");
                    } else {
                        // Remove student
                        String nameRemove = MyLib.getString("\nEnter student name to remove: ");
                        studentManagement.removeStudent(nameRemove);
                    }
                    break;

                case 3:
                    if (studentManagement.isEmpty()) {
                        System.out.println("Student list is empty. Cannot perform search.");
                    } else {
                        // Search student
                        String nameSearch = MyLib.getString("\nEnter student name to search: ");
                        int position = studentManagement.searchStudent(nameSearch);
                        if (position == -1) {
                            System.out.println("Student name doesn’t exist in list.");
                        } else {
                            System.out.println("The position of student name in list is " + (position + 1) + ".");
                        }
                    }
                    break;

                case 4:
                    if (studentManagement.isEmpty()) {
                        System.out.println("Student list is empty. Cannot perform print.");
                    } else {
                        studentManagement.printStudents();
                    }
                    break;

                case 5:
                    // Exit program
                    System.out.println("Exit.....");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose from 1 to 5.");
            }
        } while (choice != 5);
    }
}
