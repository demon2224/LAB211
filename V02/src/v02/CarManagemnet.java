/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * V02 - Car showroom
 *
 * @author TUANLEACE180905
 */
public class CarManagemnet {
   
    private Car car;
    private Color color;
    private Day day;
    private int price;

    /**
     * Runs the showroom program, guiding the user through the process of
     * inputting car details and displaying the selected car's information. The
     * program loops until the user chooses to exit.
     */
    public void play() {
        System.out.println("==== Showroom Car Program ====");
        System.out.println("Input Car Information");

        int choice;
        do {
            // Get and validate car details
            String sName = getName();
            String sColor = getColor();
            String sDay = getDay();
            int iPrice = getPrice();

            // Display the selected car details
            System.out.println(String.format("Car sells.\nName: %s, Color: %s, Day: %s, Price: %d",
                    sName, sColor, sDay, iPrice));

            // Ask user if they want to continue; 1 means yes, any other value exits
            choice = MyLib.getChoice("Do you want to continue? (y/yes to continue, otherwise exit)",
                    "Program terminated!");
        } while (choice == 1);
    }

    /**
     * Prompts the user to enter a car name and validates it against available
     * car options. If the input is invalid, it displays the list of available
     * cars and repeats the prompt.
     *
     * @return the validated car name as a {@code String}, matching an enum
     * value in {@code Car}
     */
    public String getName() {
        String name;
        do {
            // Get input with letters only, rejecting special characters
            name = MyLib.getLetterOnly("Enter car name: ", "Car name must not contain special characters!");
            car = Car.getCar(name); // Attempt to match input to a Car enum value

            // If no match is found, inform the user and show available options
            if (car == null) {
                System.out.println("Car does not exist. Available cars: " + Arrays.toString(Car.values()));
            }
        } while (car == null); // Repeat until a valid car is selected

        return car.name(); // Return the validated car name
    }

    /**
     * Prompts the user to enter a color for the selected car and validates it
     * against the car's available colors. If the color is invalid, it displays
     * the car's valid color options and repeats the prompt.
     *
     * @return the validated color as a {@code String}, matching an enum value
     * in {@code Color}
     */
    public String getColor() {
        String sColor;
        do {
            // Get input with letters only, rejecting special characters
            sColor = MyLib.getLetterOnly("Enter color: ", "Color must not contain special characters!");
            color = Color.getColor(sColor); // Attempt to match input to a Color enum value

            // Check if the color exists and is available for the selected car
            if (color == null || !car.getColors().contains(color)) {
                System.out.println("Invalid color for " + car.name() + ". Available colors: " + car.getColors());
            }
        } while (color == null || !car.getColors().contains(color)); // Repeat until a valid color is selected

        return color.name(); // Return the validated color name
    }

    /**
     * Prompts the user to enter a selling day for the selected car and
     * validates it against the car's available days. The input is matched by
     * checking if it starts with a valid day name. If invalid, it displays the
     * car's valid day options and repeats the prompt.
     *
     * @return the validated selling day as a {@code String}, matching an enum
     * value in {@code Day}
     */
    public String getDay() {
        String dayInput;
        do {
            // Get input with letters only, rejecting special characters
            dayInput = MyLib.getLetterOnly("Enter day: ", "Day must not contain special characters.");
            day = null;

            // Try to match the input to a day available for the selected car
            for (Day d : car.getDays()) {
                if (d.name().startsWith(dayInput.toUpperCase())) {
                    day = d;
                    break;
                }
            }

            // If no match is found, inform the user and show available options
            if (day == null) {
                System.out.println("Invalid day for " + car.name() + ". Available days: " + car.getDays());
            }
        } while (day == null); // Repeat until a valid day is selected

        System.out.println("You have chosen: " + day.name());
        return day.name(); // Return the validated day name
    }

    /**
     * Prompts the user to enter a price for the selected car and validates it
     * against the car's available prices. If the color is {@code NO_COLOR}, a
     * $100 discount is applied to all prices. If the price is invalid, it
     * displays the car's valid price options and repeats the prompt.
     *
     * @return the validated price as an {@code int}
     */
    public int getPrice() {
        do {
            // Get a positive integer input from the user
            price = MyLib.getNumber("Enter price: ", "Please enter a positive integer!");

            // Get the car's valid prices
            List<Integer> validPrices = car.getPrices();

            // Apply a $100 discount if the color is NO_COLOR
            if (color == Color.NO_COLOR) {
                validPrices = validPrices.stream().map(p -> p - 100).collect(Collectors.toList());
                System.out.println("You get a $100 discount on this no-color " + car.name());
            }

            // Check if the entered price is valid
            if (!validPrices.contains(price)) {
                System.out.println("Invalid price for " + car.name() + ". Available prices: " + validPrices);
                price = -1; // Reset price to trigger loop continuation
            }
        } while (price == -1); // Repeat until a valid price is entered

        return price; // Return the validated price
    }
}
