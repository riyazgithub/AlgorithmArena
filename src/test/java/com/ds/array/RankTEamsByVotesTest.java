package com.ds.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTEamsByVotesTest {
    @Test
    public void testRankTeams() {
        RankTeamsByVotes solution = new RankTeamsByVotes();

        // Test case 1: Single vote, single team
//        String[] votes1 = { "A" };
//        assertEquals("A", solution.rankTeams(votes1));
//
//        // Test case 2: Single vote, multiple teams
//        String[] votes2 = { "ABCD" };
//        assertEquals("ABCD", solution.rankTeams(votes2));
//
//        // Test case 3: Multiple votes with the same order
//        String[] votes3 = { "ABCD", "ABCD", "ABCD" };
//        assertEquals("ABCD", solution.rankTeams(votes3));

        // Test case 4: Multiple votes with different orders
        String[] votes4 = { "ABC","ACB","ABC","ACB","ACB" };
        assertEquals("ACB", solution.rankTeams(votes4));
//
//        // Test case 5: Teams with the same score
//        String[] votes5 = { "ABCB", "CBAB", "BACA" };
//        assertEquals("ABCB", solution.rankTeams(votes5));
//
//        // Test case 6: Teams with different scores
//        String[] votes6 = { "ABCC", "CBAA", "BACA" };
//        assertEquals("ACB", solution.rankTeams(votes6));
    }
}