package com.ds.graphs;


import java.util.Deque;
        import java.util.HashMap;
        import java.util.LinkedList;
        import java.util.Map;

public class SnakeAndL {

    int[] numToRowCol(int n, int size, int maxSquare) {
        // Converts a board cell number to its corresponding row and column
        int row = (maxSquare - n) / size;
        int c = (n - 1) % (size*2);
        int col;
        if (c < size) {  // even row
            col = c;
        } else {  // odd row
            col = 2 * size - 1 - c;
        }
        return new int[]{row, col};
    }
    public int snakesAndLadders(int[][] board) {
        int size = board.length;
        int maxSquare = size * size;

        return minMoves(board,1, maxSquare, size);
    }


    // BFS to find the minimum number of moves to reach the end
    int minMoves(int[][] board, int n, int maxSquare, int size) {
        Deque<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> visited = new HashMap<>();
        visited.put(n, 0);
        queue.offer(n);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int next = curr + i;
                if (next > maxSquare) {
                    continue;
                }
                int[] rc = numToRowCol(next, size, maxSquare);
                int r = rc[0], c = rc[1];
                if (board[r][c] != -1) {
                    next = board[r][c];
                }
                if (!visited.containsKey(next)) {
                    queue.offer(next);
                    visited.put(next, visited.get(curr) + 1);
                    if (next == maxSquare) {
                        return visited.get(next);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SnakeAndL solution = new SnakeAndL();

        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
        int result = solution.snakesAndLadders(board);
        System.out.println("Minimum moves to reach the end: " + result);
    }
}
