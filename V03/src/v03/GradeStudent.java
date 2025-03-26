/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v03;

/**
 * V03 - Grade Student program Handles user interaction and program flow
 *
 * @author TUANLEACE180905
 */
public class GradeStudent {

    private int totalWeight;
    private double midScore;
    private double finalScore;
    private double homeScore;

    /**
     * The constructor
     */
    public GradeStudent() {
        totalWeight = 0;
    }

    /**
     * Begins the program by displaying an introduction message and calling
     * methods to calculate midterm, final term, and homework scores, then
     * reporting the overall grade.
     */
    public void begin() {
        System.out.println("This program reads exam/homework scores and reports your overall course grade\n");

        // Calling methods to handle each component of the grade
        System.out.println(midTerm());
        System.out.println(finalTerm());
        System.out.println(homework());
        System.out.print(report());
    }

    /**
     * Handles the midterm exam input and calculation.
     *
     * @return A formatted string with midterm score details.
     */
    public String midTerm() {
        String message = "";
        System.out.println("Midterm:");
        System.out.print("Weight (0-99)? ");
        int midWeight = MyLib.getInt(0, 99);

        // Process only if the midterm has a positive weight
        if (midWeight > 0) {
            this.totalWeight += midWeight;

            System.out.print("Score earned? ");
            this.midScore = MyLib.getInt(1, 10);

            // Allow score shifting if initial score is below 100
            if (this.midScore < 10) {
                System.out.print("Were scores shifted (1 = yes, 2 = no)? ");
                int shiftOption = MyLib.getInt(1, 2);

                // Apply score shift if chosen
                if (shiftOption == 1) {
                    System.out.print("Shift amount? ");
                    int shiftAmount = MyLib.getIntGreaterThan(0); // Must be positive
                    this.midScore += shiftAmount;

                    // Ensure score does not exceed 100
                    if (this.midScore > 10) {
                        this.midScore = 10;
                    }
                }
            }
        }

        // Format and return midterm results
        message += "Total points = " + String.format("%.0f", this.midScore) + " /10\n";
        this.midScore = (this.midScore / 10) * midWeight;
        message += "Weighted score = " + String.format("%.1f", this.midScore) + " / " + midWeight + "\n";

        return message;
    }

    /**
     * Handles the final exam input and calculation.
     *
     * @return A formatted string with final exam score details.
     */
    public String finalTerm() {
        String message = "";
        int finalWeight;
        System.out.println("Final:");

        // Ensure final weight does not exceed total weight limit
        do {
            System.out.print("Weight (1-" + (100 - this.totalWeight) + ")? ");
            finalWeight = MyLib.getInt(1, (100 - this.totalWeight));
            if (this.totalWeight + finalWeight > 100) {
                System.out.println("Total weight must be less than or equal to 100! Please enter again!");
            }
        } while (this.totalWeight + finalWeight > 100);

        this.totalWeight += finalWeight;

        System.out.print("Score earned? ");
        this.finalScore = MyLib.getInt(1, 10);

        // Allow score shifting if initial score is below 100
        if (this.finalScore < 10) {
            System.out.print("Were scores shifted (1 = yes, 2 = no)? ");
            int shiftOption = MyLib.getInt(1, 2);

            if (shiftOption == 1) {
                System.out.print("Shift amount? ");
                int shiftAmount = MyLib.getIntGreaterThan(0);
                this.finalScore += shiftAmount;

                if (this.finalScore > 10) {
                    this.finalScore = 10;
                }
            }
        }

        message += "Total points = " + String.format("%.0f", this.finalScore) + " /10\n";
        this.finalScore = (this.finalScore / 10) * finalWeight;
        message += "Weighted score = " + String.format("%.1f", this.finalScore) + " / " + finalWeight + "\n";

        return message;
    }

    /**
     * Handles the homework score input and calculation.
     *
     * @return A formatted string with homework score details.
     */
    public String homework() {
        String message = "";
        int homeWeight = 100 - this.totalWeight;
        System.out.println("Homework: ");
        System.out.println("Weight = " + homeWeight);
        this.totalWeight += homeWeight;
        int numAss;
        if (homeWeight > 0) {
            System.out.print("Number of assignments? ");
            numAss = MyLib.getInt(1, 6);
            int sumScoreEarned = 0;
            int sumMaxScoreEarned = 0;

            // Collect scores for each assignment
            for (int i = 0; i < numAss; i++) {
                System.out.print("Assignment " + (i + 1) + " score and max? ");
                String scoreAndMax = MyLib.getScoreAndMax();
                String[] array = scoreAndMax.split(" ");
                sumScoreEarned += Integer.parseInt(array[0]);
                sumMaxScoreEarned += Integer.parseInt(array[1]);
            }

            // Get attendance points
            System.out.print("How many sections did you attend? ");

            int attend;
            if (numAss != 6) {
                attend = MyLib.getInt(numAss, 6);
            } else {
                attend = 6;
            }

            message += "Section points = " + (attend * 5) + " / 30\n";
            message += "Total points = " + (sumScoreEarned + attend * 5) + " / " + (sumMaxScoreEarned + 30) + "\n";
            this.homeScore = (((double) (sumScoreEarned + attend * 5)) / (sumMaxScoreEarned + 30)) * homeWeight;
            message += "Weighted score = " + String.format("%.1f", this.homeScore) + " / " + homeWeight + "\n";
        }

        return message;
    }

    /**
     * Calculates and reports the overall percentage and estimated GPA.
     *
     * @return A formatted string with final grade details.
     */
    public String report() {
        String message = "";

        double overall = this.midScore + this.finalScore + this.homeScore;
        double gpa;

        char rank;

        if (overall >= 85) {
            gpa = 4.0;
            rank = 'A';
        } else if (overall >= 70) {
            gpa = 3.0;
            rank = 'B';
        } else if (overall >= 55) {
            gpa = 2.0;
            rank = 'C';
        } else if (overall >= 40) {
            gpa = 1.0;
            rank = 'D';
        } else {
            gpa = 0.0;
            rank = 'F';
        }

        message += "Overall percentage = " + String.format("%.1f", overall) + "\n";
        message += "Your grade will be at least: " + String.format("%.1f", gpa) + "\n";
        message += "Your grade will rank: " + rank + "\n";

        return message;
    }
}
