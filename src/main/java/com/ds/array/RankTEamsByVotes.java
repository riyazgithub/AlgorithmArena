package com.ds.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1366. Rank Teams by Votes
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
public class RankTEamsByVotes {
    public String rankTeams(String[] votes) {

        int teams = votes[0].length();

        int[][] scores = new int[26][teams+1];

        for(int i = 0; i<26; i++){
            scores[i][0] = i;
        }

        for(String vote : votes){
            char[] arr =  vote.toCharArray();
            for(int i=0; i<arr.length; i++){
                scores[arr[i]-'A'][i+1]++;
            }
        }

        Comparator<int[]> comp = new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2){
                for(int i=1; i<=teams; i++){
                    if(i1[i] != i2[i])
                        return i2[i] - i1[i];
                }
                return i1[0] - i2[0];
            }
        };

        Arrays.sort(scores, comp);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<26; i++){
            sb.append((char) (scores[i][0] + 'A'));
            if(sb.length() == teams)
                break;
        }

        return sb.toString();
    }
}
