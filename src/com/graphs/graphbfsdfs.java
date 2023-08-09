package com.graphs;

public class graphbfsdfs {
    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 5);
        graph.addEdge(2, 4);
        graph.addEdge(5, 3);
        graph.addEdge(3, 6);
        graph.addEdge(3, 7);
        graph.addEdge(4, 8);

        System.out.println("BFS starting from vertex 0:");
//        graph.bfs(0);
        System.out.println();

        System.out.println("DFS starting from vertex 0:");
        graph.dfs(0);
    }
}
