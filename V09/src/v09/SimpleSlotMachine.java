/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v09;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/**
 * V09 - Simple Slot Machine.
 *
 * @author TUANLEACE180905
 */
public class SimpleSlotMachine {

    private double balance = 10.00; // The user's current balance, starting with $10.
    private final double playCost = 0.25; // The cost for each play of the slot machine is 25 cents.
    private final String SAVE_FILE = "balance.txt"; // The name of the file used to save and load the balance.
    private String info; // A string used to store and display information about the game to the user.

    /**
     * Returns the current game information stored in the 'info' variable.
     *
     * @return a string containing the current game status (e.g., balance, play
     * result, etc.).
     */
    public String getInfo() {
        return info;
    }

    /**
     * Simulates playing the slot machine. If the balance is less than the play
     * cost, it sets an error message. Otherwise, it randomly generates three
     * numbers for the slot machine and determines the outcome: - If all three
     * numbers match, the user wins $10 minus the play cost. - If two numbers
     * match, the user wins 50 cents minus the play cost. - If no numbers match,
     * the user loses 25 cents. Updates the balance and the 'info' string to
     * reflect the result.
     */
    public void playSlotMachine() {
        String result = ""; // Variable to store the result of the slot machine play.

        // Check if the user has enough balance to play.
        if (balance < playCost) {
            this.info = "Not enough money to play."; // Set error message if balance is too low.
            return;
        }

        // Generate three random numbers between 0 and 9 for the slot machine.
        Random rand = new Random();
        int number1 = rand.nextInt(10);
        int number2 = rand.nextInt(10);
        int number3 = rand.nextInt(10);

        // Display the result of the slot machine.
        result += "The slot machine shows " + number1 + number2 + number3 + "\n";

        // Determine the outcome based on the three numbers.
        if (number1 == number2 && number2 == number3) {
            result += "You win the big prize, $10.00!\n"; // If all three numbers match, big prize.
            balance += 10.00 - playCost; // Add $10 minus the play cost to the balance.
        } else if (number1 == number2 || number1 == number3 || number2 == number3) {
            result += "You win 50 cents!\n"; // If two numbers match, smaller prize.
            balance += 0.50 - playCost; // Add 50 cents minus the play cost to the balance.
        } else {
            result += "Sorry you don't win anything.\n"; // If no numbers match, no prize.
            balance -= playCost; // Deduct the play cost from the balance.
        }

        // Update the result string with the user's remaining balance.
        result += String.format("You have $%.2f.", balance);
        this.info = result; // Set the info string to display the result and balance.
    }

    /**
     * Simulates cashing out of the game. Displays a message with the user's
     * final balance.
     */
    public void cashOut() {
        this.info = String.format("Thank you for playing! You end with $%.2f!", balance);
    }

    /**
     * Saves the current balance to a file. If the save is successful, it sets a
     * success message in 'info'. If an error occurs during saving, it sets an
     * error message in 'info'.
     */
    public void saveGame() {
        try (PrintWriter fileWriter = new PrintWriter(new FileWriter(SAVE_FILE))) {
            fileWriter.println(balance); // Write the balance to the save file.
            this.info = "Your money has been saved!"; // Set success message.
        } catch (IOException e) {
            this.info = "Error saving the game: " + e.getMessage(); // Set error message in case of failure.
        }
    }

    /**
     * Loads the saved balance from a file. If the file does not exist or is
     * empty, it sets an appropriate message. If loading is successful, it
     * updates the balance and sets a success message in 'info'.
     */
    public void loadGame() {
        File file = new File(SAVE_FILE); // Create a File object for the save file.

        // Check if the file exists. If not, display an error message.
        if (!file.exists()) {
            this.balance = 10.0; // Default balance
            this.info = "File does not exist. Please check the file path. Starting with $10.00";
            return;
        }

        // Check if the file is empty. If so, display an error message.
        if (file.length() == 0) {
            this.balance = 10.0; // Default balance
            this.info = "File is empty. No data to read. Starting with $10.00";
            return;
        }

        // Try to read the balance from the file.
        try (Scanner fileScanner = new Scanner(file)) {
            balance = Double.parseDouble(fileScanner.nextLine()); // Read and parse the balance.
            this.info = String.format("You have $%.2f.", balance); // Display the loaded balance.
        } catch (IOException e) {
            this.info = "No saved game found. Starting with $10.00"; // Default message if loading fails.
        }
    }
}
