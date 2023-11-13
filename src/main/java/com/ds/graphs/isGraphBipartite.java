package com.ds.graphs;

import java.util.*;

public class isGraphBipartite {

    public static void main(String[] args) {
        isGraphBipartite bipartite = new isGraphBipartite();
        int[][] graph = new int[][]{
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };
        System.out.println(bipartite.isBipartite(graph));
        graph = new int[][]{
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };
        System.out.println(bipartite.isBipartite(graph));
        int[][] edges = new int[][] {{1,2},{1,3},{2,4}};
        graph = convertEdgesToGraph(edges, 4);
        System.out.println(Arrays.toString(graph));
        System.out.println("is "+ bipartite.possibleBipartition(4,graph));
    }

    private static int[][] convertEdgesToGraph(int[][] edges, int n) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]-1).add(edge[1]);
            graph.get(edge[1]-1).add(edge[0]);
        }
        // Find out the size of the largest inner ArrayList to ensure the 2D array can accommodate all values
        int maxSize = 0;
        for (ArrayList<Integer> row : graph) {
            maxSize = Math.max(maxSize, row.size());
        }

        // Create the 2D array with the size of the outer ArrayList as the number of rows
        // and maxSize as the number of columns.
        int[][] array = new int[graph.size()][maxSize];

        // Fill in the 2D array with values from the ArrayLists.
        // Note that we assume all inner ArrayLists have the same size for simplicity.
        // If they vary, you would need to create a jagged array.
        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                array[i][j] = graph.get(i).get(j);
            }
            // If an inner ArrayList is smaller than maxSize, we leave the remaining elements as 0.
        }

        return array;
    }


    public boolean possibleBipartition(int n, int[][] dislikes) {

        /**
         Build adjacency matrix
         initialize color matrix
         initialize stack and add src node to stack
         add color for src node
         loop until stack is empty
         *
         */
        int graphSize = n;
        int[] colors = new int[graphSize];
        Set<Integer> visited = new HashSet<>();
        Arrays.fill(colors, -1);
        // assuming 0 is the source need to revisit
        for (int start = 1; start <= graphSize; start++) {
            if (colors[start] == -1) {
                Stack<Integer> stack = new Stack<>();
                stack.push(start);
                colors[start] = 1;
                while (!stack.empty()) {
                    Integer curr = stack.pop();
                    visited.add(curr);
                    for (int neigh : dislikes[curr - 1]) {
                        if (colors[neigh] == -1 && neigh > 0) {
                            // new node not visited yet
                            colors[neigh] = (colors[curr] == 1) ? 0 : 1;
                            stack.push(neigh);
                        } else if (colors[neigh] == colors[curr] && neigh > 0) {
                            return false;
                        }
                    }
                }
            }
        }
        return visited.size() == graphSize;
    }
    public boolean isBipartite(int[][] graph) {

        /**
         Build adjacency matrix
         initialize color matrix
         initialize stack and add src node to stack
         add color for src node
         loop until stack is empty
         *
         */
        int graphSize = graph.length;
        int[] colors = new int[graphSize];
        Set<Integer> visited = new HashSet<>();
        Arrays.fill(colors, -1);
        // assuming 0 is the source need to revisit
        for (int start = 0; start < graphSize; start++) {
            if (colors[start] == -1) {
                Stack<Integer> stack = new Stack<>();
                stack.push(start);
                colors[start] = 0;
                while (!stack.empty()) {
                    Integer curr = stack.pop();
                    visited.add(curr);
                    for (int neigh : graph[curr]) {
                        if (colors[neigh] == -1) {
                            // new node not visited yet
                            colors[neigh] = (colors[curr] == 1) ? 0 : 1;
                            stack.push(neigh);
                        } else if (colors[neigh] == colors[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return visited.size() == graphSize;
    }
}
