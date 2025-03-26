/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s11;

import java.util.Scanner;

/**
 * S11 - Basic Computation Practice.
 *
 * @author TUANLEACE180905
 */
public class MyLib {

    Scanner sc = new Scanner(System.in); // Scanner to read input from user

    /**
     * Reads and validates user input for menu options.
     *
     * @return a String representing a valid menu option between 1 and 4.
     */
    public String checkInput() {
        boolean check = false;
        String input;
        while (true) {
            try {
                System.out.print("Choose an option: ");
                input = sc.nextLine().trim();
                int inp = Integer.parseInt(input);
                if (inp < 1 || inp > 4) {
                    check = true;
                    System.out.println("Only 1 - 4. Please enter input again!");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Input Invalid. Please enter input again!\n");
            }
        }
        return input;
    }

    /**
     * Reads and validates a numeric input from the user.
     *
     * @param msg A prompt message to display to the user.
     * @return a String representing a valid non-negative integer.
     */
    public String checkNumber(String msg) {
        boolean check = false;
        String input;
        int num;
        while (true) {
            System.out.print(msg);
            check = false;
            try {
                input = sc.nextLine().trim();
                num = Integer.parseInt(input);
                if (num < 0) {
                    check = true;
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Input Invalid. Please enter input again!");
            }
        }
        return input;
    }
}
