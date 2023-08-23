package com.graphs;

/**
 * https://leetcode.com/problems/number-of-islands/
 *
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 */
public class numberOfIslands {
        public int numIslands(char[][] grid) {
        int countOfIslands = 0;
        for(int i = 0; i< grid.length;i++) {
            for (int j=0; j<grid[i].length; j++)
                if(grid[i][j] == '1')
                {
                    countOfIslands++;
                    dfsIslands(grid, i, j, grid.length, grid[i].length);
                }
        }
        return countOfIslands;
    }

    private void dfsIslands(char[][] grid, int x, int y, int rows, int cols) {
        // base condition
        if(x <0 || x>=rows || y<0 || y>= cols || grid[x][y] != '1') {
            return;
        }

        grid[x][y] = '0';
        dfsIslands(grid, x-1,y, rows, cols);
        dfsIslands(grid, x+1,y, rows, cols);
        dfsIslands(grid, x,y-1, rows, cols);
        dfsIslands(grid, x,y+1, rows, cols);
    }
    public static void main(String[] args) {

        numberOfIslands n = new numberOfIslands();
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','1','0'},
                {'0','0','1','0','0'},
                {'1','0','0','0','1'}
        };
        System.out.println(n.numIslands(grid));
    }

}
