/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v04;

/**
 * V04 - Program to Manage Doctors.
 *
 * @author TUANLEACE180905
 */
public class Doctor {

    private String code;
    private String name;
    private String specialty;
    private int availability;

    /**
     * Constructor to initialize a Doctor object.
     *
     * @param code Unique identifier for the doctor
     * @param name Doctor's full name
     * @param specialty Doctor's field of expertise
     * @param availability Number of hours or shifts available
     */
    public Doctor(String code, String name, String specialty, int availability) {
        this.code = code;
        this.name = name;
        this.specialty = specialty;
        this.availability = availability;
    }

    /**
     * Gets the doctor's unique code.
     *
     * @return Doctor's code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the doctor's unique code.
     *
     * @param code New code for the doctor
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the doctor's name.
     *
     * @return Doctor's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the doctor's name.
     *
     * @param name New name for the doctor
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the doctor's specialty.
     *
     * @return Doctor's specialty
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * Sets the doctor's specialty.
     *
     * @param specialty New specialty for the doctor
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    /**
     * Gets the doctor's availability.
     *
     * @return Number of hours or shifts available
     */
    public int getAvailability() {
        return availability;
    }

    /**
     * Sets the doctor's availability.
     *
     * @param availability New availability in hours or shifts
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }

    /**
     * Returns a string representation of the doctor object.
     *
     * @return A string representation of the doctor with their code, name,
     * specialty, and availability.
     */
    @Override
    public String toString() {
       int index = 1;
        return String.format("%5d%-9s%-14s%-20s%12d\n",
                index++, code, name, specialty, availability);
    }
}
