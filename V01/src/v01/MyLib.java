/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v01;
import java.util.Scanner;

/**
 * Exception of the processor checking input from the player.
 * @author TUANLEACE180905
 */
public class MyLib {
    private final Scanner scanner;

    /**　　　　　
     * Constructor takes a Scanner to read data from the user.
     * @param scanner
     */
    public MyLib(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Check input validity.
     * @param prompt Message displayed to the player.
     * @return Valid integer.
     */
    public int getValidNumber(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value < 0) {
                    System.out.println("Invalid input. Number must be non-negative.");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a positive integer.");
            }
        }
    }
}

