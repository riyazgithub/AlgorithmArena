package com.concepts.dynamicP;

import java.util.Arrays;

/**
 * Unique Paths
 * Given a grid of size n x m and a robot initially staying at the top-left position, return the number of unique paths for the robot to reach the bottom-right corner of the grid. The robot is allowed to move either down or right at any point in time.
 */
public class UniquePaths {
    static Integer unique_paths(Integer m, Integer n) {
        Integer[] previousRow = new Integer[n];
        Integer[] currentRow = new Integer[n];

        // Initialize the first row to 1
        Arrays.fill(previousRow, 1);

        for (int i = 1; i < m; i++) {
            currentRow[0] = 1; // Initialize the first column to 1
            for (int j = 1; j < n; j++) {
                currentRow[j] = currentRow[j - 1] + previousRow[j];
            }
            System.arraycopy(currentRow, 0, previousRow, 0, n);
        }

        return currentRow[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(unique_paths(1000,1000));
        System.out.println(unique_paths(4,1));
    }
}
