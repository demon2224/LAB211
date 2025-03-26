/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v02;

/**
 * V02 - Car showroom
 *
 * @author TUANLEACE180905
 */
public enum Color {
    WHITE, YELLOW, ORANGE, GREEN, BLUE, PURPLE, PINK, RED, BROWN, NO_COLOR;

    /**
     * Retrieves a color from the enumeration based on the provided string.
     *
     * @param color The input string representing a color (case-sensitive,
     * should match the start of the color's name).
     * @return The corresponding Color enum value, or null if no match is found.
     */
    public static Color getColor(String color) {
        for (Color c : Color.values()) {
            if (c.name().startsWith(color)) {
                System.out.println("You have chosen: " + c.name());
                return c;
            }
        }
        return null;
    }
}
