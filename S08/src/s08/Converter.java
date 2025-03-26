/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s08;

import java.util.Scanner;

/**
 * S08 - Convert hexadecimal, octal to binary.
 *
 * @author TUANLEACE180905
 */
public class Converter {

    /**
     * Converts Hexadecimal and Octal numbers to Binary based on user input. The
     * user can input a Hexadecimal number ending with 'h' or an Octal number
     * ending with 'q'. The program continues to prompt the user until 'exit' is
     * entered.
     */
    public void convert() {
        Scanner sc = new Scanner(System.in);  // Scanner for user input
        String input;                          // Input string from user
        String binary;                         // Binary result placeholder
        boolean isValid = false;           // Flag to check if exit is requested

        do {
            try {
                // Prompt user for input
                System.out.println("\nConvert Hexadecimal number / Octal number to Binary program");
                System.out.print("Enter a Hexadecimal (h) / Octal (q) number ('exit' to stop): ");
                input = sc.nextLine().toLowerCase().trim();  // Read and normalize input

                // Check for exit condition
                if (input.equalsIgnoreCase("exit")) {
                    isValid = true;  // Set exit flag to true
                    break;  // Exit the loop
                } else if (input.isEmpty() || input.equals("h") || input.equals("q")) {
                    // Throw an exception if the input is empty or invalid
                    throw new IllegalArgumentException("Input cannot be empty. Please enter a valid Hexadecimal or Octal number.");
                }

                // Check if input is hexadecimal or octal and validate
                if (input.endsWith("h")) {
                    // Check if hexadecimal input contains valid characters
                    if (!input.matches("[0-9a-f]+h")) {
                        throw new IllegalArgumentException("Hexadecimal numbers only use digits 0-9 and the letters A-F (or a-f).");
                    }
                    // Convert Hexadecimal to Binary and print the result
                    binary = hexToBinary(input);
                    System.out.print("Binary number:");
                    System.out.println(binary);
                } else if (input.endsWith("q")) {
                    // Check if octal input contains valid characters
                    if (!input.matches("[0-7]+q")) {
                        throw new IllegalArgumentException("Octal numbers only use digits from 0 to 7. It can't contain 8 or 9 or any alphabetic letters.");
                    }
                    // Convert Octal to Binary and print the result
                    binary = octalToBinary(input);
                    System.out.print("Binary number:");
                    System.out.println(binary);
                } else {
                    // Handle invalid input with an error message
                    throw new IllegalArgumentException("Invalid input.\nPlease use the digits 0-9 and the letters A-F (or a-f) with 'h' at the end for Hexadecimal\nOr use the digits 0-7 with 'q' at the end for Octal.");
                }

                // Prompt for continuation
                System.out.print("Press enter to do another conversion.");
                String response = sc.nextLine();
                System.out.println("--------------------");
            } catch (IllegalArgumentException e) {
                // Catch and display exception messages
                System.out.println(e.getMessage());
            }
            // Loop continues until exit is requested
        } while (!isValid);
    }

    /**
     * Converts a Hexadecimal number to Binary.
     *
     * @param hexNumber The Hexadecimal number string.
     * @return A string containing the binary representation and any error
     * messages if invalid characters are found.
     */
    private String hexToBinary(String hexNumber) {
        int i = 0;  // Index for iteration

        // String to store the binary result
        String binaryValue = "";
        // String to store the final result 
        String finalBinaryValue = "";
        // String to store invalid characters for error reporting
        String errorInputChar = "";

        // Flag to indicate if there are invalid characters
        boolean isValid = false;

        // Iterate through each character in the Hexadecimal input
        while (i < hexNumber.length() - 1) {
            char c = hexNumber.charAt(i);  // Get the current character

            // Convert the Hexadecimal character to Binary
            switch (c) {
                case '0':
                    binaryValue += " 0000";
                    break;
                case '1':
                    binaryValue += " 0001";
                    break;
                case '2':
                    binaryValue += " 0010";
                    break;
                case '3':
                    binaryValue += " 0011";
                    break;
                case '4':
                    binaryValue += " 0100";
                    break;
                case '5':
                    binaryValue += " 0101";
                    break;
                case '6':
                    binaryValue += " 0110";
                    break;
                case '7':
                    binaryValue += " 0111";
                    break;
                case '8':
                    binaryValue += " 1000";
                    break;
                case '9':
                    binaryValue += " 1001";
                    break;
                case 'a':
                    binaryValue += " 1010";
                    break;
                case 'b':
                    binaryValue += " 1011";
                    break;
                case 'c':
                    binaryValue += " 1100";
                    break;
                case 'd':
                    binaryValue += " 1101";
                    break;
                case 'e':
                    binaryValue += " 1110";
                    break;
                case 'f':
                    binaryValue += " 1111";
                    break;
                default:
                    isValid = true;  // Mark as invalid if an invalid character is found
                    errorInputChar += " " + c;  // Store invalid character for reporting
                    break;
            }
            i++;  // Increment index
        }
        binaryValue += "b";
        finalBinaryValue += binaryValue;
        return finalBinaryValue;  // Return the final result
    }

    /**
     * Converts an Octal number to Binary.
     *
     * @param octalNumber The Octal number string.
     * @return A string containing the binary representation and any error
     * messages if invalid characters are found.
     */
    private String octalToBinary(String octalNumber) {
        int i = 0;  // Index for iteration

        // String to store the binary result
        String binaryValue = "";
        // String to store the final result with separators
        String finalBinaryValue = "";
        // String to store invalid characters for error reporting
        String errorInputChar = "";

        // Flag to indicate if there are invalid characters
        boolean isValid = false;

        // Iterate through the octal string
        while (i < octalNumber.length() - 1) {
            char c = octalNumber.charAt(i);  // Get the current character

            // Convert the Octal character to Binary
            switch (c) {
                case '0':
                    binaryValue += " 000";
                    break;
                case '1':
                    binaryValue += " 001";
                    break;
                case '2':
                    binaryValue += " 010";
                    break;
                case '3':
                    binaryValue += " 011";
                    break;
                case '4':
                    binaryValue += " 100";
                    break;
                case '5':
                    binaryValue += " 101";
                    break;
                case '6':
                    binaryValue += " 110";
                    break;
                case '7':
                    binaryValue += " 111";
                    break;
                default:
                    isValid = true;  // Mark as invalid if an invalid character is found
                    errorInputChar += " " + c;  // Store invalid character for reporting
                    break;
            }
            i++;  // Increment index
        }
        binaryValue += "b";
        finalBinaryValue += binaryValue;
        return finalBinaryValue;  // Return the final result
    }
}
