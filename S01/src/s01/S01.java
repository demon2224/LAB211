/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s01;

/**
 * S01 - Program to insert new element into an existing array.
 * @author TUANLACE180905
 */
public class S01 {

    /**
     * Main method to run the program
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            // TODO code application logic here
            //Input size of the array
            int size = MyLib.getPositiveInteger("Please enter size of array: ",
                    "The size of the array must be a positive integer.");
            
            //Initialize the array
            MyArray myArray = new MyArray(size);
            
            //Fill the array wwith user inputs
            myArray.fillArray();
            
            //Sort of array
            myArray.sortArray();
            System.out.println("The array after sorting:\n" + myArray.toString());
            
            //Insert a new value into the array
            int newValue = MyLib.getPositiveInteger("Please enter new value: ",
                    "The new value must be a positive integer.");
            myArray.insertElement(newValue);
            System.out.println("New array:\n" + myArray.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
