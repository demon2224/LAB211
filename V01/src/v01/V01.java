/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v01;

/**
 * V01 - Program where the player guesses a randomly generated lucky number.
 *
 * @author TUANLEACE180905
 */
public class V01 {

    /**
     * Main method to run the program
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Program.LuckyNumberGame gameLogic = new Program.LuckyNumberGame();
        gameLogic.start();
    }
}
