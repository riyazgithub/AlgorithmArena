package com.ds.heap;

import java.util.PriorityQueue;

public class kthposition {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for(int[] p : points) {
            pq.offer(p);
            if(pq.size() > k) { // If the size of heap is more than k then remove the smallest element
                System.out.println("Current size "+pq.size());
                //printing pq
                for(int[] i : pq) {
                    System.out.print("["+i[0]+","+i[1]+"]");
                }
                System.out.println();
                pq.poll();
            }
        }
        int[][] res = new int[k][2];
        while (k>0) {
            res[--k] = pq.poll();
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] points = {
                {1, 3},
                {-2, 2},
                {1,1},
                {0,0},
                {-1,-2}
        };

        kthposition k = new kthposition();
        int[][] res = k.kClosest(points, 2);

        for(int[] p : res) {
            System.out.println(p[0] + " " + p[1]);
        }
    }
}
