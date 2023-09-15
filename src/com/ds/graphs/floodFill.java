package com.ds.graphs;

public class floodFill {
    void printCharArray(char[][] charArray) {
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray[i].length; j++) {
                System.out.print(charArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    void printIntArray(int[][] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            for (int j = 0; j < intArray[i].length; j++) {
                System.out.print(intArray[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        char[][] charArray = {
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '0', '0', '0', '0'},
                {'0', '0', '1', '0', '1'}
        };
        floodFill f = new floodFill();
//        f.printCharArray(charArray);
//
//        f.floodFillChar(charArray, 1, 3, '2');
//        f.printCharArray(charArray);

        int[][] intArr = {
                {1, 1, 1, 0, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1}
        };
        f.printIntArray(intArr);
    f.floodFill(intArr, 1,1,2);
        System.out.println();
        f.printIntArray(intArr);
        System.out.println();
        System.out.println();
        intArr =new int[][] {{0,0,0},{0,0,0},{0,0,0}};
        f.printIntArray(intArr);
        System.out.println();
        f.floodFill(intArr, 0,0,0);
        f.printIntArray(intArr);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int origColor = image[sr][sc];

        if (color == origColor) return image;

        dfsFloodFill(image, sr, sc, image.length, image[0].length, color, image[sr][sc]);
        return image;
    }


    private void dfsFloodFill(int[][] grid, int x, int y, int rows, int cols, int newVal, int src) {
        // base condition
        if(x <0 || x>=rows || y<0 || y>= cols || grid[x][y] != src || grid[x][y] != src) {
            return;
        }

        grid[x][y] = newVal;
        dfsFloodFill(grid, x-1,y, rows, cols, newVal, src);
        dfsFloodFill(grid, x+1,y, rows, cols, newVal, src);
        dfsFloodFill(grid, x,y-1, rows, cols, newVal, src);
        dfsFloodFill(grid, x,y+1, rows, cols, newVal, src);
    }

    private void dfsFloodFillChar(char[][] grid, int x, int y, int rows, int cols, char newVal) {
        // base condition
        if(x <0 || x>=rows || y<0 || y>= cols || grid[x][y] != '1') {
            return;
        }

        grid[x][y] = newVal;
        dfsFloodFillChar(grid, x-1,y, rows, cols, newVal);
        dfsFloodFillChar(grid, x+1,y, rows, cols, newVal);
        dfsFloodFillChar(grid, x,y-1, rows, cols, newVal);
        dfsFloodFillChar(grid, x,y+1, rows, cols, newVal);
    }

    private void floodFillChar(char[][] charArray, int i, int i1, char c) {
        dfsFloodFillChar(charArray, i, i1, charArray.length, charArray[0].length, c);
    }


}
