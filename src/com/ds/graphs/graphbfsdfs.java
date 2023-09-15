package com.ds.graphs;

public class graphbfsdfs {
    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addEdgeDirected(0, 1);
        graph.addEdgeDirected(0, 2);
        graph.addEdgeDirected(1, 5);
        graph.addEdgeDirected(2, 4);
        graph.addEdgeDirected(5, 3);
        graph.addEdgeDirected(3, 6);
        graph.addEdgeDirected(3, 7);
        graph.addEdgeDirected(4, 8);

        System.out.println("BFS starting from vertex 0:");
//        graph.bfs(0);
        System.out.println();

        System.out.println("DFS starting from vertex 0:");
        graph.dfs(0);

        Graph unDirectedGraph = new Graph(9);
        unDirectedGraph.addEdgeUnDirected(0, 1);
        unDirectedGraph.addEdgeUnDirected(0, 2);
        unDirectedGraph.addEdgeUnDirected(1, 5);
        unDirectedGraph.addEdgeUnDirected(2, 4);
        unDirectedGraph.addEdgeUnDirected(5, 3);
        unDirectedGraph.addEdgeUnDirected(3, 6);
        unDirectedGraph.addEdgeUnDirected(3, 7);
        unDirectedGraph.addEdgeUnDirected(4, 8);

//        System.out.println("Undirected graph -- "+ unDirectedGraph.check_if_eulerian_cycle_exists());

        unDirectedGraph = new Graph(5);
        unDirectedGraph.addEdgeUnDirected(0, 1);
        unDirectedGraph.addEdgeUnDirected(1, 2);
        unDirectedGraph.addEdgeUnDirected(2, 3);
        unDirectedGraph.addEdgeUnDirected(3, 4);
        unDirectedGraph.addEdgeUnDirected(0, 4);

        System.out.println("Undirected graph -- "+ unDirectedGraph.check_if_eulerian_cycle_exists());

    }
}
