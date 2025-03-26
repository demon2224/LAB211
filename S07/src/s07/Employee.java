/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s07;

/**
 * Employee Management System.
 *
 * @author TUANLEACE180905
 */
public class Employee {

    private String id;      // Employee ID (Format: NVxxxx)
    private String name;    // Employee's name
    private double salary;  // Base salary of the employee
    private double COE;     // Coefficients salary (from 1.0 to 5.0)

    /**
     * Initializes an empty Employee object with no parameters.
     */
    public Employee() {
    }

    /**
     * Constructor with parameters to initialize an Employee object.
     *
     * @param id Employee ID (Format: NVxxxx).
     * @param name Employee's full name.
     * @param salary Base salary (minimum 100 USD).
     * @param COE Coefficient salary (must be between 1.0 and 5.0).
     */
    public Employee(String id, String name, double salary, double COE) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.COE = COE;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getCOE() {
        return COE;
    }

    public void setCOE(double COE) {
        this.COE = COE;
    }

    /**
     * Calculates final salary based on COE.
     *
     * @return The final salary after applying the coefficient.
     */
    public double calSalary() {
        return salary * COE;
    }

    /**
     * Reads employee data from user input.
     */
    public void input() {
        this.name = MyLib.getValidString("--Please enter name: ");
        this.salary = MyLib.getValidDouble("--Please enter salary: ", 100);
        this.COE = MyLib.getValidDoubleSalary("--Please enter coefficients salary: ", 1.0, 5.0);
    }

    /**
     * Displays employee details.
     */
    public void output() {
        System.out.printf("|%-8s|%-20s|%10.0f|%8.1f|\n", id, name, salary, COE);
    }
}
