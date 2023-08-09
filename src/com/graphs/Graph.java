package com.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    void bfs(int source) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[source] = true;
        queue.offer(source);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for(int neigh : adjacencyList[current]) {
                if(!visited[neigh]) {
                    visited[neigh] = true;
                    queue.offer(neigh);
                }
            }
        }
    }

    void dfs(int source) {
        boolean[] visited = new boolean[vertices];
        dfs(source, visited);
    }

    private void dfs(int source, boolean[] visited) {

        visited[source] = true;
        System.out.print(source + " ");
        for(int in : adjacencyList[source]) {
            if(!visited[in]) {
                dfs(in, visited);
            }
        }

    }

}
