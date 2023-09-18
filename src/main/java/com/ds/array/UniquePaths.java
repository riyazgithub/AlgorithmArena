package com.ds.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 63. Unique Paths II
 */
public class UniquePaths {

    int pathCount = 0;
    List<List<Character>> paths = new ArrayList<>();
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==0 || obstacleGrid[obstacleGrid.length-1][obstacleGrid.length-1] ==0 )
            return pathCount;
        uniquePathsWithObstaclesHelp(obstacleGrid, 0, 0,obstacleGrid.length-1,obstacleGrid.length-1, new ArrayList<>());
//        this.pathCount = uniquePathsWithObstaclesHelp1(obstacleGrid, 0,0,2,2, new ArrayList<Character>());
        return pathCount;
    }

    private int uniquePathsWithObstaclesHelp1(int[][] obstacleGrid, int x, int y, int dx, int dy, List<Character> path) {
        // If we encounter an obstacle or go out of bounds, there is no path.
        if (x > dx || y > dy || obstacleGrid[x][y] == 1) {
            return 0;
        }

        // If we reach the destination, there is one path.
        if (x == dx && y == dy) {
            paths.add(new ArrayList<>(path));
            return 1;
        }

        // Explore right and down directions recursively.
        path.add('R');
        int rightPaths = uniquePathsWithObstaclesHelp1(obstacleGrid, x + 1, y, dx, dy, path);
        path.remove(path.size()-1);
        path.add('D');
        int downPaths = uniquePathsWithObstaclesHelp1(obstacleGrid, x, y + 1, dx, dy, path);
        path.remove(path.size()-1);
        // Return the sum of paths going right and down.
        return rightPaths + downPaths;
    }
    private void uniquePathsWithObstaclesHelp(int[][] obstacleGrid, int x, int y, int dx, int dy, List<Character> path) {
        // base condition
        if(x==dx && y == dy) {
            this.pathCount++;
            paths.add(new ArrayList<>(path));
            return;
        }
        if(x>dx || y> dy || obstacleGrid[x][y] == 1){
            // no Path
            return;
        }
            path.add('R');
            uniquePathsWithObstaclesHelp(obstacleGrid, x+1, y, dx, dy, path);
            path.remove(path.size()-1);
            path.add('D');
            uniquePathsWithObstaclesHelp(obstacleGrid, x, y+1, dx, dy, path);
            path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        int[][] og = new int[][]{
                {0,0,0},
        {0,1,0},
        {0,0,0}
        };
        UniquePaths up = new UniquePaths();
        up.pathCount=0; up.paths = new ArrayList<>();
        up.pathCount = up.uniquePathsWithObstacles(og);
        System.out.println("Path Count "+up.pathCount);
        System.out.println("Paths "+up.paths);
    }
}
