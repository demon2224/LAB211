/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s15;

import java.util.Scanner;

/**
 * S15 - Delete duplicate elements in an array.
 *
 * @author TUANLEACE180905
 */
public class MyLib {

    static Scanner sc = new Scanner(System.in);

    /**
     * Prompts the user to input a positive integer
     *
     * @param msg The prompt message
     * @param errorMsg The error message for invalid input
     * @return The positive integer entered by the user
     */
    public static int getPositiveInteger(String msg, String errorMsg) {
        int n = 0;
        boolean isValid = true;
        do {
            try {
                System.out.print(msg);
                n = Integer.parseInt(sc.nextLine());
                if (n > 0) {
                    isValid = true;
                } else {
                    System.out.println(errorMsg);
                    isValid = false;
                }
            } catch (Exception e) {
                System.out.println(errorMsg);
                isValid = false;
            }
        } while (!isValid);
        return n;
    }

    /**
     * Get an integer input from the user
     *
     * @param prompt The message prompting user input
     * @param errorMsg The message shown when input is invalid
     * @return The integer value input by the user
     */
    public static int getInteger(String prompt, String errorMsg) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(errorMsg);
            }
        }
    }
}
