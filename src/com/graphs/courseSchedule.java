package com.graphs;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 207. Course Schedule
 * https://leetcode.com/problems/course-schedule/
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

 For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 Return true if you can finish all courses. Otherwise, return false.
 
 Steps 
 1.  Directional graph
 2. If theres a bidirectional edge return false
 3. Do DFs on src
 4. Check if all the nodes are visited
 
 */
public class courseSchedule {
    class Graph {
        private int vertices;
        private LinkedList<Integer>[] adjacencyList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        boolean addEdgeDirectedWithLoopCheck(int source, int destination) {
            adjacencyList[source].add(destination);
            return adjacencyList[destination].indexOf(source) == -1;
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
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses);
        if(!constructgraph(graph, prerequisites))
        {
            System.out.println("Loop exists so not possible");
            return false;
        }
        System.out.println("No Loop continuing");
        boolean[] visited = new boolean[numCourses];
        graph.dfs(prerequisites[0][0], visited);

        if(prerequisites.length == 0) return true;

        // checking if all the nodes are visited
        for(int i =0; i < visited.length; i++) {
            if(!visited[i]) {
                System.out.println("Cannot cover all courses "+ i);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[][] prerequisites = {
            {0, 1}
        };

        courseSchedule cs = new courseSchedule();
        System.out.println(cs.canFinish(2, prerequisites));
    }

    public boolean constructgraph(Graph graph, int[][] prerequisites) {

        for (int i =0; i< prerequisites.length; i++) {
            if(!graph.addEdgeDirectedWithLoopCheck(prerequisites[i][0], prerequisites[i][1]))
                return false;
        }
        return true;
    }
}
