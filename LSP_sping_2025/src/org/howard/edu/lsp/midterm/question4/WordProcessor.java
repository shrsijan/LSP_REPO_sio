package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

/**
 * The WordProcessor class processes a sentence and returns all longest words.
 */
public class WordProcessor {
    private String sentence;

    /**
     * Constructor initializes the WordProcessor with a given sentence.
     *
     * @param sentence The sentence to be processed.
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Finds and returns all longest words in the sentence.
     *
     * @return A list of longest words appearing in the order they occur in the sentence.
     */
    public List<String> findLongestWords() {
        List<String> longestWords = new ArrayList<>();
        if (sentence == null || sentence.trim().isEmpty()) {
            return longestWords;
        }

        String[] words = sentence.split("\\s+");
        int maxLength = 0;

        for (String word : words) {
            int length = word.length();
            if (length > maxLength) {
                maxLength = length;
                longestWords.clear();
                longestWords.add(word);
            } else if (length == maxLength) {
                longestWords.add(word);
            }
        }
        return longestWords;
    }
}
