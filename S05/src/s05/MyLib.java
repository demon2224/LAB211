/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s05;

import java.util.Scanner;

/**
 * S05 - Count the number of the appearance of letters in a string.
 *
 * @author TUANLEACE180905
 */
public class MyLib {

    private Scanner input = new Scanner(System.in);

    /**
     * Gets a valid non-empty string from the user.
     *
     * @param message The prompt message.
     * @return A valid, non-empty string.
     */
    public String getValidString(String message) {
        while (true) {
            System.out.print(message);
            String userInput = input.nextLine().trim().toLowerCase();

            if (userInput.isEmpty()) {
                System.out.println("Input cannot be empty. Please enter a valid string.");
                continue;
            }
            return userInput;
        }
    }
}
