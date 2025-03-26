/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v02;

import java.util.Scanner;

/**
 * V02 - Car showroom
 *
 * @author TUANLEACE180905
 */
public class MyLib {

    static Scanner sc = new Scanner(System.in);

    /**
     * Prompts the user to enter letters only.
     *
     * @param msg The prompt message.
     * @param errMsg The error message displayed for invalid input.
     * @return A valid string containing only letters and spaces.
     */
    public static String getLetterOnly(String msg, String errMsg) {
        String str;
        do {
            System.out.print(msg);
            str = sc.nextLine().trim().toUpperCase();

            if (!str.matches("^[A-Za-z ]+$")) {
                System.out.println(errMsg);
            }
        } while (!str.matches("^[A-Za-z ]+$"));
        return str;
    }

    /**
     * Prompts the user to enter a non-negative integer.
     *
     * @param msg The prompt message.
     * @param errMsg The error message displayed for invalid input.
     * @return A valid non-negative integer.
     */
    public static int getNumber(String msg, String errMsg) {
        int n = 0;
        boolean isValid;
        do {
            try {
                System.out.print(msg);
                n = Integer.parseInt(sc.nextLine().trim());
                isValid = n > 0;
                if (!isValid) {
                    System.out.println(errMsg);
                }
            } catch (Exception e) {
                System.out.println(errMsg);
                isValid = false;
            }
        } while (!isValid);
        return n;
    }

    /**
     * Prompts the user for a choice between continuing and exiting.
     *
     * @param msg The message asking for user input.
     * @param exitMsg The message displayed if the user chooses to exit.
     * @return 1 if the user chooses to continue, 0 if they choose to exit.
     */
    public static int getChoice(String msg, String exitMsg) {
        int choice = 0;
        System.out.println(msg);
        String str = sc.nextLine().trim();

        if (str.equalsIgnoreCase("y") || str.equalsIgnoreCase("yes")) {
            choice = 1; // Continue
        } else {
            choice = 0; // Exit
            System.out.println(exitMsg);
        }
        return choice;
    }
}
