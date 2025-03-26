/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v02;

import java.util.Arrays;
import java.util.List;

/**
 * V02 - Car showroom
 *
 * @author TUANLEACE180905
 */
public enum Car {
    AUDI(Arrays.asList(Color.WHITE, Color.YELLOW, Color.ORANGE, Color.NO_COLOR), Arrays.asList(5500, 3000, 4500), Arrays.asList(Day.FRIDAY, Day.SUNDAY, Day.MONDAY)),
    MERCEDES(Arrays.asList(Color.GREEN, Color.BLUE, Color.PURPLE, Color.NO_COLOR), Arrays.asList(5000, 6000, 8500), Arrays.asList(Day.TUESDAY, Day.SATURDAY, Day.WEDNESDAY)),
    BMW(Arrays.asList(Color.PINK, Color.RED, Color.BROWN, Color.NO_COLOR), Arrays.asList(2500, 3000, 3500), Arrays.asList(Day.MONDAY, Day.SUNDAY, Day.THURSDAY));

    private List<Color> colors;
    private List<Integer> prices;
    private List<Day> days;

    /**
     * Private constructor for Car enum.
     */
    private Car() {
    }

    /**
     * Constructs a Car enum with specified colors, prices, and available sale
     * days.
     *
     * @param colors List of available colors.
     * @param prices List of available prices.
     * @param days List of sale days.
     */
    private Car(List<Color> colors, List<Integer> prices, List<Day> days) {
        this.colors = colors;
        this.prices = prices;
        this.days = days;
    }

    /**
     * Retrieves a Car enum by its name prefix.
     *
     * @param car The name prefix of the car.
     * @return The corresponding Car enum, or null if not found.
     */
    public static Car getCar(String car) {
        for (Car c : Car.values()) {
            if (c.name().startsWith(car)) {
                System.out.println("You have chosen: " + c.name());
                return c;
            }
        }
        return null;
    }

    /**
     * Gets the available colors for the car.
     *
     * @return List of colors.
     */
    public List<Color> getColors() {
        return colors;
    }

    /**
     * Gets the available sale days for the car.
     *
     * @return List of sale days.
     */
    public List<Day> getDays() {
        return days;
    }

    /**
     * Gets the available prices for the car.
     *
     * @return List of prices.
     */
    public List<Integer> getPrices() {
        return prices;
    }
}
