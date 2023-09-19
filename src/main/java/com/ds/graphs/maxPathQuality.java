package com.ds.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Copy
 *
 *
 */
public class maxPathQuality {
    int ans;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        // Create an adjacency list to represent the graph.
        List<List<int[]>> adjList = new ArrayList<>();

        // Initialize the adjacency list with empty lists for each node.
        for (int i : values) {
            adjList.add(new ArrayList<>());
        }

        // Populate the adjacency list with edges and their weights.
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(new int[] { edge[1], edge[2] });
            adjList.get(edge[1]).add(new int[] { edge[0], edge[2] });
        }

        // Initialize an array to keep track of visited nodes.
        int[] visited = new int[values.length];

        // Initialize the answer variable to store the maximum score.
        ans = 0;

        // Start solving the problem recursively.
        solve(values, adjList, visited, 0, maxTime, 0, 0);

        // Return the maximum score as the result.
        return ans;
    }

    // Helper function for recursive traversal and scoring.
    void solve(int[] values, List<List<int[]>> adjList, int[] visited, int node, int maxTime, int currTime, int score) {
        // If the current time exceeds the maximum allowed time, return.
        if (currTime > maxTime) {
            return;
        }

        // If the node is visited for the first time, add its value to the score.
        if (visited[node] == 0) {
            score += values[node];
        }

        // If the current node is the starting node (node 0), update the maximum score.
        if (node == 0) {
            ans = Math.max(ans, score);
        }

        // Mark the current node as visited.
        visited[node]++;

        // Recursively explore neighboring nodes.
        for (int[] v : adjList.get(node)) {
            solve(values, adjList, visited, v[0], maxTime, currTime + v[1], score);
        }

        // Mark the current node as unvisited for backtracking.
        visited[node]--;
    }

    public static void main(String[] args) {
        int[] values1 = {0, 32, 10, 43};
        int[][] edges1 = {{0, 1, 10}, {1, 2, 15}, {0, 3, 10}};
        int maxTime1 = 49;
        maxPathQuality mx = new maxPathQuality();
        System.out.println(mx.maximalPathQuality(values1,edges1,maxTime1));
    }
}
