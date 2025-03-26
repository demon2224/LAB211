/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v11;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author TUANLEACE180905
 */
public class CSVFormatter {

    // ArrayList to store CSV data, where each row is represented by a String array.
    private ArrayList<String[]> dataCSV;

    // Variable to store informational messages (e.g., status of operations).
    private String info;

    /**
     * Constructor initializes the ArrayList.
     */
    public CSVFormatter() {
        this.dataCSV = new ArrayList<>();
    }

    /**
     * Gets the current info message which contains status updates.
     *
     * @return the info message.
     */
    public String getInfo() {
        return info;
    }

    /**
     * Imports CSV data from the specified file path. It reads the file line by
     * line, splits each line by commas, and adds the resulting array to the
     * dataCSV list.
     *
     * @param path The file path of the CSV file.
     */
    public void importCSV(String path) {
        File file = new File(path);
        if (!file.exists()) {
            this.info = "File not found: " + path;
            return;
        }

        if (file.length() == 0) {
            this.info = "File is empty. No data to read.";
            return;
        }

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                dataCSV.add(parts);
            }
            this.info = "Import: Done";
        } catch (Exception e) {
            this.info = "Error reading file: " + e.getMessage();
        }
    }

    /**
     * Formats the 'Name' field (second column) in each row of the CSV data.
     * Each name is normalized so that the first letter of each word is
     * capitalized and the remaining letters are in lowercase.
     */
    public void formatName() {
        if (dataCSV.isEmpty()) {
            this.info = "No CSV data imported.";
            return;
        }
        for (String[] str : dataCSV) {
            if (str.length >= 2) {
                str[1] = getNormalizedString(str[1]);
            }
        }
        this.info = "-------Format: Done";
    }

    /**
     * Formats the 'Address' field (fifth column) in each row of the CSV data.
     * Extra spaces are removed, and each word in the address is normalized so
     * that the first letter is capitalized and the rest are in lowercase.
     */
    public void formatAddress() {
        if (dataCSV.isEmpty()) {
            this.info = "No CSV data imported.";
            return;
        }
        for (String[] str : dataCSV) {
            if (str.length >= 5) {
                str[4] = str[4].replaceAll("-+", "-").trim();
                str[4] = str[4].replaceAll("\\s+", " ").trim();
                String[] parts = str[4].split("-");
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < parts.length; i++) {
                    sb.append(getNormalizedString(parts[i]));
                    if (i < parts.length - 1) {
                        sb.append(" - ");
                    }
                }
                str[4] = sb.toString();
            }
        }
        this.info = "-------Format: Done";
      
    }

    /**
     * Normalizes a string so that each word has its first letter in uppercase
     * and all subsequent letters in lowercase.
     *
     * @param str The input string to be normalized.
     * @return The normalized string with proper capitalization.
     */
    public String getNormalizedString(String str) {
        StringBuilder sb = new StringBuilder();
        String[] parts = str.split("\\s+");
        for (String string : parts) {
            if (string.length() > 0) {
                sb.append(Character.toUpperCase(string.charAt(0)));
                for (int i = 1; i < string.length(); i++) {
                    sb.append(Character.toLowerCase(string.charAt(i)));
                }
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    /**
     * Exports the current CSV data to a file at the specified path. Each row is
     * written to the file, with fields separated by commas.
     *
     * @param path The file path where the CSV will be exported.
     */
    public void exportCSV(String path) {
        try (PrintWriter fileWriter = new PrintWriter(new FileWriter(path))) {
            for (String[] str : dataCSV) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < str.length; i++) {
                    sb.append(str[i]);
                    if (i < str.length - 1) {
                        sb.append(","); // Add a comma between fields.
                    }
                }
                fileWriter.println(sb.toString()); // Write the line to the file.
            }
            this.info = "Export: Done";
        } catch (Exception e) {
            this.info = "Error saving file: " + e.getMessage();
        }
    }
}
