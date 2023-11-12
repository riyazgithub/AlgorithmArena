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
