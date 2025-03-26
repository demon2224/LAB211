/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * V04 - Program to Manage Doctors.
 *
 * @author TUANLEACE180905
 */
public class DoctorManagement {

    /**
     * A HashMap storing Doctor objects with their unique codes as keys for
     * quick access.
     */
    private HashMap<String, Doctor> hMapDoctor;

    /**
     * A List storing Doctor objects for displaying search results.
     */
    private List<Doctor> lDoctor;

    /**
     * Constructor initializes the HashMap and ArrayList to store doctor data.
     */
    public DoctorManagement() {
        hMapDoctor = new HashMap<>(); // Initialize an empty HashMap for doctor storage
        lDoctor = new ArrayList<>();  // Initialize an empty ArrayList for search results
    }

    /**
     * Displays the main menu options for the doctor management system.
     */
    public void menu() {
        System.out.println("========= Doctor Management =========\n"
                + "          1. Add Doctor\n"
                + "          2. Update Doctor\n"
                + "          3. Delete Doctor\n"
                + "          4. Search Doctor\n"
                + "          5. Exit"); // Print the menu options
    }

    /**
     * Runs the doctor management system, displaying the menu and processing
     * user choices in a loop until the user selects to exit (choice 5).
     */
    public void play() {
        int choice; // Variable to store the user's menu choice
        do {
            menu(); // Display the menu
            choice = MyLib.getChoice("Enter your choice? (1-5) ", "Only numbers 1-5 are allowed!"); // Get validated choice

            // Process the user's choice
            switch (choice) {
                case 1:
                    addDoctor(); // Add a new doctor
                    break;
                case 2:
                    updateDoctor(); // Update an existing doctor
                    break;
                case 3:
                    deleteDoctor(); // Delete a doctor
                    break;
                case 4:
                    searchDoctor(); // Search for doctors
                    break;
                case 5:
                    System.out.println("ExitProgram...!"); // Exit message
                    break; // Exit the switch but not the loop (handled by while condition)
            }
        } while (choice != 5); // Continue until the user chooses to exit
    }

    /**
     * Adds a new doctor to the system by prompting for and validating their
     * details. Ensures the doctor's code is unique before adding.
     */
    public void addDoctor() {
        System.out.println("--------- Add Doctor ---------"); // Indicate the add operation
        String code; // Variable to store the doctor's code

        // Ensure the code is unique
        do {
            code = MyLib.getCode("Enter Code (DOC XXX): "); // Get validated code
            if (findByCode(code) != null) {
                System.out.println("Doctor code " + code + " already exists! Please enter a different code.");
            } else {
                break; // Exit loop if code is unique
            }
        } while (true);

        // Get validated doctor details
        String name = MyLib.getName("Enter Name: ", "Doctor name must not contain any special characters!");
        String specialization = MyLib.getName("Enter Specialization: ", "Specialization must not contain special characters!");
        int availability = MyLib.getInterger("Enter Availability: ", "Doctor's availability must be an integer between 1 and 100!", 1, 1, 100);

        // Add the new doctor to the HashMap
        hMapDoctor.put(code, new Doctor(code, name, specialization, availability));
        System.out.println("Doctor added successfully!"); // Confirmation message
    }

    /**
     * Updates an existing doctor's details by prompting for their code and new
     * information. If the doctor is not found or the database is empty, it
     * notifies the user.
     */
    public void updateDoctor() {
        System.out.println("--------- Update Doctor ---------"); // Indicate the update operation
        if (hMapDoctor.isEmpty()) { // Check if the database is empty
            System.out.println("Database is empty!");
            return;
        }

        String code = MyLib.getCode("Enter Code (DOC XXX): "); // Get the doctor's code
        Doctor doctor = findByCode(code); // Find the doctor by code

        if (doctor == null) { // Check if the doctor exists
            System.out.println("Doctor with code " + code + " not found!");
            return;
        }

        // Get new validated details
        String name = MyLib.getName("Enter Name: ", "Doctor name must not contain special characters!");
        String specialization = MyLib.getName("Enter Specialization: ", "Specialization must not contain special characters!");
        int availability = MyLib.getInterger("Enter Availability: ", "Availability must be between 1 and 100!", 1, 1, 100);

        // Update the doctor's details
        doctor.setName(name);
        doctor.setSpecialty(specialization);
        doctor.setAvailability(availability);

        System.out.println("Doctor updated successfully!"); // Confirmation message
    }

    /**
     * Deletes a doctor from the system by prompting for their code. If the
     * doctor is not found or the database is empty, it notifies the user.
     */
    public void deleteDoctor() {
        System.out.println("--------- Delete Doctor ---------"); // Indicate the delete operation
        if (hMapDoctor.isEmpty()) { // Check if the database is empty
            System.out.println("Database is empty!");
            return;
        }

        String code = MyLib.getCode("Enter Code: "); // Get the doctor's code
        if (findByCode(code) != null) { // Check if the doctor exists
            hMapDoctor.remove(code); // Remove the doctor from the HashMap
            System.out.println("Doctor deleted successfully!"); // Confirmation message
        } else {
            System.out.println("Doctor with code " + code + " not found!");
        }
    }

    /**
     * Searches for doctors based on a keyword entered by the user. Matches the
     * keyword against code, name, specialization, or availability (if numeric).
     * Displays results if found, otherwise notifies the user.
     */
    public void searchDoctor() {
        System.out.println("--------- Search Doctor ---------"); // Indicate the search operation
        if (hMapDoctor.isEmpty()) { // Check if the database is empty
            System.out.println("Database is empty!");
            return;
        }

        System.out.print("Enter search keyword: "); // Prompt for search keyword
        String searchText = MyLib.sc.nextLine().trim().toUpperCase(); // Read and normalize input

        lDoctor.clear(); // Clear previous search results

        boolean isNumber = searchText.matches("\\d+"); // Check if the search text is a number

        // Search through all doctors in the HashMap
        for (Doctor doctor : hMapDoctor.values()) {
            if (doctor.getCode().toUpperCase().contains(searchText) // Match code
                    || doctor.getName().toUpperCase().contains(searchText) // Match name
                    || doctor.getSpecialty().toUpperCase().contains(searchText)) { // Match specialization
                lDoctor.add(doctor); // Add matching doctor to the list
            } else if (isNumber && doctor.getAvailability() == Integer.parseInt(searchText)) { // Match availability if numeric
                lDoctor.add(doctor); // Add matching doctor to the list
            }
        }

        // Display results or notify if none found
        if (lDoctor.isEmpty()) {
            System.out.println("No doctors found!");
        } else {
            System.out.println(toString()); // Display formatted search results
        }
    }

    /**
     * Finds a doctor in the HashMap by their unique code.
     *
     * @param code The doctor's code to search for.
     * @return The Doctor object if found, otherwise null.
     */
    public Doctor findByCode(String code) {
        return hMapDoctor.get(code); // Retrieve the doctor from the HashMap using the code
    }

    /**
     * Returns a formatted string representation of the search results from the
     * lDoctor list.
     *
     * @return A string containing a table of search results with columns for
     * No., Code, Name, Specialization, and Availability.
     */
    @Override
    public String toString() {
        String res = "--------- Search Results ---------\n"; // Start the result string
        // Add table header with formatted columns
        res += String.format("%-5s%-9s%-14s%-20s%-12s\n", "No.", "Code", "Name", "Specialization", "Availability");

        int index = 1; // Index for numbering results
        for (Doctor doctor : lDoctor) {
            res += doctor; // Append each doctor's string representation (assumes Doctor has a suitable toString)
        }

        return res; // Return the formatted result string
    }
}
