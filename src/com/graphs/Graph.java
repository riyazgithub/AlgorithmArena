package com.graphs;

import java.util.LinkedList;
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

    void addEdgeDirected(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    boolean addEdgeDirectedWithLoopCheck(int source, int destination) {
        adjacencyList[source].add(destination);
        return adjacencyList[destination].indexOf(source) == -1;
    }


    void addEdgeUnDirected(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source);
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
    void dfs(int source, boolean[] visited) {

        visited[source] = true;
        System.out.print(source + " ");
        for(int in : adjacencyList[source]) {
            if(!visited[in]) {
                dfs(in, visited);
            }
        }
    }

    boolean check_if_eulerian_cycle_exists() {
        // check if all the vertices have  even edges

        for(LinkedList<Integer> integerLinkedList : adjacencyList){
            if(integerLinkedList.size() % 2 != 0)
                return false;
        }

        boolean[] visited = new boolean[vertices];
        for(int i = 0; i < vertices; i++) {
            if(!visited[i]) {
                dfs(i, visited);
            }
        }

        // There are some vertex thats not parsed
        for(int i = 0; i < vertices; i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }

}
