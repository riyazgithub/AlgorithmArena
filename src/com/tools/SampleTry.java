package com.tools;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SampleTry {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(5);
        minHeap.add(2);
        minHeap.add(8);
        minHeap.add(1);

        System.out.println("Min Priority Queue (Min Heap):");
        System.out.println("Min : "+minHeap.peek());
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();

        // Max Priority Queue (Custom comparator to reverse the order)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        maxHeap.add(5);
        maxHeap.add(2);
        maxHeap.add(8);
        maxHeap.add(1);

        System.out.println("Max Priority Queue (Max Heap):");
        System.out.println("Max : "+maxHeap.peek());
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println();
    }
}
