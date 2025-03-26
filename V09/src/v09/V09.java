/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v09;

/**
 * V09 - Simple Slot Machine.
 *
 * @author TUANLEACE180905
 */
public class V09 {

    /**
     * Main method to run the program
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int option; // Variable to store the user's selected menu option.
        SimpleSlotMachine simpleSlotMachine = new SimpleSlotMachine(); // Create an instance of SimpleSlotMachine to manage game logic.
        simpleSlotMachine.loadGame(); // Load the saved game data, such as the user's current balance.
        System.out.println(simpleSlotMachine.getInfo()); // Display the current game information (e.g., balance).

        // Loop until the user selects the "Cash out" option (option 3).
        do {
            // Display menu options to the user.
            System.out.println("Choose one of the following menu options:");
            System.out.println("1) Play the slot machine.");
            System.out.println("2) Save game.");
            System.out.println("3) Cash out.");

            // Get a valid integer input for the menu option (between 1 and 3), ensuring correct input.
            option = MyLib.getValidInt("!!! Option must be from 1 to 3 !!!", 1, 3);

            // Perform actions based on the selected option.
            switch (option) {
                case 1: // If the user selects option 1, play the slot machine.
                    simpleSlotMachine.playSlotMachine(); // Simulate a round of the slot machine.
                    System.out.println(simpleSlotMachine.getInfo()); // Display updated game information.
                    break;
                case 2: // If the user selects option 2, save the current game progress.
                    simpleSlotMachine.saveGame(); // Save the user's current game status (e.g., balance) to a file.
                    System.out.println(simpleSlotMachine.getInfo()); // Display updated game information.
                    break;
                case 3: // If the user selects option 3, cash out and exit the game.
                    simpleSlotMachine.cashOut(); // Perform the cash-out process (e.g., reset balance, print final status).
                    System.out.println(simpleSlotMachine.getInfo()); // Display updated game information.
            }
        } while (option != 3); // Repeat the loop until the user chooses to cash out (option 3).
    }
}
