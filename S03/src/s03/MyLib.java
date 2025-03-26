/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s03;

import java.util.Scanner;

/**
 * Convert binary, octal and hexadecimal to decimal
 * @author TUANLEACE180905
 */
public class MyLib {

    static Scanner sc = new Scanner(System.in);
    
    /**
     * Prompts the user to input a positive integer
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
                } else{
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
     * Prompts the user to input a valid binary string.
     * @param msg The prompt message.
     * @param errorMsg The error message for invalid input.
     * @return The valid binary string.
     */
    public static String getBinaryInput(String msg, String errorMsg) {
        String input;
        boolean isValid;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            isValid = input.matches("[01]+");
            if (!isValid) {
                System.out.println(errorMsg);
            }
        } while (!isValid);
        return input;
    }

    /**
     * Prompts the user to input a valid octal string.
     * @param msg The prompt message.
     * @param errorMsg The error message for invalid input.
     * @return The valid octal string.
     */
    public static String getOctalInput(String msg, String errorMsg) {
        String input;
        boolean isValid;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            isValid = input.matches("[0-7]+");
            if (!isValid) {
                System.out.println(errorMsg);
            }
        } while (!isValid);
        return input;
    }

    /**
     * Prompts the user to input a valid hexadecimal string
     * @param msg The prompt message
     * @param errorMsg The error message for invalid input
     * @return The valid hexadecimal string
     */
    public static String getHexadecimalInput(String msg, String errorMsg) {
        String input;
        boolean isValid;
        do {
            System.out.print(msg);
            input = sc.nextLine().toUpperCase();
            isValid = input.matches("[0-9A-F]+");
            if (!isValid) {
                System.out.println(errorMsg);
            }
        } while (!isValid);
        return input;
    }
}
