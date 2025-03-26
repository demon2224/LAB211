/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v03;

import java.util.Scanner;

/**
 * V03 - Grade Student program Handles user interaction and program flow
 *
 * @author TUANLEACE180905
 */
public class MyLib {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * Reads an integer from the user within a specified range.
     *
     * @param from Minimum acceptable value.
     * @param to Maximum acceptable value.
     * @return A valid integer within the range.
     */
    public static int getInt(int from, int to) {
        int num = 0;
        boolean isOk = false;

        do {
            try {
                num = scanner.nextInt();
                if (num < from || num > to) {
                    throw new Exception();
                }
                isOk = true;
            } catch (Exception e) {
                System.out.print("Must be integer between " + from + " and " + to + ". Please try again: ");
                scanner.nextLine();
            }
        } while (!isOk);

        scanner.nextLine();
        return num;
    }

    /**
     * Reads an integer from the user with a minimum acceptable value.
     *
     * @param from Minimum acceptable value.
     * @return A valid integer greater than or equal to the specified minimum.
     */
    public static int getInt(int from) {
        int num = 0;
        boolean isOk = false;

        do {
            try {
                num = scanner.nextInt();
                if (num < from) {
                    throw new Exception();
                }
                isOk = true;
            } catch (Exception e) {
                System.out.print("Must be integer greater than " + from + ". Please try again: ");
                scanner.nextLine();
            }
        } while (!isOk);

        scanner.nextLine();
        return num;
    }

    /**
     * Reads a double from the user within a specified range.
     *
     * @param from Minimum acceptable value.
     * @param to Maximum acceptable value.
     * @return A valid double within the range.
     */
    public static double getDouble(int from, int to) {
        double num = 0;
        boolean isOk = false;

        do {
            try {
                num = scanner.nextDouble();
                if (num < from || num > to) {
                    throw new Exception();
                }
                isOk = true;
            } catch (Exception e) {
                System.out.print("Must be between " + from + " and " + to + ". Please try again: ");
                scanner.nextLine();
            }
        } while (!isOk);

        scanner.nextLine();
        return num;
    }

    /**
     * Reads an integer from the user that must be strictly greater than a
     * specified value.
     *
     * @param from Minimum unacceptable value.
     * @return A valid integer strictly greater than the specified value.
     */
    public static int getIntGreaterThan(int from) {
        int num = 0;
        boolean isOk = false;

        do {
            try {
                num = scanner.nextInt();
                if (num <= from) {
                    throw new Exception();
                }
                isOk = true;
            } catch (Exception e) {
                System.out.print("Must be greater than " + from + ". Please try again: ");
                scanner.nextLine();
            }
        } while (!isOk);

        scanner.nextLine();
        return num;
    }

    /**
     * Reads a pair of integers from user input representing a score and its
     * maximum possible value.
     *
     * @return A valid input string containing two integers separated by a
     * space.
     */
    public static String getScoreAndMax() {
        String str = "";
        boolean isOk = false;

        do {
            try {
                str = scanner.nextLine().trim();
                String[] arr = str.split(" ");

                int scoreEarned = Integer.parseInt(arr[0]);
                int maxScoreEarned = Integer.parseInt(arr[1]);

                // Validate the input values
                if (arr.length != 2 || scoreEarned > maxScoreEarned || scoreEarned < 0 || maxScoreEarned < 1) {
                    throw new Exception();
                }

                isOk = true;
            } catch (Exception e) {
                System.out.print("Must contain 2 positive integers (score <= max, max >= 1). Please try again: ");
            }
        } while (!isOk);

        return str;
    }
}
