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
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    /**
     * Retrieves a day from the enumeration based on the provided string.
     *
     * @param day The input string representing a day (case-sensitive, should
     * match the start of the day's name).
     * @return The corresponding Day enum value, or null if no match is found.
     */
    public static Day getDay(String day) {
        for (Day d : Day.values()) {
            if (d.name().startsWith(day)) {
                System.out.println("You have chosen: " + d.name());
                return d;
            }
        }
        return null;
    }

}
