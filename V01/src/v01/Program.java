/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v01;

import java.util.Random;
import java.util.Scanner;

/**
 * V01 - Program where the player guesses a randomly generated lucky number.
 *
 * @author TUANLEACE180905
 */
public class Program {

    /**
     * Class for the Lucky Number Game.
     */
    static class LuckyNumberGame {

        private int minNumber; // Minimum range of the number.
        private int maxNumber; // Maximum range of the number.
        private int totalGames;
        private int totalGuesses;
        private int bestGame;
        private int bestRoundGame;
        private final Scanner sc;
        private final MyLib mylib;

        /**
         * Constructor initializes game variables and Scanner.
         */
        public LuckyNumberGame() {
            totalGames = 0; // Base number for Total games.
            totalGuesses = 0; // Base number of guesses.
            bestGame = Integer.MAX_VALUE; // Best game equals max value possible
            sc = new Scanner(System.in);
            mylib = new MyLib(sc);
        }

        /**
         * Starts the game.
         */
        public void start() {
            getMinMaxFromUser(); // Request min and max from user
            do {

                playGame();
            } while (askToContinue());
            reportStatistics();
        }

        /**
         * Gets valid min and max from the user.
         */
        private void getMinMaxFromUser() {
            System.out.println("\n--- Welcome to the Lucky Number Game ---");
            System.out.println("Please enter the valid range for the lucky number.");

            minNumber = mylib.getValidNumber("Enter the minimum value: ");

            do {
                maxNumber = mylib.getValidNumber("Enter the maximum value: ");
                if (maxNumber <= minNumber) {
                    System.out.println("Maximum must be greater than minimum. Please enter a valid max.");
                }
            } while (maxNumber <= minNumber);

            System.out.printf("The lucky number will be between %d and %d.\n", minNumber, maxNumber);
        }

        /**
         * Execution of the game.
         */
        private void playGame() {

            Random random = new Random();
            int luckyNumber = random.nextInt((maxNumber - minNumber) + 1) + minNumber; // Generate lucky number.

            System.out.println("\n--- New Game ---");
            System.out.printf("Guess the lucky number (%d to %d):\n", minNumber, maxNumber);

            int guessCount = 0; // Count the number of guesses.
            boolean guessedCorrectly = false; // bool to check if guessed correctly.

            while (!guessedCorrectly) {
                int userGuess = mylib.getValidNumber("Enter your guess: "); // Check user input.
                guessCount++; // Count up for every guesses.

                if (userGuess > luckyNumber) {
                    System.out.println("The lucky number is smaller than your predicted number.");
                } else if (userGuess < luckyNumber) {
                    System.out.println("The lucky number is greater than your predicted number.");
                } else {
                    System.out.printf("Congratulations! You guessed the lucky number after %d attempts.\n", guessCount);
                    guessedCorrectly = true; // Break loop.
                }
            }

            updateStatistics(guessCount);
        }

        /**
         * Updates game statistics after each round.
         *
         * @param guesses the number of guesses in the current round.
         */
        private void updateStatistics(int guesses) {

            totalGames++; // Count up after each game.
            totalGuesses += guesses; // total = total + guesses.
            if (guesses < bestGame) {
                bestGame = guesses; // Set bestGame to be the one with the lowest guesses.
                bestRoundGame = totalGames;
            }
        }

        /**
         * Asks the user whether to continue playing.
         *
         * @return true if the user wants to continue, false otherwise.
         */
        private boolean askToContinue() {
            System.out.println("\nDo you want to continue playing? (yes to continue, no to exit)");
            String response = sc.nextLine().trim().toLowerCase(); // Convert to case insensitive.
            return response.equals("y") || response.equals("yes"); // Any other input count as no.
        }

        /**
         * Reports overall game statistics.
         */
        private void reportStatistics() {
            System.out.println("\n--- Game Statistics ---");
            System.out.printf("Total games played: %d\n", totalGames); // Total number of games played.
            System.out.printf("Total guesses made: %d\n", totalGuesses); // Total number of guesses.
            System.out.printf("Average guesses per game: %.2f\n", (double) totalGuesses / totalGames); // Average
            // guesses per
            // game.
            System.out.printf("Round %d have the fewest quesses with %d guesses.\n", bestRoundGame, bestGame); // Game
            // round
            // with
            // fewest
            // guesses.
            System.out.println("Finish program."); // End.
        }
    }
}
