package com.ds.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1366. Rank Teams by Votes <copied>
 *
 * In a special ranking system, each voter gives a rank from highest to lowest to all teams participating in the competition.
 *
 * The ordering of teams is decided by who received the most position-one votes. If two or more teams tie in the first position, we consider the second position to resolve the conflict, if they tie again, we continue this process until the ties are resolved. If two or more teams are still tied after considering all positions, we rank them alphabetically based on their team letter.
 *
 * You are given an array of strings votes which is the votes of all voters in the ranking systems. Sort all teams according to the ranking system described above.
 *
 * Return a string of all teams sorted by the ranking system.
 *
 * Input: votes = ["ABC","ACB","ABC","ACB","ACB"]
 * Output: "ACB"
 *
 * Input: votes = ["WXYZ","XYZW"]
 * Output: "XWYZ"
 */
public class RankTeamsByVotes {
    public String rankTeams(String[] votes) {
        // Calculate the number of teams based on the length of the vote strings
        int teams = votes[0].length();

        // Create a 2D array to store team scores
        // Each row represents a team (A, B, C, ...) and has one extra element for team identification (0-based)
        // Each column represents the rank position (1st, 2nd, 3rd, ...) in the votes
        int[][] scores = new int[26][teams + 1];

        // Initialize the team identification in the first column
        for (int i = 0; i < 26; i++) {
            scores[i][0] = i;
        }

        // Process each vote
        for (String vote : votes) {
            char[] arr = vote.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                // Increment the score for the corresponding team and rank
                scores[arr[i] - 'A'][i + 1]++;
            }
        }

        // Create a custom comparator to sort teams based on their scores
        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                for (int i = 1; i <= teams; i++) {
                    if (i1[i] != i2[i]) {
                        // Compare teams based on their scores in each rank position
                        return i2[i] - i1[i];
                    }
                }
                // If scores are equal, compare teams based on their team identification
                return i1[0] - i2[0];
            }
        };

        // Sort the teams based on the custom comparator
        Arrays.sort(scores, comp);

        // Build the result string by appending team names based on their sorted order
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append((char) (scores[i][0] + 'A')); // Convert team identification to a character ('A', 'B', ...)
            if (sb.length() == teams) {
                // Stop when all teams are included in the result
                break;
            }
        }

        return sb.toString();
    }
}

