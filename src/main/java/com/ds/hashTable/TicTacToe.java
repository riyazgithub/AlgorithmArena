package com.ds.hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TicTacToe {

    /**
     * Assume the following rules are for the tic-tac-toe game on an n x n board between two players:
     *
     * A move is guaranteed to be valid and is placed on an empty block.
     * Once a winning condition is reached, no more moves are allowed.
     * A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
     * Implement the TicTacToe class:
     *
     * TicTacToe(int n) Initializes the object the size of the board n.
     * int move(int row, int col, int player) Indicates that the player with id player plays at the cell (row, col) of the board. The move is guaranteed to be a valid move, and the two players alternate in making moves. Return
     * 0 if there is no winner after the move,
     * 1 if player 1 is the winner after the move, or
     * 2 if player 2 is the winner after the move.
     */

    /**
     * pseudocode
     * hashmap<string, list<Integer>> list contains -- spotfilled, samecells, playerid
     *
     * Place player
     * updatehashmapresult
     * validate placement
     * return based on validation
     *
     *
     */
    HashMap<String, List<Integer>> hmResult;
    int[][] matrix;
    public TicTacToe(int n) {
        matrix = new int[n][n];
        hmResult = new HashMap<>();
        for(int i =0; i< n; i++){
            hmResult.put("r"+i, new ArrayList<>());
            hmResult.put("c"+i, new ArrayList<>());
        }
        hmResult.put("cross1", new ArrayList<>());hmResult.put("cross2", new ArrayList<>());
    }

    public int move(int row, int col, int player) {
        // if all the moves are done check

        List<Integer> rowList = hmResult.get("r"+row);
        updateList(player, rowList);
        List<Integer> colList = hmResult.get("c"+col);
        updateList(player, colList);
        // cross check
        List<Integer> cross1 = hmResult.get("cross1");
        List<Integer> cross2 = hmResult.get("cross2");

        if(row == col){
            if(cross1.size()==0);

        }
        return -1;
    }

    private static void updateList(int player, List<Integer> rowColList) {
        if(rowColList.size() == 0) {
            rowColList.add(1);
            rowColList.add(1);
            rowColList.add(player);
        } else {
            if(rowColList.get(1)==1 && rowColList.get(2) == player) {
                rowColList.set(0, rowColList.get(0) +1);
            }else {
                rowColList.set(1,-1);
            }
        }
    }
}
