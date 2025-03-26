/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Check student's data format
 *
 * @author TUANLEACE180905
 */
public class Program {

    private Scanner input = new Scanner(System.in); // Scanner for user input
    private String check; // Temporary variable for checking input
    private String name; // Student's name
    private String classes; // Student's class
    private double mathsScore; // Math score
    private double chemistryScore; // Chemistry score
    private double physicsScore; // Physics score
    private MyLib checker = new MyLib(); // Utility class for input validation
    private HashMap<String, Student> studentsList = new HashMap<>(); // Stores student data
    private String loop; // Stores user input for continuing or stopping

    /**
     * Runs the program.
     */
    public void run() {
        do {
            System.out.println("====== Management Student Program ======");
            getStudentInfo(); // Get student details

            // Ask if user wants to add another student
            do {
                System.out.print("Do you want to enter more student information? (Y/N): ");
                loop = input.nextLine().trim().toUpperCase();
            } while (!loop.equals("Y") && !loop.equals("N"));

        } while (loop.equals("Y"));
        printInfo(); // Print student details
        printClassification(); // Print student classification
    }

    /**
     * Gets student information and adds to the list.
     */
    public void getStudentInfo() {
        // Get and validate student name
        while (true) {
            System.out.print("Name:");
            check = input.nextLine().trim();
            if (checker.checkNullValue(check, "Name cannot be empty.")
                    || checker.checkSpecialCharacter(check, "No special characters allowed in name.")
                    || checkName(check)) {
                continue;
            }
            name = check;
            break;
        }

        // Get and validate class
        while (true) {
            System.out.print("Classes:");
            check = input.nextLine().trim();
            if (checker.checkNullValue(check, "Class cannot be empty.")
                    || checker.checkSpecialCharacter(check, "No special characters allowed in class name.")) {
                continue;
            }
            classes = check;
            break;
        }

        // Get and validate scores
        mathsScore = getValidScore("Maths");
        chemistryScore = getValidScore("Chemistry");
        physicsScore = getValidScore("Physics");

        // Add student to the list
        studentsList.put(name, new Student(name, classes, mathsScore, chemistryScore, physicsScore));
    }

    /**
     * Ensures valid input for scores (0 - 10).
     *
     * @param subject The subject name.
     * @return A valid score.
     */
    private double getValidScore(String subject) {
        while (true) {
            System.out.print(subject + ":");
            check = input.nextLine().trim();
            if (checker.checkNullValue(check, subject + " is digit")
                    || checker.checkSpecialCharacter(check, subject + " is digit")) {
                continue;
            }
            double score = Double.parseDouble(check);
            if (score < 0) {
                System.out.println(subject + " is greater than equal zero");
            } else if (score > 10) {
                System.out.println(subject + " is less than equal ten");
            } else {
                return score;
            }
        }
    }

    /**
     * Checks if a student name already exists.
     *
     * @param name is the name of the student.
     * @return true if the name is exist. False if the name is new.
     */
    public boolean checkName(String name) {
        if (studentsList.containsKey(name)) {
            System.out.println("This name is already registered");
            return true;
        }
        return false;
    }

    /**
     * Prints all student information.
     */
    public void printInfo() {
        int i = 1;
        for (Map.Entry<String, Student> currentStudent : studentsList.entrySet()) {
            System.out.printf("------ Student %d Info ------\n", i++);
            System.out.println(currentStudent.getValue());
        }
    }

    /**
     * Prints student classification based on scores.
     */
    public void printClassification() {
        double A = 0, B = 0, C = 0, D = 0;
        for (Student student : studentsList.values()) {
            switch (student.typeCalculate()) {
                case "A":
                    A++;
                    break;
                case "B":
                    B++;
                    break;
                case "C":
                    C++;
                    break;
                default:
                    D++;
            }
        }
        System.out.println("-------- Classification Info -----");
        System.out.printf("A: %.1f%%\nB: %.1f%%\nC: %.1f%%\nD: %.1f%%\n",
                (A / studentsList.size()) * 100,
                (B / studentsList.size()) * 100,
                (C / studentsList.size()) * 100,
                (D / studentsList.size()) * 100);
    }
}
