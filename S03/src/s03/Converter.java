/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s03;

/**
 * Convert binary, octal and hexadecimal to decimal
 * @author TUANLEACE180905
 */
public class Converter {

    /**
     * Converts a binary number to a decimal number
     * Example: "1101" => 1*2^3 + 1*2^2 + 0*2^1 + 1*2^0 = 13
     * @param binary Binary string
     * @return Decimal representation of the binary number
     */
    public int binaryToDecimal(String binary) {
        int decimal = 0;
        int length = binary.length();
        for (int i = 0; i < length; i++) {
            // Calculate the weight (2^i)
            int weight = (int) Math.pow(2, i);
            // Get the digit from the right
            int digit = binary.charAt(length - 1 - i) - '0';
            // Add to the result
            decimal += digit * weight;
        }
        return decimal;
    }

    /**
     * Converts an octal number to a decimal number
     * Example: "157" => 1*8^2 + 5*8^1 + 7*8^0 = 111
     * @param octal Octal string
     * @return Decimal representation of the octal number
     */
    public int octalToDecimal(String octal) {
        int decimal = 0;
        int length = octal.length();
        for (int i = 0; i < length; i++) {
            // Calculate the weight (8^i)
            int weight = (int) Math.pow(8, i);
            // Get the digit from the right
            int digit = octal.charAt(length - 1 - i) - '0';
            // Add to the result
            decimal += digit * weight;
        }
        return decimal;
    }

    /**
     * Converts a hexadecimal number to a=> 1*16^2 + 10*16^1 + 3*16^0 = 419 decimal number
     * Example: "1A3" => 1*16^2 + 10*16^1 + 3*16^0 = 419
     * @param hex Hexadecimal string
     * @return Decimal representation of the hexadecimal number
     */
    public int hexadecimalToDecimal(String hex) {
        int decimal = 0;
        int length = hex.length();
        for (int i = 0; i < length; i++) {
            // Get the character from the right
            char ch = hex.charAt(length - 1 - i);
            // Determine the numeric value of the character
            int value = (ch >= '0' && ch <= '9') ? ch - '0' : Character.toUpperCase(ch) - 'A' + 10;
            // Calculate the weight (16^i)
            int weight = (int) Math.pow(16, i);
            // Add to the result
            decimal += value * weight;
        }
        return decimal;
    }
}
