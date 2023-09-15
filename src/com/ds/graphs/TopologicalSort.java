package com.ds.graphs;

import java.util.*;

class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (vertices <= 0) {
            return sortedOrder;
        }

        // Build the graph and calculate in-degrees
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            graph.put(i, new ArrayList<>());
            inDegrees.put(i, 0);
        }
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            graph.get(parent).add(child);
            inDegrees.put(child, inDegrees.get(child) + 1);
        }

        // Find sources (vertices with in-degree of 0)
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegrees.entrySet()) {
            if (entry.getValue() == 0) {
                sources.offer(entry.getKey());
            }
        }

        // Process sources
        while (!sources.isEmpty()) {
            int source = sources.poll();
            sortedOrder.add(source);

            // Decrement in-degrees of children and find new sources
            for (int child : graph.get(source)) {
                inDegrees.put(child, inDegrees.get(child) - 1);
                if (inDegrees.get(child) == 0) {
                    sources.offer(child);
                }
            }
        }

        // If not all vertices are included in the sorted order, there's a cycle
        if (sortedOrder.size() != vertices) {
            return new ArrayList<>();
        }

        return sortedOrder;
    }

    public static void main(String[] args) {
        int vertices = 6;
        int[][] edges = {{3, 2}, {3, 0}, {4, 0}, {4, 1}, {5, 2}, {5, 4}};
        List<Integer> result = sort(vertices, edges);
        System.out.println(result);  // Output: [5, 4, 3, 0, 2, 1]
    }
}
