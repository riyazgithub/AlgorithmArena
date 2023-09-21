package com.ds.graphs;

public class BiPartiteGraph {

    public static void main(String[] args) {
        BiPartiteGraph bipartiteGraph = new BiPartiteGraph();
        int[][] graph = {
                {1, 3, 5},
                {0, 2, 6},
                {1, 3},
                {0, 2, 4},
                {3},
                {0},
                {1}
        };
        boolean isBipartite = bipartiteGraph.isBipartite(graph);
        System.out.println("Is the graph bipartite? " + isBipartite);
    }

    private boolean isBipartite(int[][] graph) {

        return true;
    }
}
