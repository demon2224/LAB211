/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s04;

/**
 * Check student's data format
 *
 * @author TUANLEACE180905
 */
public class MyLib {

    /**
     * Checks if the input is empty.
     *
     * @param input The input string.
     * @param msg Error message if input is empty.
     * @return true if input is empty, false otherwise.
     */
    public boolean checkNullValue(String input, String msg) {
        if (input.isEmpty()) {
            System.out.println(msg);
            return true;
        }
        return false;
    }

    /**
     * Checks if input contains special characters. Only allows letters,
     * numbers, hyphens, and spaces.
     *
     * @param input The input string.
     * @param msg Error message if input contains special characters.
     * @return true if input contains special characters, false otherwise.
     */
    public boolean checkSpecialCharacter(String input, String msg) {
        if (!input.matches("[a-zA-Z0-9- ]+")) {
            System.out.println(msg);
            return true;
        }
        return false;
    }

    /**
     * Checks if input is within a specified numeric range.
     *
     * @param input The input string.
     * @param min Minimum valid value.
     * @param max Maximum valid value.
     * @return true if input is out of range, false otherwise.
     */
    public boolean checkOutOfRange(String input, int min, int max) {
        try {
            int value = Integer.parseInt(input);
            if (value < min || value > max) {
                System.out.println("Please enter a value between " + min + " and " + max + ".");
                return true;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return true;
        }
        return false;
    }
}
