package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * This is question 3, implementation for a simple voting machine
 * Here VotingMachine class represents a simple electronic voting system
 * this allows voters to cast votes for candidates and display election results.
 * References:
 *  - Assignment 2
 *  - Lecture notes
 *  - javadoc documentation
 */
public class VotingMachine {
    private Map<String, Integer> candidates;

    // initializing the voting machine with an empty candidate list.
    public VotingMachine() {
        candidates = new HashMap<>();
    }

    /**
     * Adds a candidate to the voting machine.
     *
     * @param name The name of the candidate to be added.
     */
    public void addCandidate(String name) {
        candidates.putIfAbsent(name, 0);
    }

    /**
     * Casts a vote for a given candidate.
     *
     * @param name The name of the candidate receiving the vote.
     * @return true if the vote was successful, false if the candidate does not exist.
     */
    public boolean castVote(String name) {
        if (candidates.containsKey(name)) {
            candidates.put(name, candidates.get(name) + 1);
            return true;
        }
        return false;
    }

    /**
     * Determines the winner based on the highest number of votes.
     *
     * @return The name of the winning candidate with their vote count, or a message if no votes are cast.
     */
    public String getWinner() {
        String winner = null;
        int maxVotes = 0;

        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        return (winner != null) ? winner + " WINS with " + maxVotes + " votes!!" : "No votes have been cast.";
    }
}
