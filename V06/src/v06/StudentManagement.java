/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v06;

import java.util.ArrayList;

/**
 * V06 - Array and string manipulations.
 *
 * @author TUANLEACE180905
 */
public class StudentManagement {

    private static final int MAX_SIZE = 100; // Max allowed students
    private ArrayList<String> studentList; // List to store student names

    /**
     * Initializes an empty student list.
     */
    public StudentManagement() {
        this.studentList = new ArrayList<>();
    }

    /**
     * Adds a student if the list is not full.
     *
     * @param name Student name to add.
     */
    public void addStudent(String name) {
        if (studentList.size() >= MAX_SIZE) {
            System.out.println("The list has full. It cannot add a new student.");
        } else {
            studentList.add(name);
            System.out.println("Student has been added to list successfully!");
        }
    }

    /**
     * Removes a student by name.
     *
     * @param name Student name to remove.
     */
    public void removeStudent(String name) {
        int index = searchStudent(name);
        if (index == -1) {
            System.out.println("Student name doesn’t exist in list.");
        } else {
            studentList.remove(index);
            System.out.println("Student name has been removed successfully!");
        }
    }

    /**
     * Searches for a student and returns the index.
     *
     * @param name Student name to search.
     * @return Index (0-based) if found, -1 otherwise.
     */
    public int searchStudent(String name) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).equalsIgnoreCase(name)) {
                return i; // Return actual index (0-based)
            }
        }
        return -1; // Not found
    }

    /**
     * Prints the sorted student list or notifies if empty.
     */
    public void printStudents() {

        int n = studentList.size();
        // Bubble Sort in alphabetical order regardless of case
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (studentList.get(j).compareToIgnoreCase(studentList.get(j + 1)) < 0) {
                    // Swap elements
                    String temp = studentList.get(j);
                    studentList.set(j, studentList.get(j + 1));
                    studentList.set(j + 1, temp);
                }
            }
        }
        // Print sorted list
        System.out.println("\nTotal students: " + n);
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ". " + studentList.get(i));
        }
    }

    /**
     * Checks if the student list is empty.
     *
     * @return true if the student list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return studentList.isEmpty();
    }
}
