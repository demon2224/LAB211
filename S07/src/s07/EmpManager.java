/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s07;

import java.util.ArrayList;

/**
 * Employee Management System.
 *
 * @author TUANLEACE180905
 */
public class EmpManager {

    private ArrayList<Employee> employees = new ArrayList<>();

    /**
     * Method to add employees to the list.
     */
    public void add() {
        int numEmployees = MyLib.getValidInt("+ Enter number of Employee: ");

        for (int i = 1; i <= numEmployees; i++) {
            System.out.println("- Employee " + i + ":");
            Employee emp = new Employee();

            // Check for duplicate IDs before adding employees
            String id;
            while (true) {
                id = MyLib.getValidID("--Please enter ID number: ");  // Get ID from user and check for duplicate
                if (isIdDuplicate(id)) {
                    System.out.println("ID already exists! Please enter a different ID.");
                } else {
                    break;  // ID does not match, continue
                }
            }
            emp.setId(id);
            emp.input();
            employees.add(emp);
        }
    }

    /**
     * Method to check if an employee ID already exists in the list.
     *
     * @param id The ID to check
     * @return true if the ID is already in the list, false otherwise
     */
    private boolean isIdDuplicate(String id) {
        for (Employee emp : employees) {
            if (emp.getId().equals(id)) {
                return true;  // If ID matches, return true
            }
        }
        return false;  // If not a match, return false
    }

    /**
     * Method to display the list of employees.
     */
    public void show() {
        if (employees.isEmpty()) {
            System.out.println("No employees in the list.");
            return;
        }

        System.out.println("=====================List Employee=====================");
        System.out.printf("|%-3s|%-8s|%-20s|%-10s|%-8s|\n", "No.", "ID", "Name", "Salary", "COE");
        int index = 1;
        for (Employee emp : employees) {
            System.out.printf("|%3d", index++);
            emp.output();
        }
    }

    /**
     * Method to display menu and handle user input.
     */
    public void menu() {
        while (true) {
            System.out.println("\n----------MENU----------");
            System.out.println("1. Input employee.");
            System.out.println("2. Show list employee.");
            System.out.println("0. Exit.");

            int choice = MyLib.getValidMenuChoice("Please choose: ");

            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    show();
                    break;
                case 0:
                    System.out.println("SEE YOU AGAIN!");
                    System.out.println("\n\n\n    ----------------------------------------------END------------------------------------------------");
                    return;
                default:
                    System.out.println("--------Error! Please enter 1, 2, or 0.");
            }
        }
    }
}
