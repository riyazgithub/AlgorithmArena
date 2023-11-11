package com.ds.graphs;

import java.util.*;

public class CheckGraphVAlid {
    public boolean validTree(int n, int[][] edges) {

        // Construct adjacency matrix

        HashMap<Integer, Integer> parent = new HashMap<>();
// Initialize the adjacency matrix
        ArrayList<ArrayList<Integer>> adjMatrix = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjMatrix.add(new ArrayList<>());
            parent.put(i, -1);
        }

// Populate the adjacency matrix based on the edges
        for (int[] edge : edges) {
            adjMatrix.get(edge[0]).add(edge[1]);
            adjMatrix.get(edge[1]).add(edge[0]); // For undirected graph
        }

        Set<Integer> visited = new HashSet<>();
        if(!modifiedDFS(adjMatrix, parent, visited, 0) && visited.size() == n) {
            return true;
        }
        // initialize visited and parent (parent is for finding the  cycle)
        return false;
    }

    private boolean modifiedDFS(ArrayList<ArrayList<Integer>> adjMatrix, HashMap<Integer, Integer> parent, Set<Integer> visited, Integer src) {
        visited.add(src);
        for (Integer neighbour : adjMatrix.get(src)) {
         if(!visited.contains(neighbour)) {
             parent.put(neighbour, src);
             if(modifiedDFS(adjMatrix, parent,visited, neighbour)){
                 return true;
             }
         } else if(!Objects.equals(parent.getOrDefault(src, -1), neighbour)){
             // has a cycle (back edge)
             return true;
         }
        }
        return false;
    }

    /**
     * Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
     * Output: true
     *
     *Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
     * Output: false
     */

    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{0,3},{1,4},{5,6}};
        CheckGraphVAlid cvg = new CheckGraphVAlid();
        System.out.println(cvg.validTree(7, edges));
        edges = new int[][] {{0,1},{1,2},{2,3},{1,3},{1,4}};
        System.out.println(cvg.validTree(5, edges));
    }
}
