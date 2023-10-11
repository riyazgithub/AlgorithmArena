package com.ds.graphs;

public class graphbfsdfs {
    public static void main(String[] args) {
        GraphNode graphNode = new GraphNode(9);
        graphNode.addEdgeDirected(0, 1);
        graphNode.addEdgeDirected(0, 2);
        graphNode.addEdgeDirected(1, 5);
        graphNode.addEdgeDirected(2, 4);
        graphNode.addEdgeDirected(5, 3);
        graphNode.addEdgeDirected(3, 6);
        graphNode.addEdgeDirected(3, 7);
        graphNode.addEdgeDirected(4, 8);

        System.out.println("BFS starting from vertex 0:");
//        graphNode.bfs(0);
        System.out.println();

        System.out.println("DFS starting from vertex 0:");
        graphNode.dfs(0);

        GraphNode unDirectedGraphNode = new GraphNode(9);
        unDirectedGraphNode.addEdgeUnDirected(0, 1);
        unDirectedGraphNode.addEdgeUnDirected(0, 2);
        unDirectedGraphNode.addEdgeUnDirected(1, 5);
        unDirectedGraphNode.addEdgeUnDirected(2, 4);
        unDirectedGraphNode.addEdgeUnDirected(5, 3);
        unDirectedGraphNode.addEdgeUnDirected(3, 6);
        unDirectedGraphNode.addEdgeUnDirected(3, 7);
        unDirectedGraphNode.addEdgeUnDirected(4, 8);

//        System.out.println("Undirected graphNode -- "+ unDirectedGraphNode.check_if_eulerian_cycle_exists());

        unDirectedGraphNode = new GraphNode(5);
        unDirectedGraphNode.addEdgeUnDirected(0, 1);
        unDirectedGraphNode.addEdgeUnDirected(1, 2);
        unDirectedGraphNode.addEdgeUnDirected(2, 3);
        unDirectedGraphNode.addEdgeUnDirected(3, 4);
        unDirectedGraphNode.addEdgeUnDirected(0, 4);

        System.out.println("Undirected graphNode -- "+ unDirectedGraphNode.check_if_eulerian_cycle_exists());

    }
}
