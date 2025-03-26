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
public class Program {

    private MyLib mylib = new MyLib(); // Object for input validation
    private Scanner sc = new Scanner(System.in); // Scanner for input

    /**
     * Displays the menu and handles user input for various operations.
     */
    public void menu() {
        int choose = 1; // Initialize menu choice

        do {
            System.out.println("");
            System.out.println("----------MENU----------");
            System.out.println("1-The first primes");
            System.out.println("2-Fibonacci element");
            System.out.println("3-Sum of digits");
            System.out.println("4-Exit");
            choose = Integer.parseInt(mylib.checkInput()); // Validate and parse menu choice

            switch (choose) {
                case 1:
                    primes(); // Print prime numbers
                    break;
                case 2:
                    fibonacci(); // Check if a number is Fibonacci
                    break;
                case 3:
                    plusDigits(); // Sum digits of an integer
                    break;
            }
        } while (choose != 4); // Exit loop if user chooses '4'
    }

    /**
     * Prints the first 'n' prime numbers.
     */
    public void primes() {
        int number = Integer.parseInt(mylib.checkNumber("Number of primes: ")); // Get number of primes to print
        if (number != 0) {
            int a = 0, b = 2;
            while (a < number) {
                int pri = 2;
                while (b % pri != 0) {
                    pri++; // Check for prime numbers
                }
                if (pri == b) {
                    System.out.print(pri + " ");
                    a++;
                }
                b++;
            }
        } else {
            System.out.println("If choose 0, no primes need print");
        }
    }

    /**
     * Determines if a given number is a Fibonacci number.
     */
    public void fibonacci() {
        int number = Integer.parseInt(mylib.checkNumber("Number tested: "));
        // Check for Fibonacci number using recursion
        if (number == 0 || number == 1) {
            System.out.println("It's a Fibonacci term.");
        } else {
            if (isFibonacci(number)) {
                System.out.println("It's a Fibonacci term.");
            } else {
                System.out.println("It's not a Fibonacci term.");
            }
        }
    }

    /**
     * Checks if a given number is a Fibonacci number using recursion.
     *
     * @param num The number to check.
     * @return true if the number is a Fibonacci term, false otherwise.
     */
    public boolean isFibonacci(int num) {
        return isFibonacciHelper(0, 1, num);  // Start recursion with F(0) and F(1)
    }

    /**
     * Helper function to recursively check if a number is a Fibonacci number.
     *
     * @param a The first number in the Fibonacci sequence.
     * @param b The second number in the Fibonacci sequence.
     * @param num The number to check.
     * @return true if num is a Fibonacci number, false otherwise.
     */
    private boolean isFibonacciHelper(int a, int b, int num) {
        if (b == num) {
            return true;  // If we find the number in the sequence, return true
        } else if (b > num) {
            return false;  // If the Fibonacci number exceeds num, return false
        }
        return isFibonacciHelper(b, a + b, num);  // Recur with next Fibonacci numbers
    }

    /**
     * Calculates and prints the sum of the digits of an integer.
     */
    public void plusDigits() {
        int num = Integer.parseInt(mylib.checkNumber("Enter an integer: "));
        int sum = 0;
        while (num != 0) {
            int a = num % 10;
            num /= 10;
            sum += a;
        }
        System.out.print("Sum of its digits: " + sum);
    }
}
