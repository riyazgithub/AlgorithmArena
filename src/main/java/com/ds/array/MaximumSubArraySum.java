package com.ds.array;

public class MaximumSubArraySum {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int[] maxEndHere = new int[n]; // Maximum sum subarray ending here without deletion
        int[] maxEndHereWithDeletion = new int[n]; // Maximum sum subarray ending here with one deletion

        maxEndHere[0] = arr[0];
        maxEndHereWithDeletion[0] = 0; // No element to delete at the start

        int maxSum = arr[0]; // Start with the first element

        for (int i = 1; i < n; i++) {
            // Calculate maxEndHere which is either the current element or current element + maxEndHere at i-1
            maxEndHere[i] = Math.max(arr[i], maxEndHere[i - 1] + arr[i]);

            // Calculate maxEndHereWithDeletion which is either maxEndHereWithDeletion at i-1 + current element
            // or just maxEndHere at i-1 (effectively deleting current element)
            maxEndHereWithDeletion[i] = Math.max(maxEndHereWithDeletion[i - 1] + arr[i], maxEndHere[i - 1]);

            // Update maxSum with the maximum value found so far
            maxSum = Math.max(maxSum, Math.max(maxEndHere[i], maxEndHereWithDeletion[i]));
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubArraySum solution = new MaximumSubArraySum();
        int[] arr = {1, -2, 0, 3};
        System.out.println("Output: " + solution.maximumSum(arr));
    }
}
