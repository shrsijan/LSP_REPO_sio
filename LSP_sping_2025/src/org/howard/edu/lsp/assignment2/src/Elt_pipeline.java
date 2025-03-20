package org.howard.edu.lsp.assignment2.src;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Elt_pipeline {
    public static void main(String[] args) {
        // Define where the input and output CSV files are located
        String inputFilePath = "src/org/howard/edu/lsp/assignment2/data/products.csv";
        String outputFilePath = "src/org/howard/edu/lsp/assignment2/data/transformed_products.csv";

        try {
            List<String[]> updatedRecords = new ArrayList<>(); // Store processed records
            List<String> fileLines = Files.readAllLines(Paths.get(inputFilePath)); // Read the file

            // If file is empty, stop execution and show an error
            if (fileLines.isEmpty()) {
                throw new IOException("Input file is empty. Nothing to process.");
            }

            // Add a new column to the header
            String header = fileLines.get(0) + ",PriceRange";
            updatedRecords.add(header.split(","));

            // Process each row, skipping the first row (header)
            for (int i = 1; i < fileLines.size(); i++) {
                String[] rowData = fileLines.get(i).split(",");
                if (rowData.length != 4) continue; // Ignore rows that don't have enough data

                String productId = rowData[0];
                String originalProductName = rowData[1].toUpperCase(); // Convert name to uppercase
                String cleanedProductName = makeTitleCase(originalProductName); // Make first letters uppercase
                double price = Double.parseDouble(rowData[2]);
                String category = rowData[3];

                // If product is in Electronics category, apply a 10% discount
                if (category.equals("Electronics")) {
                    price *= 0.9; // Reduce price by 10%
                    price = Math.round(price * 100.0) / 100.0; // Round to two decimal places
                }

                // If price is above 500, mark it as "Premium Electronics"
                if (price > 500) {
                    category = "Premium Electronics";
                }

                // Determine which price range this product falls into
                String priceCategory = assignPriceRange(price);

                // Store the updated record
                updatedRecords.add(new String[]{productId, cleanedProductName, String.format("%.2f", price), category, priceCategory});
            }

            // Save the transformed data to a new CSV file
            saveToCSV(outputFilePath, updatedRecords);
            System.out.println("Processing finished. Data saved to: " + outputFilePath);
        } catch (IOException e) {
            System.err.println("An error occurred while handling the file: " + e.getMessage());
        }
    }

    // This method makes the first letter of each word uppercase, and the rest lowercase
    private static String makeTitleCase(String text) {
        String[] words = text.split(" ");
        StringBuilder formattedText = new StringBuilder();
        for (String word : words) {
            formattedText.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1).toLowerCase())
                    .append(" ");
        }
        return formattedText.toString().trim();
    }

    // Determines the price category based on given price value
    private static String assignPriceRange(double price) {
        if (price <= 10) return "Low";
        else if (price <= 100) return "Medium";
        else if (price <= 500) return "High";
        else return "Premium";
    }

    // Writes transformed data to a CSV file
    private static void saveToCSV(String filePath, List<String[]> records) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            for (String[] record : records) {
                writer.write(String.join(",", record));
                writer.newLine();
            }
        }
    }
}
