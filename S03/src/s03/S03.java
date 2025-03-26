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
public class S03 {

    /**
     * Main method to run the program
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Converter converter = new Converter();
        int choice;
        do {
            // Display menu
            System.out.println("1. Convert binary number to decimal number");
            System.out.println("2. Convert octal number to decimal number");
            System.out.println("3. Convert hexadecimal number to decimal number");
            System.out.println("4. Exit");
            choice = MyLib.getPositiveInteger("Please choose an option (1–4): ",
                                              "Please enter a number between 1 and 4.");

            switch (choice) {
                case 1:
                    // Binary to Decimal
                    String binary = MyLib.getBinaryInput("Enter binary number: ",
                                                         "Please enter binary number (0 and 1 only)."
                    );
                    int decimalFromBinary = converter.binaryToDecimal(binary);
                    System.out.println("Decimal number is: " + decimalFromBinary);
                    break;

                case 2:
                    // Octal to Decimal
                    String octal = MyLib.getOctalInput("Enter octal number: ",
                                                       "Please enter an octal number (digits 0–7 only)."
                    );
                    int decimalFromOctal = converter.octalToDecimal(octal);
                    System.out.println("Decimal number is: " + decimalFromOctal);
                    break;

                case 3:
                    // Hexadecimal to Decimal
                    String hex = MyLib.getHexadecimalInput("Enter hexadecimal number: ",
                                                           "Please enter a hexadecimal number (0–9, A–F)."
                    );
                    int decimalFromHex = converter.hexadecimalToDecimal(hex);
                    System.out.println("Decimal number is: " + decimalFromHex);
                    break;

                case 4:
                    // Exit the program
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Please enter existing options");
            }
            System.out.println(); // Blank line for readability
        } while (choice != 4);
    }
}

