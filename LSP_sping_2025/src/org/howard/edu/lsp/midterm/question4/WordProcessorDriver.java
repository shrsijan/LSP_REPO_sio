package org.howard.edu.lsp.midterm.question4;

import java.util.List;

/**
 * The WordProcessorDriver class tests the functionality of the WordProcessor class.
 * References
 *  - Lecture Notes
 *  - Assignment 2
 *  - Software engineering frameworks notes
 */
public class WordProcessorDriver {
    public static void main(String[] args) {
        // Test case 1: Sentence with single longest word
        WordProcessor wp1 = new WordProcessor("This is a test with amazing results amazing achievements");
        List<String> longestWords1 = wp1.findLongestWords();
        System.out.println("Test 1 - Longest words: " + longestWords1);
        // Expected Output: ["achievements"]

        // Test case 2: Sentence with multiple occurrences of the same longest word and length
        WordProcessor wp2 = new WordProcessor("Java is a powerful tool");
        List<String> longestWords2 = wp2.findLongestWords();
        System.out.println("Test 2 - Longest words: " + longestWords2);
        // Expected Output: ["powerful"]

        // Test case 3: Sentence with words of the same length
        WordProcessor wp3 = new WordProcessor("cat dog hat pen sun");
        List<String> longestWords3 = wp3.findLongestWords();
        System.out.println("Test 3 - Longest words: " + longestWords3);
        // Expected Output: ["cat", "dog", "hat", "pen", "sun"]

        // Test case 4: Sentence with single character words
        WordProcessor wp4 = new WordProcessor("A B C D E");
        List<String> longestWords4 = wp4.findLongestWords();
        System.out.println("Test 4 - Longest words: " + longestWords4);
        // Expected Output: ["A", "B", "C", "D", "E"]

        // Test case 5: Empty string input
        WordProcessor wp5 = new WordProcessor("");
        List<String> longestWords5 = wp5.findLongestWords();
        System.out.println("Test 5 - Longest words: " + longestWords5);
        // Expected Output: []
    }
}
